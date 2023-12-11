package com.itwill.uidesign;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itwill.member.MemberService;
import com.itwill.uidesign.member1.ProductPanel;
import com.itwill.uidesign.member2.MemberPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class FrameMain extends JFrame {

	/*****1.Service 객체멤버필드선언*******/
	public MemberService memberService;

	private JPanel contentPane;
	private JPanel parentPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameMain frame = new FrameMain();
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
	public FrameMain() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 427, 339);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northNavigationPanel = new JPanel();
		northNavigationPanel.setPreferredSize(new Dimension(10, 40));
		contentPane.add(northNavigationPanel, BorderLayout.NORTH);
		northNavigationPanel.setLayout(null);

		JButton btnNewButton = new JButton("회원");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*** MemberPanel보여주기*****/
				CardLayout cardLayout = (CardLayout) parentPanel.getLayout();
				cardLayout.show(parentPanel, "member");
			}
		});
		btnNewButton.setBounds(0, 10, 62, 23);
		northNavigationPanel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("상품");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*** ProductPanel보여주기*****/
				CardLayout cardLayout = (CardLayout) parentPanel.getLayout();
				cardLayout.show(parentPanel, "product");
			}
		});
		btnNewButton_1.setBounds(67, 10, 79, 23);
		northNavigationPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("주문");
		btnNewButton_2.setBounds(239, 10, 62, 23);
		northNavigationPanel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("카트");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*** CartPanel보여주기*****/
			}
		});
		btnNewButton_3.setBounds(160, 10, 67, 23);
		northNavigationPanel.add(btnNewButton_3);

		parentPanel = new JPanel();
		contentPane.add(parentPanel, BorderLayout.CENTER);
		parentPanel.setLayout(new CardLayout(0, 0));

		MemberPanel memberPanel = new MemberPanel();
		parentPanel.add(memberPanel, "member");

		ProductPanel productPanel = new ProductPanel();
		parentPanel.add(productPanel, "product");

		memberPanel.setMainFrame(this);
		productPanel.setMainFrame(this);

		/******2.Service 객체생성*****************/
		memberService = new MemberService();
	}//생성자끝
}
