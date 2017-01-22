package inrfomation;

import java.awt.Color;
import java.awt.Font;

import SubPanel.DrawPanel;
import figure.Figure;

public class Information {
	
	public static final String PROGRAM_NAME ="JAVA PAINTER PROJECT";
	public static final int PROGRAM_WIDTH = 1600;
	public static final int PROGRAM_HEIGHT = 900;
	
	public static final int MODE_DRAW_REC=1;
	public static final int MODE_DRAW_TRIANGLE=2;
	public static final int MODE_DRAW_CIRCLE=3;
	public static final int MODE_DRAW_LINE=4;
	public static final int MODE_ERAGE=5;
	public static final int MODE_TEXT=6;
	public static final int MODE_MOVE=7;
	public static final int MODE_PEN=8;
	public static final int MODE_PAINT=9;
	public static final int MODE_RESIZE=10;
		
	
	public static final int IS_EMPTY=-1;
	public static final int IS_ERAGER=0;
	public static final int IS_FIGURE=1;
	
	
	private static int textStyle=Font.PLAIN;
	
	public static void setTextStyle(int font)
	{
		textStyle=font;
	}
	
	public static int gettextStyle()
	{
		return textStyle;
	}
	
	
	private static int textSize=10;
	
	public static void setTextSize(int size)
	{
		textSize=size;
	}
	
	public static int getTextSize()
	{
		return textSize;
	}
	
	
	private static int LineSize=1;
	
	public static void setLineSize(int size)
	{
		LineSize=size;
	}
	
	public static int getLineSize()
	{
		return LineSize;
	}
	
	
	
	
	private static Figure currentFigure =null;
	
	public static void setCurrentFigure(Figure cur)
	{
		currentFigure = cur;
	}
	public static Figure getCurrentFigure()
	{
		return currentFigure;
	}
	
	private static DrawPanel currentPanel=null;
	
	public static void setCurrentpanel(DrawPanel current)
	{
		currentPanel=current;
		
	}
	
	public static DrawPanel getCurrentJPanel()
	{
		return currentPanel;
	}
	
	
	
	private static int DrawFrame_Count =1;
	private static int CurrentMode=1;
	
	private static Color currentColor=new Color(0,0,0);
	
	
	public static  int getDrawFrame_Count(){return DrawFrame_Count;}
	public static  void addDrawFrame_Count(){DrawFrame_Count++;}
	
	public static String getCurrentModeToString()
	{
		switch(CurrentMode)
		{
		case MODE_DRAW_REC : return "사각형 그리기";
		case MODE_DRAW_TRIANGLE : return "삼각형 그리기";
		case MODE_DRAW_CIRCLE : return "원 그리기";
		case MODE_DRAW_LINE : return "선 그리기";
		case MODE_ERAGE : return "지우기";
		case MODE_TEXT : return "텍스트 편집";
		case MODE_MOVE : return "이동 모드";
		case MODE_PEN : return "팬 그리기";
		case MODE_PAINT: return "채우기";
		case MODE_RESIZE : return "리사이즈 모드";
		default : return "선택된 모드가 없습니다.";
		}
		
	}

	public static int getCurrentMode()
	{
		return CurrentMode;
	}
	
	public static void setCurrentMode(int mode)
	{
		CurrentMode=mode;
	}
	
	public static Color getCurrentColor()
	{
		return currentColor;
	}
	public static void setCurrentColor(int R, int G, int B)
	{
		Color changeColor = new Color(R,G,B);
		currentColor= changeColor;
		if(Information.getCurrentMode()==Information.MODE_PAINT)
		{
			if(Information.getCurrentFigure()!=null)
			{
				Information.getCurrentFigure().setColor(currentColor);
				Information.getCurrentJPanel().repaint();
			}
		}
	}
}
