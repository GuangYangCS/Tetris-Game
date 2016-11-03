 package Homework3;
import java.awt.*;
import java.util.Random;
import java.util.Stack;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class GameScreen extends JPanel implements MouseListener{
	public int score = 0, lines = 0, level=1, current_x, current_y, gameStatus = 0, shapeTransfom = 0, kind = 0, nextkind=0, last=0;
	public double speed = 20.0;
	public boolean statusChange, shape[][][], CurrentReachBottom = false;

	public Shape s = new Shape();
	Color thisColor,nextColor;
	public DrawShape[][] ShapePainted = new DrawShape[20][10]; 
	int shapesize = s.getShapeSize();
	
	GameScreen(){
		
		addMouseListener(this);
		// initialize the drop location of each shape
		current_x = 60;
		current_y = 0;
		
		for(int i=0; i<20;i++){
			for(int j=0;j<10;j++)
			{
				ShapePainted[i][j] = new DrawShape(i,j,Color.black);
			}
		}

		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("current y is " + current_y );
				// TODO Auto-generated method stub
				int cursorX = e.getX();
				int cursorY = e.getY();
				System.out.println("cursorX  is " + cursorX );
				System.out.println("cursorY  is " + cursorY );
				if(cursorX <= current_x + 40 && cursorX >= current_x - 40 && cursorY <= current_y + 40 && cursorY >= current_y - 40 ){
					System.out.println("Change current shape to the next and update next !");
					Random random = new Random(System.currentTimeMillis());
					kind = nextkind;
					nextkind = random.nextInt(7);
					thisColor = s.getColor(kind);
					nextColor = s.getColor(nextkind);

					statusChange = true;
					repaint();
				}
				
			}
			
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
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
			public void mouseEntered(MouseEvent e) {
 
			}

			@Override
			public void mouseExited(MouseEvent arg0) {}
		});
	}
	// each mouse operation will call its move method correspondingly 
	public void moveLeft(){
		current_x -= s.getShapeSize();
	}
	public void moveRight(){
		current_x += s.getShapeSize();
	}
	
	public void moveClockwise(){	
		shapeTransfom += 1;
		shapeTransfom %= 4;
	}
	public void moveCounterClockwise(){	
		if(shapeTransfom > 0)
			shapeTransfom -= 1;
		else
			shapeTransfom = 3;
	}
	
	public void paint(Graphics g) {
		Image iBuffer = null;  
		Graphics gBuffer = null;
		if(iBuffer == null)
		{
			iBuffer = createImage(this.getSize().width,this.getSize().height);
			gBuffer = iBuffer.getGraphics();
		}
		
		shape = s.getShape(kind);
		int bound[][] = s.getBound(kind);
		
		int rightBound = 200 - bound[shapeTransfom][0]*shapesize;
		int leftBound = -bound[shapeTransfom][1]*shapesize;
		int dropBound = 400 - bound[shapeTransfom][2]*shapesize;
		
		if(current_x < leftBound) current_x = leftBound;
		if(current_x >= rightBound) current_x = rightBound;
		if(current_y >= dropBound) current_y = dropBound;
		
		for(int i=0;i<20;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(ShapePainted[i][j].isPainted())
				{
					Point p  = ShapePainted[i][j].getStartPoint();
					gBuffer.setColor(Color.black);
					gBuffer.drawRect(p.x, p.y, shapesize, shapesize);
					gBuffer.setColor(ShapePainted[i][j].GetColor());
					gBuffer.fillRect(p.x+1, p.y+1, shapesize-1, shapesize-1);					
				}
			}
		}

		if(IntersectionDetection())
		{
			if(last==40)
				CurrentReachBottom = true;
			if(last==40)
				current_y -= 20;
			else if(last==39)
				current_x -= 20;
			else if(last==37)
				current_x += 20;
		}
		if(IntersectionDetection())  
		{
			if(last==40)
				CurrentReachBottom = true;
			System.out.print(last);
			if(last==40)
				current_y -= 20;
			else if(last==39)
				current_x -= 20;
			else if(last==37)
				current_x += 20;
		}
		else if(gameStatus==1)
		{
			for(int i=3;i>=0;i--)
			{
				
				for(int j=0;j<4;j++)
				{
					if(shape[shapeTransfom][j][i]) //If The Shape has been frozen
					{
						gBuffer.setColor(Color.black);
						gBuffer.drawRect(current_x+j*shapesize, 
								         current_y+i*shapesize, shapesize, shapesize);
						gBuffer.setColor(thisColor);
						gBuffer.fillRect(current_x+j*shapesize+1, 
								         current_y+i*shapesize+1, shapesize-1, shapesize-1);
						if(current_y >= dropBound){
							CurrentReachBottom = true;
						}
							
					}
				}
			}
		}
		
		if(CurrentReachBottom)  
		{
			score += 10;
			for(int m=0;m<4;m++)
				for(int n=0;n<4;n++)
					if(shape[shapeTransfom][m][n]){
						try {
							ShapePainted[current_y/20 + n][current_x/20 + m].Draw(thisColor);
						}
						catch(ArrayIndexOutOfBoundsException exception) {
							System.out.println("You lose !");
							System.exit(0);
						}

						
					}
						
			
			Stack<Integer> ES = CheckEliminate();
			while(!ES.empty())
			{
				score += 100;
				lines += 1;
				int target = ES.pop();
				for(int j=0;j<10;j++)
					for(int i=target;i>1;i--)
					{
						
						ShapePainted[i][j].Replace(ShapePainted[i-1][j]);;
					}
			}
			
			// make next shape random 
			Random random = new Random(System.currentTimeMillis());
			kind = nextkind;
			nextkind = random.nextInt(7);

			thisColor = nextColor;
			nextColor = s.getColor(nextkind);
			
			current_x = 60;
			current_y = 0;
			CurrentReachBottom = false;
		}
		
			
		if(gameStatus==2||gameStatus==3)  
		{	Color c = new Color(0, 102, 204);
			gBuffer.setColor(c);
			gBuffer.drawRect(40,200,120,30);
			gBuffer.setColor(c);
			gBuffer.setFont(new Font("Font.TYPE1_FONT",Font.BOLD,22));
			gBuffer.drawString("PAUSE", 67, 225);
		}
		if(statusChange)
		{
			statusChange = false;
			this.repaint();
		}
		
		gBuffer.setColor(Color.black); 
		
		Dimension d = getSize();
		gBuffer.drawRect(0, 0, d.width - 1, d.height - 1);
		g.drawImage(iBuffer, 0, 0,this);
	
	}

	
