package layout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;

public class GridLayoutJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridLayoutJFrame frame = new GridLayoutJFrame();
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
	public GridLayoutJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 329, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton btnNewButton_5 = new JButton("1");
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("2");
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("3");
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("4");
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("5");
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("6");
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("7");
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("8");
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_8 = new JButton("9");
		contentPane.add(btnNewButton_8);
	}

}
