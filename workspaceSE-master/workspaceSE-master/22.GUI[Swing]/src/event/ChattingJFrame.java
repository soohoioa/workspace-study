package event;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ChattingJFrame extends JFrame {

	private JPanel contentPane;
	JTextField chatTF;
	private JButton sendBtn;
	private JTextArea chatTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
			ChattingJFrame frame = new ChattingJFrame();
			frame.setVisible(true);
			frame.chatTF.requestFocus();
	}

	/**
	 * Create the frame.
	 */
	public ChattingJFrame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 357, 513);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 200, 0));
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("랜덤채팅");
		lblNewLabel
				.setIcon(new ImageIcon(ChattingJFrame.class.getResource("/image/small_dog20.png")));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		contentPane.add(panel_1, BorderLayout.SOUTH);

		chatTF = new JTextField();

		panel_1.add(chatTF);
		chatTF.setColumns(20);

		sendBtn = new JButton("전송");
		sendBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sendMessage = chatTF.getText();
				if(sendMessage.equals("")) {
					return;
				}
				chatTA.append("경호:"+sendMessage+"\n");
				chatTF.setText("");
				
			}
		});
		panel_1.add(sendBtn);

		chatTA = new JTextArea();
		chatTA.setEditable(false);

		chatTA.setText("경호:이따만나\r\n태희:아라써~~~~\n");
		contentPane.add(chatTA, BorderLayout.CENTER);
		
		
		
	}// 생성자

}