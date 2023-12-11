package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ChatClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField chatTF;
	private JScrollPane scrollPane;
	private JTextArea displayTA;
	/****** ClientClient[Thread]객체 멤버필드로 선언 ******/
	private ClientClient client;
	private JScrollPane westScrollPane;
	private JList chatList;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClientFrame frame = new ChatClientFrame();
					frame.setVisible(true);
					frame.chatTF.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public ChatClientFrame() throws Exception {
		setTitle("채팅클라이언트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		displayTA = new JTextArea();
		displayTA.setFont(new Font("나눔고딕코딩", Font.BOLD, 17));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);

		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.SOUTH);

		chatTF = new JTextField();
		chatTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { //클라이언트에서 서버로 전송작업
				/***********************/
				String chatStr = chatTF.getText();
				chatTF.setText("");
				if(chatStr.equals("")) {
					chatTF.requestFocus();
					return;
				}
				client.send("[" + client.getUserId() + "]" + chatStr);
				chatTF.requestFocus();
				/***********************/
			}
		});
		chatTF.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(chatTF);
		chatTF.setColumns(38);

		JButton sendB = new JButton("전송");
		sendB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/***********************/
				String chatStr = chatTF.getText();
				chatTF.setText("");
				if(chatStr.equals("")) {
					chatTF.requestFocus();
					return;
				}
				client.send("[" + client.getUserId() + "]" + chatStr);
				chatTF.requestFocus();
				/***********************/
			}
		});
		panel.add(sendB);

		westScrollPane = new JScrollPane();

		contentPane.add(westScrollPane, BorderLayout.WEST);

		chatList = new JList();
		chatList.setModel(new AbstractListModel() {
			String[] values = new String[] { "김경호", "김미호", "김웅호" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		westScrollPane.setViewportView(chatList);
		/******** ClientClientThread객체생성(Thread) *******/
		client = new ClientClient(new Socket("192.168.15.2", 8888));
		client.start();
		setTitle(client.getUserId() + " 님 안녕하세요.");
		
	}// 생성자

	private void displayMessage(String msg) {
		displayTA.append(msg + "\n");
		int maxSize = scrollPane.getVerticalScrollBar().getMaximum();
		scrollPane.getVerticalScrollBar().setValue(maxSize);
	}

	/**************************************************************
	  클라이언트쪽소켓을 사용하여 서버와 통신을 담당하는 클래스(VO) 
	  - 서버와연결된 소켓1개를 가지고있는클래스 
	  - 클라이언트의 정보를가지고있는 클래스 
	  - 클라이언트당 1개의객체가생성
	****************************************************************/
	public class ClientClient extends Thread {
		private String userId;
		private Socket socket; // 클라이언트쪽 소켓
		private PrintWriter out;
		private BufferedReader in;
		
		public ClientClient(Socket socket) throws Exception{
			this.socket = socket;
			this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));	
			this.userId = socket.getLocalAddress().getHostAddress() + "[" + socket.getLocalPort() + "]";
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		
		/*
		 * 클라이언트에서 서버로 데이타전송 (클라이언트는 소켓 한개 서버가 다 가지고있)
		 */
		public void send(String msg) {
			out.println(msg);
			out.flush();
		}
		
		
		/*
		 * 서버에서 보내는 데이타를 읽기
		 */
		@Override
		public void run() {
			try {
				while(true) {
				 System.out.println("A. ClientClient : 서버로부터 오는 데이타를 읽기위해 쓰레드 무한대기");
				 String chatStr = in.readLine();
				 System.out.println("B. ClientClient : 서버로부터 읽은 데이타를 클라이언트 채팅창에 보여준다.");
				 displayMessage(chatStr);
				 
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

}