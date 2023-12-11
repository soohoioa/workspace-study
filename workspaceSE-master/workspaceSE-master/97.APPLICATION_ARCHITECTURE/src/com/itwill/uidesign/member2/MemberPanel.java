package com.itwill.uidesign.member2;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;

import com.itwill.uidesign.FrameMain;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberPanel extends JPanel {
	private FrameMain frameMain;
	private JPanel contentListPanel;
	/**
	 * Create the panel.
	 */
	public MemberPanel() {
		setBackground(Color.CYAN);
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane memberTabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(memberTabbedPane, BorderLayout.CENTER);
		
		JPanel memberJoinPanel = new JPanel();
		memberJoinPanel.setBackground(Color.WHITE);
		memberTabbedPane.addTab("가입", null, memberJoinPanel, null);
		
		JPanel memberListPanel = new JPanel();
		memberTabbedPane.addTab("리스트", null, memberListPanel, null);
		memberListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 306, 288);
		memberListPanel.add(scrollPane);
		
		contentListPanel = new JPanel();
		FlowLayout fl_contentListPanel = (FlowLayout) contentListPanel.getLayout();
		fl_contentListPanel.setAlignment(FlowLayout.LEFT);
		contentListPanel.setPreferredSize(new Dimension(200, 400));
		scrollPane.setViewportView(contentListPanel);
		/***************product item panel start*****************/
		JPanel itemPanel = new JPanel();
		itemPanel.setPreferredSize(new Dimension(130, 100));
		itemPanel.setBackground(Color.PINK);
		contentListPanel.add(itemPanel);
		itemPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(MemberPanel.class.getResource("/images/50bigle.jpg")));
		lblNewLabel.setBounds(12, 10, 49, 50);
		itemPanel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox.setBounds(22, 70, 32, 23);
		itemPanel.add(comboBox);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******cart 담기****/
				System.out.println(">>>>>>>>>>>>>>카트담기");
			}
		});
		btnNewButton.setIcon(new ImageIcon(MemberPanel.class.getResource("/images/cart20.png")));
		btnNewButton.setBounds(66, 70, 57, 23);
		itemPanel.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("비글");
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(73, 10, 57, 15);
		itemPanel.add(lblNewLabel_1);
		
		/***************product item panel end*****************/
		
		JPanel memberUpdatePanel = new JPanel();
		memberTabbedPane.addTab("수정", null, memberUpdatePanel, null);
			
		displayProductList();
	}
	
	public void displayProductList() {
		contentListPanel.removeAll();
		for(int i=0;i<5;i++) {
			/***************product item panel start*****************/
			JPanel itemPanel = new JPanel();
			itemPanel.setPreferredSize(new Dimension(130, 100));
			itemPanel.setBackground(Color.PINK);
			contentListPanel.add(itemPanel);
			itemPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon(MemberPanel.class.getResource("/images/50bigle.jpg")));
			lblNewLabel.setBounds(12, 10, 49, 50);
			itemPanel.add(lblNewLabel);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
			comboBox.setBounds(22, 70, 32, 23);
			itemPanel.add(comboBox);
			
			JButton btnNewButton = new JButton("");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					/******cart 담기****/
					System.out.println(">>>>>>>>>>>>>>카트담기");
				}
			});
			btnNewButton.setIcon(new ImageIcon(MemberPanel.class.getResource("/images/cart20.png")));
			btnNewButton.setBounds(66, 70, 57, 23);
			itemPanel.add(btnNewButton);
			
			JLabel lblNewLabel_1 = new JLabel("비글");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
			lblNewLabel_1.setBounds(73, 10, 57, 15);
			itemPanel.add(lblNewLabel_1);
			
			/***************product item panel end*****************/
		}
		
	}
	
	
	public void setMainFrame(FrameMain frameMain) {
		this.frameMain=frameMain;
		
	}
}
