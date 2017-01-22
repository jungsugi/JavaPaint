package Frame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

import SubFrame.DrawInternalFrame;
import SubFrame.RightDownInternalFrame;
import SubFrame.RightUpInternalFrame;
import inrfomation.Information;

public class MainDesktopPane extends JDesktopPane{
	
//	private DrawInternalFrame drawInternalFrame;
	private HashMap<String, DrawInternalFrame> drawInternalFrameSet;
	private RightUpInternalFrame rightUpInternalFrame;
	private RightDownInternalFrame rightDownInternalFrame;
	private ImageIcon backgrountIcon;

	private static MainDesktopPane instance;
	
	
	public static MainDesktopPane getInstance()
	{
		if(instance==null) instance = new MainDesktopPane();
		return instance;
	}
	
	
	public MainDesktopPane()
	{
	
		drawInternalFrameSet= new HashMap<String, DrawInternalFrame>();
	
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);
		
		backgrountIcon = new ImageIcon("resource/ui_1_01.png");
		

		rightUpInternalFrame = new RightUpInternalFrame();
		rightDownInternalFrame = RightDownInternalFrame.getInstance();
		
		
		
		rightUpInternalFrame.setLocation(1190, 0);
		rightDownInternalFrame.setLocation(1190,360);

		

//		this.add(drawInternalFrame);
		this.add(rightUpInternalFrame);
		this.add(rightDownInternalFrame);

	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		int width = getWidth();
		int height = getHeight();
		g.drawImage(backgrountIcon.getImage(), width/2-400, height/2-350, null);
		rightUpInternalFrame.setLocation(width-300, 0);
		rightDownInternalFrame.setLocation(width-300,350);

	}
	

	
	public void addDrawFrameToSet(String name, DrawInternalFrame newFrame)
	{
		drawInternalFrameSet.put(name, newFrame);	
	}
	
	public DrawInternalFrame getDrawFrame(String key)
	{
		System.out.println("ÆÐ½º : "+ key);
		return drawInternalFrameSet.get(key);
	}
}
