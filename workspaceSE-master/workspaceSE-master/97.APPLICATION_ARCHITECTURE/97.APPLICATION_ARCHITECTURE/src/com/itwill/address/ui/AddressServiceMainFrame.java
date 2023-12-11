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

public class AddressServiceMainFrame extends JFrame {

	/*******************************/
	
	
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
					AddressServiceMainFrame frame = new AddressServiceMainFrame();
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
	public AddressServiceMainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane addressTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(addressTabbedPane, BorderLayout.CENTER);
		
		JPanel addressInsertPanel = new JPanel();
		addressInsertPanel.setBackground(Color.ORANGE);
		addressTabbedPane.addTab("주소록쓰기", null, addressInsertPanel, null);
		addressInsertPanel.setLayout(null);
		
		JLabel addressNameLabel = new JLabel("이름");
		addressNameLabel.setBounds(60, 42, 57, 15);
		addressInsertPanel.add(addressNameLabel);
		
		JLabel addressPhoneLabel = new JLabel("전화번호");
		addressPhoneLabel.setBounds(60, 97, 57, 15);
		addressInsertPanel.add(addressPhoneLabel);
		
		JLabel addressAddressLabel = new JLabel("주소");
		addressAddressLabel.setBounds(60, 152, 57, 15);
		addressInsertPanel.add(addressAddressLabel);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(156, 39, 116, 21);
		addressInsertPanel.add(nameTextField);
		nameTextField.setColumns(10);
		
		phoneTextField = new JTextField();
		phoneTextField.setBounds(156, 94, 116, 21);
		addressInsertPanel.add(phoneTextField);
		phoneTextField.setColumns(10);
		
		addressTextField = new JTextField();
		addressTextField.setBounds(156, 149, 116, 21);
		addressInsertPanel.add(addressTextField);
		addressTextField.setColumns(10);
		
		JButton addressWriteButton = new JButton("주소록쓰기");
		addressWriteButton.setBounds(119, 208, 97, 23);
		addressInsertPanel.add(addressWriteButton);
		
		JPanel addressListPanel = new JPanel();
		addressListPanel.setBackground(Color.PINK);
		addressTabbedPane.addTab("주소록리스트", null, addressListPanel, null);
		
		JPanel addressDetailPanel = new JPanel();
		addressDetailPanel.setBackground(Color.LIGHT_GRAY);
		addressTabbedPane.addTab("주소록상세보기", null, addressDetailPanel, null);
		
		
		
	}
}