public Stack<Integer> CheckEliminate() 
	{
		Stack<Integer> result = new Stack<Integer>();
		boolean EliminateFlag;
		for(int i=0;i<20;i++)
		{
			EliminateFlag = true;
			for(int j=0;j<10;j++)
			{
				if(!ShapePainted[i][j].isPainted())
				{
					EliminateFlag = false;
					break;
				}
			}
			if(EliminateFlag)
			{
				result.push(i);
			}
		}
		return result;
	}
	
	public boolean IntersectionDetection()  
	{
		for(int i=0;i<4;i++)
		{
			
			for(int j=0;j<4;j++)
			{
				if(shape[shapeTransfom][j][i])
				{
					if(ShapePainted[(current_y+i*shapesize)/shapesize][(current_x+j*shapesize)/shapesize].isPainted())
						return true;
					
				}
			}
		}
		return false;
	}
	
	public void SetCurrentDrop(double speed)
	{
		last = 40;
		current_y += speed;		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gameStatus==1)
		{
			gameStatus = 2;
			statusChange = true;
		}
		else if(gameStatus==0)
		{
			gameStatus = 3;
			statusChange = true;
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(gameStatus==2)
		{
			gameStatus = 1;
			statusChange = true;
		}else if(gameStatus== 3 || gameStatus == 0){	
			gameStatus = 1;
			for(int i=0;i<20;i++)
				for(int j=0;j<10;j++)
					ShapePainted[i][j].SetPainted(false);
			Random random = new Random(System.currentTimeMillis());
			kind = random.nextInt(7);
			nextkind = random.nextInt(7);
			thisColor = s.getColor(kind);
			nextColor = s.getColor(nextkind);

			statusChange = true;
		}
		
	}
	
}

