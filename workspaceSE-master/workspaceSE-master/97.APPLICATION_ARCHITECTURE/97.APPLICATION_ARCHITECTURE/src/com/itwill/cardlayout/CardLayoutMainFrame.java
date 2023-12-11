package com.itwill.cardlayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class CardLayoutMainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel parentPanel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardLayoutMainFrame frame = new CardLayoutMainFrame();
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
	public CardLayoutMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 408, 291);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel menuButtonPanel = new JPanel();
		menuButtonPanel.setBackground(Color.ORANGE);
		contentPane.add(menuButtonPanel, BorderLayout.SOUTH);
		
		JButton joinButton = new JButton("가입패널");
		joinButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/********CardLayout 카드교채*****/
				CardLayout cardLayout= (CardLayout)parentPanel.getLayout();
				cardLayout.show(parentPanel,"join");
				//cardLayout.next(parentPanel);
			}
			
		});
		menuButtonPanel.add(joinButton);
		
		JButton loginButton = new JButton("로그인패널");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout= (CardLayout)parentPanel.getLayout();
				cardLayout.show(parentPanel,"login");
			}
		});
		menuButtonPanel.add(loginButton);
		
		parentPanel = new JPanel();
		parentPanel.setBackground(new Color(123, 104, 238));
		contentPane.add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));
		
		JPanel joinPanel = new JPanel();
		joinPanel.setBackground(new Color(32, 178, 170));
		parentPanel.add(joinPanel, "join");
		joinPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(79, 56, 57, 15);
		joinPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(79, 100, 57, 15);
		joinPanel.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(89, 158, 97, 23);
		joinPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(230, 158, 97, 23);
		joinPanel.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(210, 53, 116, 21);
		joinPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 97, 116, 21);
		joinPanel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(new Color(173, 216, 230));
		parentPanel.add(loginPanel, "login");
		loginPanel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(79, 64, 57, 15);
		loginPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(79, 124, 57, 15);
		loginPanel.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(187, 61, 116, 21);
		loginPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(187, 121, 116, 21);
		loginPanel.add(textField_3);
		textField_3.setColumns(10);
		
		
	}
}
