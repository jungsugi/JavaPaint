package SubFrame;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import SubPanel.DrawPanel;
import figure.Figure;
import inrfomation.FigureBuffer;
import inrfomation.Information;

public class DrawInternalFrame extends JInternalFrame {
	
	private DrawPanel draw;
	private String mName;
	
	
	public DrawInternalFrame(String name)
	{
		super(name,true,true,true,true);
		
	
		this.addKeyListener(new KeyAdapter() {
			   public void keyPressed(KeyEvent evt) { 
				   if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C) {

					   //Copy Current Figure
		                if(Information.getCurrentFigure()!=null)
		                {
		                	FigureBuffer.getInstance().replaceBuffer(Information.getCurrentFigure());
		                	System.out.println("°´Ã¼ Ä«ÇÇ!");
		                	
		                }
		                else
		            	  {
		  					JOptionPane.showMessageDialog(null,"Error : Cant' find Figure","ERROR",JOptionPane.ERROR_MESSAGE);
		            	  }

		            

		            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V) {

		            	//Paste Bufferd FigureSet
		            	  if(!FigureBuffer.getInstance().isEmpty())
			                {
		            		  	if(Information.getCurrentJPanel()!=null)
		            		  	{
		            		  		Information.getCurrentJPanel().addVector((Vector<Figure>)FigureBuffer.getInstance().gerBuffer().clone());
		            		  		FigureBuffer.getInstance().clearBuffer();
		            		  		System.out.println("°´Ã¼ ºÙ¿©³Ö±â!");
		            		  	}
			                	
			                }
		            	  else
		            	  {
		  					JOptionPane.showMessageDialog(null,"Error : Cant' find BufferSet","ERROR",JOptionPane.ERROR_MESSAGE);
		            	  }
		            	

		            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_A) {
		            	//Copy AllFigure
		                FigureBuffer.getInstance().replaceBuffer(Information.getCurrentJPanel().getVector());
		                JOptionPane.showMessageDialog(null,"COPY ALL PANEL FIGURE","COPY",JOptionPane.PLAIN_MESSAGE);
	                	
		            }
			   }
			
		});
		
		this.setFocusable(true);
		this.mName=name;
		setSize(500,500);
		setBackground(Color.WHITE);
		
		draw = new DrawPanel();
		add(draw);
		setVisible(true);
	}
	
	
	public void  replacePanel(DrawPanel panel)
	{	
		draw.changeVector(panel.getVector());
		repaint();
	}

}
