package Homework3;

public class GameEntrance {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		       public void run() {
		    	   System.out.println("Tetris game has started !");
		    	   new InterfaceOfGame();
			   	   
		       }
			}
		);
		
	}

}