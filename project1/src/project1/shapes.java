package project1;
import java.awt.*;
import java.awt.geom.*;

import project1.shapes;
public class shapes {
	private int x;
	private int y;
	private int height;
	private int width;
	private Color lineColor;
	private Color fillColor;
	private Shape shape;
	private int shapenum;
	int a;
	private boolean selected;
	public shapes(int x1, int y1, int x2, int y2, int num, Color color,int a)
	{
		this.x=Math.min(x1,x2);
		this.y=Math.min(y1, y2);
		this.height=Math.max(y2-y1,y1-y2);
		this.width=Math.max(x2-x1,x1-x2);
		this.lineColor=color;
		if(a==0)
			this.fillColor=Color.white;
		else
			this.fillColor=color;
		this.shapenum=num;
		switch(this.shapenum)
		{
		case 2:
			this.shape=new Rectangle(x, y, width, height);
			break;
		case 1:
			this.shape=new Ellipse2D.Double((double)this.x, (double)this.y, (double)this.width, (double)this.height);
			break;
		case 3:
			int trix[] = {this.x,this.x+this.width/2,this.x+this.width};
			int triy[] = {this.height+this.y,this.y,this.height+this.y};
			this.shape=new Polygon(trix,triy,3);
			break;
		case 4:
			this.shape=new RoundRectangle2D.Double((double)x,(double)y,(double)width,(double)height,50,50);
			break;
		case 5:
			this.shape=new Ellipse2D.Double((double)this.x, (double)this.y, (double)this.width, (double)this.width);
			break;
		}
		this.selected=false;
	}
	public void draw(Graphics g)
	{		
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(3));
		g2.setColor(lineColor);
		g2.draw(shape);
		g2.setColor(fillColor);
		g2.fill(shape);
	}
	public Color getColor()
	{
		return this.lineColor;
	}
	public void select(Point x)
	{
		if(this.shape.contains(x))
			this.selected = true;
	}
	public boolean getSelected()
	{
		return this.selected;
	}
	public void release()
	{
		this.selected=false;
	}
	public void move(int x1, int y1)
	{
		this.x=this.x+x1;
		this.y=this.y+y1;
		switch(this.shapenum)
		{
		case 2:
			this.shape=new Rectangle(x, y, width, height);
			break;
		case 1:
			this.shape=new Ellipse2D.Double((double)this.x, (double)this.y, (double)this.width, (double)this.height);
			break;
		case 3:
			int trix[] = {this.x,this.x+this.width/2,this.x+this.width};
			int triy[] = {this.height+this.y,this.y,this.height+this.y};
			this.shape=new Polygon(trix,triy,3);
			break;
		case 4:
			this.shape=new RoundRectangle2D.Double((double)x,(double)y,(double)width,(double)height,50,50);
			break;
		case 5:
			this.shape=new Ellipse2D.Double((double)this.x, (double)this.y, (double)this.width, (double)this.width);
			break;
		}
	}
	public void fill(Color color)
	{
		this.fillColor=color;
	}
	
}