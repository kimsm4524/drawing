package project1;

import java.awt.*;
import java.awt.event.*;


public class subframe extends Frame implements ActionListener{

	Button open;
	Dimension d;
	
	public subframe()
	{
		super("��â����");
		this.setSize(500, 500);
		setLayout(null);//��ư�� ��ġ ������ �� �ְԵ�
		d=getSize();
		open = new Button("��â����");
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
		});//����ϴ� ���� : repaint ���ǿ� ��������
	
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
