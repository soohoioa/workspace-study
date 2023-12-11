package com.itwill.address.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddressServerMainFrame extends JFrame {
	
	/**************************/

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField phoneTextField;
	private JTextField addressTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressServerMainFrame frame = new AddressServerMainFrame();
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
	public AddressServerMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 358, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane addresstabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(addresstabbedPane, BorderLayout.CENTER);
		
		JPanel addressInsertPanel = new JPanel();
		addressInsertPanel.setBackground(new Color(248, 252, 173));
		addresstabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);
		
		JLabel addressNameLabel = new JLabel("이름");
		addressNameLabel.setBounds(55, 70, 57, 15);
		addressInsertPanel.add(addressNameLabel);
		
		JLabel addressPhoneLabel = new JLabel("전화번호");
		addressPhoneLabel.setBounds(55, 133, 57, 15);
		addressInsertPanel.add(addressPhoneLabel);
		
		JLabel addressAddressLabel = new JLabel("주소");
		addressAddressLabel.setBounds(55, 198, 57, 15);
		addressInsertPanel.add(addressAddressLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(157, 67, 116, 21);
		addressInsertPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(157, 130, 116, 21);
		addressInsertPanel.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(157, 195, 116, 21);
		addressInsertPanel.add(addressTextField);
		addressTextField.setColumns(10);
		
		JButton addressWriteButton = new JButton("주소록쓰기");
		addressWriteButton.setBounds(106, 256, 97, 23);
		addressInsertPanel.add(addressWriteButton);
		
		JPanel addressListPanel = new JPanel();
		addressListPanel.setBackground(new Color(253, 206, 242));
		addresstabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		addressListPanel.setLayout(null);
		
		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setBackground(new Color(205, 244, 254));
		addresstabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);
		addressDetailPanel.setLayout(null);
		
		
		
		
		/* 서비스 객체 생성*/
	}
}
