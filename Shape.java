package Homework3;

import java.awt.Color;
/*
 * Store the game default data
 * 
 * */
public class Shape {

	private final boolean[][][][] ShapeOfSquares;
	private final int shapeSize = 20;
	private final int ShapeBound[][][];
	Shape()
	{	
		// total seven shapes in the game
		ShapeOfSquares = new boolean[7][4][4][4];
		ShapeBound = new int[7][4][4];
		// Initialize all kinds of possible shape combination 
		ShapeOfSquares[0][0][0][0] = true; 
		ShapeOfSquares[0][0][0][1] = true;
		ShapeOfSquares[0][0][1][0] = true;
		ShapeOfSquares[0][0][1][1] = true;
		
		ShapeOfSquares[0][1][0][0] = true; 
		ShapeOfSquares[0][1][0][1] = true;
		ShapeOfSquares[0][1][1][0] = true;
		ShapeOfSquares[0][1][1][1] = true;
		
		ShapeOfSquares[0][2][0][0] = true;
		ShapeOfSquares[0][2][0][1] = true;
		ShapeOfSquares[0][2][1][0] = true;
		ShapeOfSquares[0][2][1][1] = true;
		
		ShapeOfSquares[0][3][0][0] = true; 
		ShapeOfSquares[0][3][0][1] = true;
		ShapeOfSquares[0][3][1][0] = true;
		ShapeOfSquares[0][3][1][1] = true;
		
		ShapeOfSquares[1][0][0][2] = true; 
		ShapeOfSquares[1][0][1][2] = true;
		ShapeOfSquares[1][0][2][2] = true;
		ShapeOfSquares[1][0][3][2] = true;
		
		ShapeOfSquares[1][1][1][0] = true;
		ShapeOfSquares[1][1][1][1] = true;
		ShapeOfSquares[1][1][1][2] = true;
		ShapeOfSquares[1][1][1][3] = true;
		
		ShapeOfSquares[1][2][0][2] = true; 
		ShapeOfSquares[1][2][1][2] = true;
		ShapeOfSquares[1][2][2][2] = true;
		ShapeOfSquares[1][2][3][2] = true;
		
		ShapeOfSquares[1][3][1][0] = true;
		ShapeOfSquares[1][3][1][1] = true;
		ShapeOfSquares[1][3][1][2] = true;
		ShapeOfSquares[1][3][1][3] = true;
		
		ShapeOfSquares[2][0][0][1] = true; 
		ShapeOfSquares[2][0][1][1] = true;
		ShapeOfSquares[2][0][2][1] = true;
		ShapeOfSquares[2][0][2][2] = true;
		
		ShapeOfSquares[2][1][0][2] = true; 
		ShapeOfSquares[2][1][1][0] = true;
		ShapeOfSquares[2][1][1][1] = true;
		ShapeOfSquares[2][1][1][2] = true;
		
		ShapeOfSquares[2][2][0][1] = true;
		ShapeOfSquares[2][2][0][2] = true;
		ShapeOfSquares[2][2][1][2] = true;
		ShapeOfSquares[2][2][2][2] = true;
		
		ShapeOfSquares[2][3][1][0] = true;
		ShapeOfSquares[2][3][1][1] = true;
		ShapeOfSquares[2][3][1][2] = true;
		ShapeOfSquares[2][3][2][0] = true;
		
		ShapeOfSquares[3][0][0][0] = true; 
		ShapeOfSquares[3][0][0][1] = true;
		ShapeOfSquares[3][0][1][1] = true;
		ShapeOfSquares[3][0][1][2] = true;
		
		ShapeOfSquares[3][1][0][2] = true; 
		ShapeOfSquares[3][1][1][1] = true;
		ShapeOfSquares[3][1][1][2] = true;
		ShapeOfSquares[3][1][2][1] = true;
		
		ShapeOfSquares[3][2][0][0] = true;
		ShapeOfSquares[3][2][0][1] = true;
		ShapeOfSquares[3][2][1][1] = true;
		ShapeOfSquares[3][2][1][2] = true;
		
		ShapeOfSquares[3][3][0][2] = true; 
		ShapeOfSquares[3][3][1][1] = true;
		ShapeOfSquares[3][3][1][2] = true;
		ShapeOfSquares[3][3][2][1] = true;
		// L shape part 2
		ShapeOfSquares[4][0][0][2] = true; 
		ShapeOfSquares[4][0][1][2] = true;
		ShapeOfSquares[4][0][2][1] = true;
		ShapeOfSquares[4][0][2][2] = true;
		
		ShapeOfSquares[4][1][1][0] = true; 
		ShapeOfSquares[4][1][1][1] = true;
		ShapeOfSquares[4][1][1][2] = true;
		ShapeOfSquares[4][1][2][2] = true;
		
		ShapeOfSquares[4][2][0][1] = true; 
		ShapeOfSquares[4][2][0][2] = true;
		ShapeOfSquares[4][2][1][1] = true;
		ShapeOfSquares[4][2][2][1] = true;
		
		ShapeOfSquares[4][3][0][0] = true; 
		ShapeOfSquares[4][3][1][0] = true;
		ShapeOfSquares[4][3][1][1] = true;
		ShapeOfSquares[4][3][1][2] = true;
		// Z shape part 2
		ShapeOfSquares[5][0][0][1] = true; 
		ShapeOfSquares[5][0][0][2] = true;
		ShapeOfSquares[5][0][1][0] = true;
		ShapeOfSquares[5][0][1][1] = true;
		
		ShapeOfSquares[5][1][0][1] = true; 
		ShapeOfSquares[5][1][1][1] = true;
		ShapeOfSquares[5][1][1][2] = true;
		ShapeOfSquares[5][1][2][2] = true;
		
		ShapeOfSquares[5][2][0][1] = true; 
		ShapeOfSquares[5][2][0][2] = true;
		ShapeOfSquares[5][2][1][0] = true;
		ShapeOfSquares[5][2][1][1] = true;
		
		ShapeOfSquares[5][3][0][1] = true; 
		ShapeOfSquares[5][3][1][1] = true;
		ShapeOfSquares[5][3][1][2] = true;
		ShapeOfSquares[5][3][2][2] = true;
		// T shape 
		
		ShapeOfSquares[6][0][0][1] = true; 
		ShapeOfSquares[6][0][1][0] = true;
		ShapeOfSquares[6][0][1][1] = true;
		ShapeOfSquares[6][0][1][2] = true;
		
		ShapeOfSquares[6][1][0][1] = true; 
		ShapeOfSquares[6][1][1][0] = true;
		ShapeOfSquares[6][1][1][1] = true;
		ShapeOfSquares[6][1][2][1] = true;
		
		ShapeOfSquares[6][2][1][0] = true; 
		ShapeOfSquares[6][2][1][1] = true;
		ShapeOfSquares[6][2][1][2] = true;
		ShapeOfSquares[6][2][2][1] = true;
		
		ShapeOfSquares[6][3][0][1] = true; 
		ShapeOfSquares[6][3][1][1] = true;
		ShapeOfSquares[6][3][1][2] = true;
		ShapeOfSquares[6][3][2][1] = true;
		
		
		
		ShapeBound[0][0][0] = 2;  
		ShapeBound[0][0][1] = 0;  
		ShapeBound[0][0][2] = 2;  
		
		ShapeBound[0][1][0] = 2;  
		ShapeBound[0][1][1] = 0;  
		ShapeBound[0][1][2] = 2;  
		
		ShapeBound[0][2][0] = 2;  
		ShapeBound[0][2][1] = 0;  
		ShapeBound[0][2][2] = 2;  
		
		ShapeBound[0][3][0] = 2;  
		ShapeBound[0][3][1] = 0;  
		ShapeBound[0][3][2] = 2;  
		
		ShapeBound[1][0][0] = 4;  
		ShapeBound[1][0][1] = 0;  
		ShapeBound[1][0][2] = 3;  
		
		ShapeBound[1][1][0] = 2; 
		ShapeBound[1][1][1] = 1;  
		ShapeBound[1][1][2] = 4;  
		
		ShapeBound[1][2][0] = 4;  
		ShapeBound[1][2][1] = 0;  
		ShapeBound[1][2][2] = 3;  
		
		ShapeBound[1][3][0] = 2;  
		ShapeBound[1][3][1] = 1;  
		ShapeBound[1][3][2] = 4;  
		
		ShapeBound[2][0][0] = 3;  
		ShapeBound[2][0][1] = 0;  
		ShapeBound[2][0][2] = 3;  
		
		ShapeBound[2][1][0] = 2;  
		ShapeBound[2][1][1] = 0;  
		ShapeBound[2][1][2] = 3;  
		
		ShapeBound[2][2][0] = 3;  
		ShapeBound[2][2][1] = 0;  
		ShapeBound[2][2][2] = 3; 
		
		ShapeBound[2][3][0] = 3;  
		ShapeBound[2][3][1] = 1;  
		ShapeBound[2][3][2] = 3;  
		
		ShapeBound[3][0][0] = 2;  
		ShapeBound[3][0][1] = 0;  
		ShapeBound[3][0][2] = 3;  
		
		ShapeBound[3][1][0] = 3;  
		ShapeBound[3][1][1] = 0;  
		ShapeBound[3][1][2] = 3;  
		
		ShapeBound[3][2][0] = 2;  
		ShapeBound[3][2][1] = 0;  
		ShapeBound[3][2][2] = 3;  
		
		ShapeBound[3][3][0] = 3;  
		ShapeBound[3][3][1] = 0;  
		ShapeBound[3][3][2] = 3;  
		
		ShapeBound[4][0][0] = 3;  
		ShapeBound[4][0][1] = 0;  
		ShapeBound[4][0][2] = 3;  
		
		ShapeBound[4][1][0] = 3;  
		ShapeBound[4][1][1] = 1;  
		ShapeBound[4][1][2] = 3;  
		
		ShapeBound[4][2][0] = 3;  
		ShapeBound[4][2][1] = 0;  
		ShapeBound[4][2][2] = 3;  
		
		ShapeBound[4][3][0] = 2;  
		ShapeBound[4][3][1] = 0;  
		ShapeBound[4][3][2] = 3; 
		
		// Z shape part 2
		ShapeBound[5][0][0] = 2;  
		ShapeBound[5][0][1] = 0;  
		ShapeBound[5][0][2] = 3;  
		
		ShapeBound[5][1][0] = 3;  
		ShapeBound[5][1][1] = 0;  
		ShapeBound[5][1][2] = 3;  
		
		ShapeBound[5][2][0] = 2;  
		ShapeBound[5][2][1] = 0;  
		ShapeBound[5][2][2] = 3;  
		
		ShapeBound[5][3][0] = 3;  
		ShapeBound[5][3][1] = 0;  
		ShapeBound[5][3][2] = 3; 
		// T shape 
		ShapeBound[6][0][0] = 2;  
		ShapeBound[6][0][1] = 0;  
		ShapeBound[6][0][2] = 3;  
		
		ShapeBound[6][1][0] = 3;  
		ShapeBound[6][1][1] = 0;  
		ShapeBound[6][1][2] = 2;  
		
		ShapeBound[6][2][0] = 3;  
		ShapeBound[6][2][1] = 1;  
		ShapeBound[6][2][2] = 3;  
		
		ShapeBound[6][3][0] = 3;  
		ShapeBound[6][3][1] = 0;  
		ShapeBound[6][3][2] = 3; 
		
		
	}
	// make each shape unique color
	public Color getColor(int type)
	{
		switch(type){
			case 0 :
				return Color.GREEN;
			case 1 :
				return new Color(153, 204, 255);	
			case 2 :
				return Color.RED;
			case 3 :
				return new Color(76, 0, 153);
			case 4 :
				return new Color(0, 76, 153);
			case 5 :
				return Color.YELLOW;
			case 6 :
				return new Color(102, 102, 0);
			default :
				return Color.WHITE;
		}
	}
	
	public int getShapeSize()
	{
		return shapeSize;
	}
	public boolean[][][] getShape(int i)
	{
		return ShapeOfSquares[i];
	}
	public int[][] getBound(int i)
	{
		return ShapeBound[i];
	}
}
