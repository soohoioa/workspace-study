package com.itwill.uidesign.member1;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.itwill.member.Member;
import com.itwill.uidesign.FrameMain;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductPanel extends JPanel {
	private FrameMain frameMain;
	/*******1.Service객체필드선언********/
	//private ProcuctService productService;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ProductPanel() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(71, 10, 248, 192);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/******************************
				 * 제품리스트 보여주기
				 *****************************/
				Member loginMember= new Member();
				if(loginMember!=null) {
					System.out.println(">>>>>>>>>제품리스트보여주기");
					
				}else {
					System.out.println(">>>>>>>>>로그인하세용~~~");
					/*
					 * 
					 */
				}
				
			}
		});
		btnNewButton.setBounds(146, 212, 97, 23);
		add(btnNewButton);
		/*******2.Service객체생성********/
		//productService=new ProductService();
		
	}//생성자

	public void setMainFrame(FrameMain frameMain) {
		this.frameMain=frameMain;
	}
}
