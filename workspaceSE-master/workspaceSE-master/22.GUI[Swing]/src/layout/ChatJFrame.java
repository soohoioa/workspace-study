package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class ChatJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatJFrame frame = new ChatJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatJFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChatJFrame.class.getResource("/image/4243324_ux_user_app_basic_icon.png")));
		setTitle("채팅");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("채팅방");
		lblNewLabel.setBackground(new Color(192, 192, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 22));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel southPanel = new JPanel();
		contentPane.add(southPanel, BorderLayout.SOUTH);
		
		textField = new JTextField();
		southPanel.add(textField);
		textField.setColumns(15);
		
		JButton btnNewButton = new JButton("전송");
		southPanel.add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setText("경호 : 있다가 만납시다!! \r\n태희 : 알았어~~");
		textArea.setEditable(false);
		contentPane.add(textArea, BorderLayout.CENTER);
	}

}
