package SubFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import inrfomation.Information;

public class LeftPanel extends JPanel implements ActionListener{

	private ImageIcon ic_Choose,ic_paint,ic_Circle,ic_Pen,ic_Line,ic_Rec,ic_Triangle,ic_era,ic_Text,ic_Resize;
	private JButton button_Choose,button_Paint,button_Pen,button_Circle,
					button_Line,button_Rec,button_Triangle,button_Erager,button_Text,button_Resize;
	
	
	public LeftPanel()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		
		ic_Choose = new ImageIcon("resource/select.png");
		ic_Resize = new ImageIcon("resource/resize.png");
		ic_paint = new ImageIcon("resource/Paint.png");
		ic_Pen = new ImageIcon("resource/pen.png");
		ic_Circle = new ImageIcon("resource/circle.png");
		ic_Line = new ImageIcon("resource/line.png");
		ic_Rec = new ImageIcon("resource/rec.png");
		ic_Triangle = new ImageIcon("resource/triangle.png");
		ic_era = new ImageIcon("resource/era.png");
		ic_Text = new ImageIcon("resource/text.png");
		
		button_Choose = new JButton(ic_Choose);
		button_Resize = new JButton(ic_Resize);
		button_Paint = new JButton(ic_paint);
		button_Pen = new JButton(ic_Pen);
		button_Circle = new JButton(ic_Circle);
		button_Line = new JButton(ic_Line);
		button_Rec = new JButton(ic_Rec);
		button_Triangle = new JButton(ic_Triangle);
		button_Erager = new JButton(ic_era);
		button_Text= new JButton(ic_Text);
		
		
		
		button_Choose.setSize(50, 50); button_Choose.setName("choose"); button_Choose.setBackground(Color.DARK_GRAY);  button_Choose.setBorderPainted(false); button_Choose.setFocusPainted(false);
		button_Resize.setSize(50, 50); button_Resize.setName("resize"); button_Resize.setBackground(Color.DARK_GRAY);  button_Resize.setBorderPainted(false); button_Resize.setFocusPainted(false);
		button_Paint.setSize(50, 50); button_Paint.setName("paint"); button_Paint.setBackground(Color.DARK_GRAY);  button_Paint.setBorderPainted(false); button_Paint.setFocusPainted(false);
		button_Pen.setSize(50, 50); button_Pen.setName("pen"); button_Pen.setBackground(Color.DARK_GRAY);  button_Pen.setBorderPainted(false); button_Pen.setFocusPainted(false);
		button_Circle.setSize(50, 50); button_Circle.setName("circle"); button_Circle.setBackground(Color.DARK_GRAY);  button_Circle.setBorderPainted(false); button_Circle.setFocusPainted(false);
		button_Line.setSize(50, 50); button_Line.setName("line"); button_Line.setBackground(Color.DARK_GRAY);  button_Line.setBorderPainted(false); button_Line.setFocusPainted(false);
		button_Rec.setSize(50, 50); button_Rec.setName("rec"); button_Rec.setBackground(Color.DARK_GRAY);  button_Rec.setBorderPainted(false); button_Rec.setFocusPainted(false);
		button_Triangle.setSize(50, 50); button_Triangle.setName("triangle"); button_Triangle.setBackground(Color.DARK_GRAY);  button_Triangle.setBorderPainted(false); button_Triangle.setFocusPainted(false);
		button_Erager.setSize(50, 50); button_Erager.setName("era"); button_Erager.setBackground(Color.DARK_GRAY);  button_Erager.setBorderPainted(false); button_Erager.setFocusPainted(false);
		button_Text.setSize(50, 50); button_Text.setName("text"); button_Text.setBackground(Color.DARK_GRAY);  button_Text.setBorderPainted(false); button_Text.setFocusPainted(false);
		
		button_Choose.addActionListener(this);
		button_Resize.addActionListener(this);
		button_Paint.addActionListener(this);
		button_Pen.addActionListener(this);
		button_Circle.addActionListener(this);
		button_Line.addActionListener(this);
		button_Rec.addActionListener(this);
		button_Triangle.addActionListener(this);
		button_Erager.addActionListener(this);
		button_Text.addActionListener(this);


		this.add(button_Choose);
		this.add(button_Resize);
		this.add(button_Paint);
		this.add(button_Pen);
		this.add(button_Circle);
		this.add(button_Line);
		this.add(button_Rec);
		this.add(button_Triangle);
		this.add(button_Erager);
		this.add(button_Text);
		
	
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton currentButton = (JButton)e.getSource();
		
		switch(currentButton.getName())
		{
		case "choose" : Information.setCurrentMode(Information.MODE_MOVE);break;
		case "resize" : Information.setCurrentMode(Information.MODE_RESIZE);break;
		case "paint" : Information.setCurrentMode(Information.MODE_PAINT);break;
		case "pen" : Information.setCurrentMode(Information.MODE_PEN);break;
		case "circle" : Information.setCurrentMode(Information.MODE_DRAW_CIRCLE); break;
		case "line" : Information.setCurrentMode(Information.MODE_DRAW_LINE); break;
		case "rec" : Information.setCurrentMode(Information.MODE_DRAW_REC); break;
		case "triangle" : Information.setCurrentMode(Information.MODE_DRAW_TRIANGLE); break;
		case "era" : Information.setCurrentMode(Information.MODE_ERAGE); break;
		case "text" : Information.setCurrentMode(Information.MODE_TEXT); break;
		
		
		default : break;
		}
		
		
	}
}
