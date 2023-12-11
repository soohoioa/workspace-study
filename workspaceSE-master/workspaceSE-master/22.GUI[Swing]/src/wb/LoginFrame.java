package wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/image/4243324_ux_user_app_basic_icon.png")));
		setTitle("로그인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 330);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/50pomeranian.jpg")));
		lblNewLabel.setBounds(90, 0, 140, 291);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Login");
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 20));
		lblNewLabel_1.setBounds(285, 10, 158, 39);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(262, 76, 158, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(0, 0, 7, 21);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(262, 220, 158, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/4243324_ux_user_app_basic_icon.png")));
		lblNewLabel_2.setBounds(242, 76, 60, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/image/309058_key_login_private_protect_protection_icon.png")));
		lblNewLabel_3.setBounds(242, 129, 60, 20);
		contentPane.add(lblNewLabel_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(262, 129, 158, 21);
		contentPane.add(passwordField_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Remember");
		chckbxNewCheckBox.setFont(new Font("Arial", Font.PLAIN, 12));
		chckbxNewCheckBox.setBackground(new Color(192, 192, 192));
		chckbxNewCheckBox.setBounds(285, 174, 100, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
