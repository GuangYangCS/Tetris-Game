package Homework3;

import java.awt.Color;
import java.awt.Point;

/*
 * Record the shapes that have been frozen in the stage
 * */
public class DrawShape
{
    private Point p;
	private boolean ispainted;
	private Color color;
	DrawShape(int x,int y, Color c)
	{
		p = new Point(y*20,x*20);
		ispainted = false;
		color = c;
	}
	void Draw(Color c)
	{
		SetColor(c);
		SetPainted(true);
	}
	void Replace(DrawShape next)
	{
		this.color = next.color;
		this.ispainted = next.ispainted;
	}
	boolean isPainted()
	{
		return ispainted;
	}
	void SetPainted(boolean b)
	{
		ispainted = b;
	}
	Point getStartPoint()
	{
		return p;
	}
	Color GetColor()
	{
		return color;
		
	}
	void SetColor(Color c)
	{
		color = c;
	}
}
