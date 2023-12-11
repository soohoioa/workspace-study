package basic;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;

public class ChildJFrameWB extends JFrame {

	private JPanel contentPane;
	private JButton okBtn;
	private JButton cancleBtn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		ChildJFrameWB frame = new ChildJFrameWB();
		frame.setVisible(true);
		
	}

	/**
	 * Create the frame.
	 */
	public ChildJFrameWB() {
		setTitle("나의첫번째W프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(248, 192, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		okBtn = new JButton("확인");
		okBtn.setBounds(40, 40, 80, 40);
		contentPane.add(okBtn);
		
		cancleBtn = new JButton("취소");
		cancleBtn.setBounds(130, 40, 80, 40);
		contentPane.add(cancleBtn);
	}
}
