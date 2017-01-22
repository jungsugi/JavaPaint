package Frame;

import java.awt.Color;
import javax.swing.JFrame;

import inrfomation.Information;

public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MainFrame.getInstance().setBackground(Color.DARK_GRAY);
		MainFrame.getInstance().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MainFrame.getInstance().setSize(Information.PROGRAM_WIDTH,Information.PROGRAM_HEIGHT);
		MainFrame.getInstance().setVisible(true);
	
	}

}
