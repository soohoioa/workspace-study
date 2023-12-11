package event;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NorthButtenActionEventHandler implements ActionListener{
	
	private ActionEventJFrame frame;
	// 이런참조가 필요할때는 외부에서 데이터를 받아야함
	
	private int buttonClickCount = 0;
	
	public NorthButtenActionEventHandler(ActionEventJFrame frame) {
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// System.out.println("north button click!!"); // 클릭이라 쓰지만 클릭은 아님. 마우스클릭 이벤트는 따로 있고 누르는 행위라고 이해하기
		// System.out.println("실행쓰레드 이름 : " + Thread.currentThread().getName());
		Object eventSoure = e.getSource();
		// System.out.println(eventSoure);
		JButton eventSourcButton =(JButton)eventSoure;
		eventSourcButton.setText("이벤트소스[NORTH]" + ++buttonClickCount);
		
		/***** ActionEventJFrame의 멤버 접근 
		 * 프레임의 타이틀 변경
		 * contentPane(프레임의 멤버필드) 의 배경색을 변경..
		 * ???
		 *****/	
		frame.setTitle("button click count:"+buttonClickCount);
		int r=(int)(Math.random()*256);
		int g=(int)(Math.random()*256);
		int b=(int)(Math.random()*256);
		frame.contentPane.setBackground(new Color(r,g,b));
		// 프레임에 참조가 있다면 패키지접근
		/**********/
		
		
		
		
	}

}
