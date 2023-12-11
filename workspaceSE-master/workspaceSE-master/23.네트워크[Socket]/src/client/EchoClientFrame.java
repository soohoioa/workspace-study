package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EchoClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField echoTF;
	private JScrollPane scrollPane;
	private JTextArea displayTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EchoClientFrame frame = new EchoClientFrame();
					frame.setVisible(true);
					frame.echoTF.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EchoClientFrame() {
		setTitle("EchoClientFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		echoTF = new JTextField();
		echoTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("TextField enter key...");
				/**************************************/
				try {
					String echoStr = echoTF.getText();
					if(echoStr.equals("")) {
						echoTF.requestFocus();
						return;
					}
					echoTF.setText("");
					echoTF.requestFocus();
					
					/*
					 * 1.Socket생성
					 */
					Socket socket = new Socket("192.168.15.2", 9999);
					
					/*
					 * 2.서버로문자데이타쓰기
					 * 		- OutputStream 얻기
					 * 		- OutputStream(byte) --> Writer(char)로 변경(OutputStreamWriter)
					 */
					OutputStream out = socket.getOutputStream();
					OutputStreamWriter osw = new OutputStreamWriter(out);
					PrintWriter pw = new PrintWriter(osw);
					pw.println(echoStr);
					pw.flush();
					// 규칙을 지키지 않으면 서버는 작동하지 않음..
					
					/*
					 * 3.서버에서 전송되는 데이타 읽기
					 * 		- InputStream 얻기
					 * 		- InputStream(byte) --> Reader(char)로 변경
					 */
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					String serverEchoStr = br.readLine();
					displayTA.append(serverEchoStr + "\n"); 
					
					socket.close();
					
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				/*************************************/
			}
		});
		echoTF.setFont(new Font("D2Coding", Font.BOLD, 18));
		
		contentPane.add(echoTF, BorderLayout.SOUTH);
		echoTF.setColumns(10);
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		displayTA = new JTextArea();
		displayTA.setFont(new Font("D2Coding", Font.BOLD, 17));
		displayTA.setEditable(false);
		scrollPane.setViewportView(displayTA);
		echoTF.requestFocus();
		
	}

}

