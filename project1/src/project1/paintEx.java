package project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class paintEx extends JFrame
{
	JPanel pall,p3,p2,p1,pright; // 패널내에 캔버스와 컴포넌트들을 삽입하여 패널을 Frame에 올린다.
	JButton blue,orange,green,red,yellow,black,white,select;
	JButton plus,minus,erase,eraseAll;
	JButton cir,rec,tri,oval,ovalrec,pencil,fill,move;
	JFrame f;
	JFileChooser jfc;
	CanvasDemo cv;
	JMenuBar bar;
	JMenu fileM,editM;
	JMenuItem newl,openl,copyl,pastel,save;
	public paintEx()
	{
		super("paint app");
		jfc = new JFileChooser();
		f=this;
		pall = new JPanel(new BorderLayout());
		pall.setBackground(Color.LIGHT_GRAY);
		this.add(pall,"West");
		
		bar = new JMenuBar();//1단계
		setJMenuBar(bar);//2단계
		
		//[File]메뉴 생성
		fileM = new JMenu("File");//3단계
		
		//[File]메뉴 내의 [New] 소메뉴 생성
		newl = new JMenuItem("New");//4단계
		fileM.add(newl);
		
		//[File]메뉴 내의 [Open] 소메뉴 생성
		openl = new JMenuItem("Open");
		fileM.add(openl);
		
		save = new JMenuItem("save");
		fileM.add(save);
		
		bar.add(fileM);
		
		//[Edit]메뉴 생성
		editM = new JMenu("Edit");
		
		//[Edit]메뉴 내의 [Copy] 소메뉴 생성
		copyl = new JMenuItem("Copy");
		editM.add(copyl);
				
		//[Edit]메뉴 내의 [Paste] 소메뉴 생성
		pastel = new JMenuItem("Paste");
		editM.add(pastel);
		
		bar.add(editM);
		
		p1 = new JPanel(new GridLayout(4,2))//무명 클래스?
		{
			public Insets getInsets()
			{
				return new Insets(10, 10, 10, 10); // 상하좌우 10만큼의 여백
			}
		};//p1 = 3행1열
		
		
		pall.add(p1,"North");
		blue = new JButton();
		blue.setBackground(Color.BLUE);
		orange = new JButton();
		orange.setBackground(Color.orange);
		green = new JButton();
		green.setBackground(Color.green);
		red = new JButton();
		red.setBackground(Color.red);
		yellow = new JButton();
		yellow.setBackground(Color.yellow);
		black = new JButton();
		black.setBackground(Color.black);
		white = new JButton();
		white.setBackground(Color.white);
		select = new JButton("직접입력");
		
		p1.add(blue);
		p1.add(orange);
		p1.add(green);
		p1.add(red);
		p1.add(yellow);
		p1.add(black);
		p1.add(white);
		p1.add(select);
		
		p2 = new JPanel(new GridLayout(4,1))
				{
					public Insets getInsets()
					{
						return new Insets(10, 10, 10, 10);
					}
				};
		pall.add(p2,"West");
		plus = new JButton("+");
		minus = new JButton("-");
		erase = new JButton("지우개");
		eraseAll = new JButton("모두지우기");
		p2.add(plus);
		p2.add(minus);
		p2.add(erase);
		p2.add(eraseAll);
		
		
		p3 = new JPanel(new GridLayout(4,2))//무명 클래스?
				{
					public Insets getInsets()
					{
						return new Insets(10, 10, 10, 10); // 상하좌우 10만큼의 여백
					}
				};//p1 = 3행1열
		pall.add(p3,"Center");
		cir = new JButton("원");
		rec = new JButton("사각형");
		oval = new JButton("타원");
		tri = new JButton("정삼각형");
		ovalrec = new JButton("둥근사각형");
		pencil = new JButton("붓");
		fill = new JButton("채우기");
		move = new JButton("이동");
		p3.add(cir);
		p3.add(tri);
		p3.add(oval);
		p3.add(ovalrec);
		p3.add(rec);
		p3.add(pencil);
		p3.add(fill);
		p3.add(move);
		
				
		pright = new JPanel()
				{
					public Insets getInsets()
					{
						return new Insets(10, 10, 10, 10);//여백을 주는 이유 : 달라붙으면 이쁘지않음
					}
				};
		
		pright.setBackground(Color.gray);
		this.add(pright, "Center");
		
		cv = new CanvasDemo();
		cv.setSize(1000, 1000);
		cv.setBackground(Color.white);
		pright.add(cv);
		
		blue.addActionListener(new EventHandler());
		orange.addActionListener(new EventHandler());
		green.addActionListener(new EventHandler());
		red.addActionListener(new EventHandler());
		yellow.addActionListener(new EventHandler());
		black.addActionListener(new EventHandler());
		white.addActionListener(new EventHandler());
		select.addActionListener(new EventHandler());
		plus.addActionListener(new EventHandler());
		minus.addActionListener(new EventHandler());
		erase.addActionListener(new EventHandler());
		eraseAll.addActionListener(new EventHandler());
		
		ovalrec.addActionListener(new EventHandler());
		rec.addActionListener(new EventHandler());
		oval.addActionListener(new EventHandler());
		tri.addActionListener(new EventHandler());
		cir.addActionListener(new EventHandler());
		pencil.addActionListener(new EventHandler());
		fill.addActionListener(new EventHandler());
		move.addActionListener(new EventHandler());
		newl.addActionListener(new EventHandler());
		save.addActionListener(new EventHandler());
		
		
		cv.addMouseMotionListener(new MouseHandler());//()에 들어가는 것은 이벤트 핸들러
		cv.addMouseListener(new MouseHandler());
		
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e)
			{
				setVisible(false);//안보이게하기
				dispose();//메모리 해제하기
			}
		});//사용하는 이유 : repaint 강의에 나와있음
		
	}
	

	public static void main(String[] args) 
	{
		
		paintEx obj = new paintEx();
		obj.setBounds(300, 25, 1200, 1000);
		obj.setVisible(true);

	}
	
	private class MouseHandler implements MouseListener, MouseMotionListener
	{

		@Override
		public void mouseDragged(MouseEvent e)
		{
			if(cv.s==0)
			{
			cv.x = e.getX();
			cv.y = e.getY();
			cv.repaint(); // update메소드를 호출하지만 update를 오버라이딩하지 않음
			}				//또한 update메소드는 자동으로 초기화를 시켜준다.
			if(cv.s==2&&cv.check==7)
				if(cv.save!=999)
				{
					cv.shape.get(cv.save).move(e.getX()-cv.offX, e.getY()-cv.offY);
					cv.offX=e.getX();cv.offY=e.getY();
					cv.repaint();
				}

		}

		@Override
		public void mouseMoved(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			if(cv.s==2&&cv.check==6)
				for(int i=cv.shape.size()-1;i>=0;i--)
				{
					cv.shape.get(i).select(e.getPoint());
					if(cv.shape.get(i).getSelected())
					{
						cv.shape.get(i).fill(cv.cl);
						cv.shape.get(i).release();
						cv.repaint();
						break;
					}
					
				}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) 
		{
			// TODO Auto-generated method stub
		
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
		
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
		if(cv.s==2&&cv.check!=7)
		{
			cv.x1=e.getX();
			cv.y1 = e.getY();
			
		}
		if(cv.s==2&&cv.check==7)
			for(int i=0;i<cv.shape.size();i++)
			{
				cv.shape.get(i).select(e.getPoint());
				if(cv.shape.get(i).getSelected())
				{
					cv.save=i;
					cv.offX=e.getX();
					cv.offY=e.getY();
					break;
				}
			}
	

		}
		@Override
		public void mouseReleased(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			if(cv.s==2&&cv.check!=7)
			{
			
			cv.x2 = e.getX();
			cv.y2 = e.getY();
			cv.repaint();
			}
			if(cv.s==2&&cv.check==7)
				if(cv.save!=999)
				{
					cv.shape.get(cv.save).release();
					cv.save=999;
										
					
				}
		}
	}
	class EventHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			int r,g,b;
			Object ob = e.getSource();//누른 버튼을 가져옴
			Color cll;
						//cll = ((JButton)ob).getBackground(); // ob를 button으로 만든다
			
			if(ob==newl)//새창 띄우기
			{
				paintEx sub = new paintEx();
				sub.setBounds(350, 75, 1200, 1000);
				
				sub.addWindowListener(new WindowAdapter() 
				{
					public void windowClosing(WindowEvent e)
					{
						sub.setVisible(false);
						sub.dispose();
						
						
					}
				});//사용하는 이유 : repaint 강의에 나와있음
				sub.setVisible(true);
			}
			if(ob==openl)
			{
			}
			
			
			
			if(ob == erase||ob==white)
				cv.cl = Color.WHITE;
			else if(ob==select)
			{
				r=Integer.parseInt(JOptionPane.showInputDialog("RGB'S R (0~255)"));
				g=Integer.parseInt(JOptionPane.showInputDialog("RGB'S G (0~255)"));
				b=Integer.parseInt(JOptionPane.showInputDialog("RGB'S B (0~255)"));
				cll = new Color(r,g,b);
				cv.cl=cll;
			}
			else if(ob==red)
				cv.cl = Color.RED;
			else if(ob==yellow)
				cv.cl = Color.yellow;
			else if(ob==blue)
				cv.cl = Color.blue;
			else if(ob==black)
				cv.cl = Color.black;
			else if(ob==green)
				cv.cl = Color.green;
			else if(ob==orange)
				cv.cl = Color.orange;
			
			if(ob==cir)
			{
				cv.check=1;
				cv.s=2;
				System.out.println("s=2");
			}
			else if(ob==rec)
			{
				cv.check=2;
				cv.s=2;
			}
			else if(ob==tri)
			{
				cv.check=3;
				cv.s=2;
			}
			else if(ob==oval)
			{
				cv.check=4;
				cv.s=2;
			}
			else if(ob==ovalrec)
			{
				cv.check=5;
				cv.s=2;
			}
			else if(ob==fill)
			{
				cv.check=6;
				cv.s=2;
			}
			else if(ob==pencil)
			{
				cv.s=0;
				System.out.println("s=0");
			}
			else if(ob==move)
			{
				cv.check=7;
				cv.s=2;
			}
			if(ob == plus)
			{
				cv.h++;
			}
			else if(ob == minus)
			{
				cv.h--;
			}
			else if(ob == eraseAll)
			{
				cv.x1=0;cv.x2=0;cv.y1=0;cv.y2=0;cv.x=0;cv.y=0;
				cv.shape.clear();
				cv.repaint();
			}
			
		
		}


		
		
	}
}


