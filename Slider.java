package Homework3;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class Slider extends JPanel{
	static int M = 1;
	static int N = 20;
	static double S = 0.1;
	static int unit = 20;
	
	private Hashtable<Integer, JLabel> scoreTable = new Hashtable<Integer, JLabel>();
	private Hashtable<Integer, JLabel> rowTable = new Hashtable<Integer, JLabel>();
	private Hashtable<Integer, JLabel> speedTable = new Hashtable<Integer, JLabel>();
	private Hashtable<Integer, JLabel> unitTable = new Hashtable<Integer, JLabel>();
	
	private JLabel scoreFactor;
	private JLabel rowFactor;
	private JLabel speedFactor;
	private JLabel unitFactor;

	private JSlider scoreJSlider;
	private JSlider rowJSlider;
	private JSlider speedJSlider;
	private JSlider unitJSlider;

	GameScreen gameScreen = null;
	public Slider(GameScreen gameScreen){
		this.gameScreen = gameScreen;
		
		scoreTable.put(new Integer(1), new JLabel("1"));
		scoreTable.put(new Integer(10), new JLabel("10"));
		rowTable.put(new Integer(20), new JLabel("20"));
		rowTable.put(new Integer(50), new JLabel("50"));
		speedTable.put(new Integer(1), new JLabel("0.1"));
		speedTable.put(new Integer(10), new JLabel("1.0"));
		unitTable.put(new Integer(1), new JLabel("1"));
		unitTable.put(new Integer(3), new JLabel("3"));
		

		// Set the component of scoring factor using JSlider of JAVA and its ActionListener
		scoreFactor = new JLabel("Scoring Factor");
		scoreFactor.setBorder(BorderFactory.createEmptyBorder(0, 20, -50, 0));
		scoreJSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 1);
		//scoreJSlider.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
		scoreJSlider.setLabelTable(scoreTable);
		scoreJSlider.setMajorTickSpacing(1);
		scoreJSlider.setPaintTicks(true);
		scoreJSlider.setPaintLabels(true);
		scoreJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider jslider = (JSlider) e.getSource();
				if (!jslider.getValueIsAdjusting()) {
					int value = (int) jslider.getValue();
					updateScoreFactor(value);
					System.out.println(M);
				}
			}
		});

		// Set the component of row requirement of each level using JSpinner of JAVA and its ActionListener
		rowFactor = new JLabel("Row Factor");
		rowFactor.setBorder(BorderFactory.createEmptyBorder(0, 20, -50, 0));
		rowJSlider = new JSlider(SwingConstants.HORIZONTAL, 20, 50, 20);
		rowJSlider.setLabelTable(rowTable);
		rowJSlider.setMajorTickSpacing(5);
		rowJSlider.setPaintTicks(true);
		rowJSlider.setPaintLabels(true);
		
		rowJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider jslider = (JSlider) e.getSource();
				int value = (int) jslider.getValue();
				updateRowFactor(value);
				System.out.println("N:"+N);
			}
		});
		
		speedFactor = new JLabel("Speeding Factor");
		speedFactor.setBorder(BorderFactory.createEmptyBorder(0, 20, -50, 20));
		speedJSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 10, 1);
		speedJSlider.setLabelTable(speedTable);
		speedJSlider.setMajorTickSpacing(1);
		speedJSlider.setPaintTicks(true);
		speedJSlider.setPaintLabels(true);
		
		speedJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider jslider = (JSlider) e.getSource();
				float value = (float) jslider.getValue();
				updateSpeedFactor(value/10);
				System.out.println("s:"+S);
			}
		});
		
		unitFactor = new JLabel("Default or Enlarge Size");
		unitFactor.setBorder(BorderFactory.createEmptyBorder(0, 20, -50, 20));
		unitJSlider = new JSlider(SwingConstants.HORIZONTAL, 1, 2, 1);
		unitJSlider.setLabelTable(unitTable);
		unitJSlider.setMajorTickSpacing(1);
		unitJSlider.setPaintTicks(true);
		unitJSlider.setPaintLabels(true);
		
		unitJSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JSlider jslider = (JSlider) e.getSource();
				int value = jslider.getValue();
				updateUnitFactor(value);
				System.out.println("unit:"+unit);
			}
		});
		
		this.setLayout(new GridLayout(0,1));
		add(scoreFactor);
		add(scoreJSlider);
		add(rowFactor);
		add(rowJSlider);
		add(speedFactor);
		add(speedJSlider);
		add(unitFactor);
		add(unitJSlider);
	}
	
	public void updateScoreFactor(int factor) {
		this.M = factor;
	}

	public void updateRowFactor(int factor) {
		this.N = factor;
	}

	public void updateSpeedFactor(double factor) {
		this.S = factor;
		//double speed = gameScreen.speed;
		
		gameScreen.speed = 20.0 * (1 + factor);
		System.out.println(gameScreen.speed);

		gameScreen.SetCurrentDrop(gameScreen.speed);
	}
	public void updateUnitFactor(int factor) {
		this.unit = factor;
		if(factor == 2){
			InterfaceOfGame2 ig = new InterfaceOfGame2();
		}


		
		System.out.println("factor is :" + factor);
		System.out.println("unit is :" + Slider.unit);
	}
	
	public int getM(){
		return M;
	}
	
	public int getN(){
		return N;
	}
	
	public double getS(){
		return S;
	}
	
}