package Homework3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceOfGame extends JFrame{
	public JButton quitButton = new JButton("Quit");
	public int startX=0, startY=0, zoom=0;

	private GameScreen gameScreen;	
	private InfoScreen infoScreen;
	private Slider slider;
	
	
	InterfaceOfGame()
	{
		gameScreen = new GameScreen();
		int unit = Slider.unit;
		// Initialize the panel 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,500);
		//setLocation(300, 150);
		setVisible(true);
		setTitle("Interface of Tetris");
		//setLayout(new BorderLayout());
		setLayout(null);
		// Initialize the game screen 
		gameScreen.setPreferredSize(new Dimension(200,400));
		gameScreen.setBounds(50, 20, 200, 400);
		add(gameScreen);
		gameScreen.gameStatus = 0; 
		// Initialize the information screen left to the game screen 
		infoScreen = new InfoScreen(gameScreen);
		infoScreen.setPreferredSize(new Dimension(200,400));
		infoScreen.setBounds(290, 20, 200, 400);
		add(infoScreen);
		
	    slider = new Slider(gameScreen);
	    slider.setPreferredSize(new Dimension(300,480));
	    slider.setBounds(490,-40, 300, 480);
	    add(slider);
		// add the quit button
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new FlowLayout());
		jPanel.add(quitButton);
		jPanel.setBounds(80, 420,500 ,200);
	    add(jPanel);
	    
	    Timer timer1 = new Timer(); 
	    Drop tasktimer = new Drop(gameScreen);
	    timer1.schedule(tasktimer, 800,800);
	    
	    Timer timer2 = new Timer(); 
	    TimerMain tm = new TimerMain(gameScreen,infoScreen,slider);
	    timer2.schedule(tm, 200,200);

	    quitButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Tetris game has ended !");
				System.exit(0);
				}
			}
	    );
	}
}

class TimerMain extends TimerTask {  
	GameScreen mainCanvas;
	InfoScreen infoScreen;
	Slider slider;
	TimerMain(GameScreen mainCanvas,InfoScreen infoScreen, Slider slider)
	{
		this.mainCanvas = mainCanvas;
		this.infoScreen = infoScreen;
		this.slider = slider;
	}
	
      public void run() {
    	  infoScreen.setString(mainCanvas.score, mainCanvas.lines, mainCanvas.level);
    	  mainCanvas.requestFocusInWindow();
    	  mainCanvas.repaint();
    	  infoScreen.repaint();
    	  slider.repaint();
    	  
      }  
  } 
class Drop extends TimerTask {  
	GameScreen mainCanvas;
	Drop(GameScreen mainCanvas)
	{
		this.mainCanvas = mainCanvas;
	}
      public void run() {
    	  if(mainCanvas.gameStatus==1)
    	  {		
    		  double curSpeed = mainCanvas.speed;
	    	  mainCanvas.SetCurrentDrop(curSpeed);
	    	  
    	  }
      }  
  } 