class CanvasDemo extends Canvas
{
	int x=0, y=0,h=10;
	int x1=0,x2=0,y1=0,y2=0;
	int trix[], triy[];
	int save=999;
	int offX,offY;
	Color cl = Color.red;
	int s=0;
	int check=0;
	ArrayList<shapes> shape = new ArrayList<>();
	public void paint(Graphics g)
	{
		
		g.clearRect(0, 0, 1000, 1000);
		if(s==2)
		{
			switch(check)
			{
				case 1:
				{
					shape.add(new shapes(x1,y1,x2,y2,5,cl,0));
					break;
				}
				case 2:
				{
					shape.add(new shapes(x1,y1,x2,y2,2,cl,0));
					break;
				}
				case 3:
				{
					shape.add(new shapes(x1,y1,x2,y2,3,cl,0));
					break;
				}
				case 4:
				{
					shape.add(new shapes(x1,y1,x2,y2,1,cl,0));
					break;
				}
				case 5:
				{
					shape.add(new shapes(x1,y1,x2,y2,4,cl,0));
					break;
				}
			}
		}
		else
		{
			shape.add(new shapes(x,y,x+h,y+h,1,cl,1));
		}
		
		for(shapes shape : shape)
				shape.draw(g);
	}
	public void update(Graphics g)
	{
		paint(g);
	}
}
