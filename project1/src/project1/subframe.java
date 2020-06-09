package project1;

import java.awt.*;
import java.awt.event.*;


public class subframe extends Frame implements ActionListener{

	Button open;
	Dimension d;
	
	public subframe()
	{
		super("새창열기");
		this.setSize(500, 500);
		setLayout(null);//버튼의 위치 지정할 수 있게됨
		d=getSize();
		open = new Button("새창열기");
		add(open);
		open.setSize(100, 50);
		open.setLocation(300, 300);
		setVisible(true);
		System.out.println(d);
		
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});//사용하는 이유 : repaint 강의에 나와있음
	
		open.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent ae)
	{
		Object obj = ae.getSource();
		if(obj==open)
		{
			subf sub = new subf();
			sub.setVisible(true);
			sub.setBounds(100, 100, 300, 300);
		}
	}
	
	public static void main(String[] args) 
	{
		subframe obj = new subframe();
		
		
	}

}
class subf extends Frame
{
	public subf()
	{
		setBackground(Color.YELLOW);
	
	}
}
