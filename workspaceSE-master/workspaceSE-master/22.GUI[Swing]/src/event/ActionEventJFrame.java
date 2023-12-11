package event;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
/*
1. 이벤트 소스 결정 :하나의 윈도우에는 여러 개의 컴포넌트가 존재할 수 있으므로
					 실제로 이벤트가 발생되면 처리할 컴포넌트를 결정한다. 
2. 이벤트 핸들러(리스너) 클래스작성 : 
			이벤트를 실제적으로 처리할 수 있도록 
            해당 이벤트를 처리할 이벤트 리스너 인터페이스를 
            이용해서(구현) 이벤트 핸들러(리스너) 클래스를 작성한다. 

3. 이벤트 소스객체와 이벤트 핸들러(리스너)객체 연결 :
 				이벤트 리스너(핸들러)가 작성이되면 리스너(핸들러)와 이벤트 소스와 연결을 하여 
 				이벤트 소스에서 실제적으로 이벤트가 발생이 되면 처리할수 있도록 
				addXXListener()함수를 통해 연결을 시켜준다.  
				XX부분은 해당 컴포넌트에 붙일 수 있는 리스너 이름을 의미한다.
	 
	  ex>버튼에서발생하는 ActionEvent를 처리할 Handler(ActionListener구현)객체생성
	  
	  예를 들어 버튼에 ActionEvent을 처리하기 위하여 
	  버튼에다가 addActionListener를 붙이는 경우이다.
	  ex> 버튼객체.addActionListener(ActionListener구현한핸들러객체);
*/

public class ActionEventJFrame extends JFrame {

	public JPanel contentPane;
	private JButton northButton;
	private JButton southButton;
	private JButton westButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActionEventJFrame frame = new ActionEventJFrame();
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
	public ActionEventJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 334, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		northButton = new JButton("이벤트 소스[NORTH]");
		contentPane.add(northButton, BorderLayout.NORTH);
		
		southButton = new JButton("이벤트 소스[SOUTH]");
		contentPane.add(southButton, BorderLayout.SOUTH);
		
		westButton = new JButton("이벤트 소스[WEST]");
		contentPane.add(westButton, BorderLayout.WEST);
		
		/*************이벤트소스에 이벤트 핸들러 객체를 등록*************/
		
		/*****1. 외부클래스(를 만들어 넣었더니 this를 넣어줘야 한다)*****/
		NorthButtenActionEventHandler handler = new NorthButtenActionEventHandler(this); // 객체를 직접 생성해서 넣어봄
		northButton.addActionListener(handler);
			
		// northButton.addActionListener(new NorthButtenActionEventHandler(this)); 
		// 자바스크립트에서는 addListener 로 가능하지만 자바는 종류가 많음.
		
		/*****2. 멤버내부클래스 InnerClass *****/
		SouthButtenActionEventHandler handler2 = new SouthButtenActionEventHandler();
		southButton.addActionListener(handler2);
		/*
		 The method addActionListener(ActionListener) 
		 in the type AbstractButton is not applicable for the arguments 
		 (ActionEventJFrame.SouthButtenActionEventHandler)
		 
		 AbstractButton 유형의 addActionListener(ActionListener) 
		 메서드는 인수(ActionEventJFrame.SouthButtenActionEventHandler)에 적용할 수 없습니다.
		 */
		
		/*****3. anonymous(익명) local inner 클래스 *****/
		ActionListener handler3 = new ActionListener() {
			int buttonClickCount = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				westButton.setText("이벤트쏘스[SOUTH] "+ ++buttonClickCount);
				/***********ActionEventJFrame의 멤버접근***********
				 * 프레임의 타이틀변경
				 * contentPane(프레임의 멤버필드)의 배경색변경
				 * ???
				 */
				setTitle("button click count:"+buttonClickCount);
				int r=(int)(Math.random()*256);
				int g=(int)(Math.random()*256);
				int b=(int)(Math.random()*256);
				contentPane.setBackground(new Color(r,g,b));
			}
		};
		westButton.addActionListener(handler3);
		
	
		/*****************************************************************/

		
	} // 생성자 끝

	/***** member inner class *****/
	public class SouthButtenActionEventHandler implements ActionListener {
		
		int buttonClickCount = 0;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// System.out.println("south button");
			southButton.setText("이벤트 소스[SOUTH]" + ++buttonClickCount);
			// NorthButtenActionEventHandler 클래스의 코드23줄 부분 -> 내꺼처럼 사용하기 시전으로 간단하게 표현가능.
			
			/***** ActionEventJFrame의 멤버 접근 
			 * 프레임의 타이틀 변경
			 * contentPane(프레임의 멤버필드) 의 배경색을 변경..
			 * ???
			 *****/
			setTitle("button click count : " + buttonClickCount);
			int r = (int)(Math.random()*256);
			int g = (int)(Math.random()*256);
			int b = (int)(Math.random()*256);
			contentPane.setBackground(new Color(r, g, b));

		}
		

	}
	

}
