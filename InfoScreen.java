package Homework3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.SwingUtilities;

public class InfoScreen extends Canvas implements MouseWheelListener,MouseMotionListener, MouseListener
{

	private int level, lines, score;
	public Shape pd = new Shape();
	
	GameScreen gameScreen = null;
	InfoScreen(GameScreen gameScreen)
	{
		addMouseWheelListener(this);
		addMouseMotionListener(this);
		addMouseListener(this);
		
		level = 1;
		lines = 0;
		score = 0;
		this.gameScreen = gameScreen;
	}
	public void setString(int score,int lines, int level)
	{
		this.level = level;
		this.score = score;
		this.lines = lines;
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.black);
		
		g.drawRect(15,5,150,80);
		
		g.setFont(new Font("SansSerif",Font.BOLD,20));
		g.drawString("Level:", 15, 200);
		g.drawString("Lines:", 15, 250);
		g.drawString("Score:", 15, 300);
		
		g.setFont(new Font("SansSerif",Font.ITALIC,20));
		g.drawString(String.valueOf(level), 100,200);
		g.drawString(String.valueOf(lines), 100,250);
		g.drawString(String.valueOf(score), 100,300);
		
		int shapesize = pd.getShapeSize();
		int bound[][] = pd.getBound(gameScreen.nextkind);
		boolean shape[][][] = pd.getShape(gameScreen.nextkind);
		
		if(gameScreen.gameStatus==0||gameScreen.gameStatus==3) 
		{
			g.setColor(Color.black);
			g.drawRect(50,50, shapesize, shapesize);
			g.drawRect(70,50, shapesize, shapesize);
			g.drawRect(90,50, shapesize, shapesize);
			g.drawRect(90,30, shapesize, shapesize);
			g.setColor(Color.red);
			g.fillRect(50+1,50+1, shapesize-1, shapesize-1);
			g.fillRect(70+1,50+1, shapesize-1, shapesize-1);
			g.fillRect(90+1,50+1, shapesize-1, shapesize-1);
			g.fillRect(90+1,30+1, shapesize-1, shapesize-1);
		}else
		for(int i=3;i>=0;i--)
		{
			for(int j=0;j<4;j++)
			{
				if(shape[0][j][i])
				{
					g.setColor(Color.black);
					g.drawRect(60+(j-bound[0][1])*shapesize,70+(i-bound[0][2])*shapesize, shapesize, shapesize);
					g.setColor(gameScreen.nextColor);
					g.fillRect(60+(j-bound[0][1])*shapesize+1,70+(i-bound[0][2])*shapesize+1, shapesize-1, shapesize-1);
				}

			}
		}
	
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(SwingUtilities.isLeftMouseButton(e)){
			gameScreen.moveLeft();
		}
		else if(SwingUtilities.isRightMouseButton(e)){
			gameScreen.moveRight();
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getWheelRotation() < 0){
			gameScreen.moveClockwise();
		}else if(e.getWheelRotation() > 0){
			gameScreen.moveCounterClockwise();
			
		}
		
	}
}