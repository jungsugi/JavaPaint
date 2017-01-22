package SubFrame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import Frame.MainDesktopPane;
import Frame.MainFrame;
import Frame.main;
import SubPanel.DrawPanel;
import inrfomation.Information;

public class TopMenu extends JMenuBar{
	
	private JMenu fileMenu;
	private JMenuItem mkDrawPanel,open,save,exit;
	private JMenu menu2;
	private JMenuItem menu2_item1,menu2_item2,menu2_item3,menu2_item4;
	private JMenu menu3;
	private JMenuItem inform;

	
	public TopMenu()
	{
		this.setBackground(Color.WHITE);
		
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		mkDrawPanel = new JMenuItem("New DrawPanel");
		mkDrawPanel.setMnemonic('N');
		mkDrawPanel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int DrawFrameCnt = Information.getDrawFrame_Count();	
				Information.addDrawFrame_Count();
				MainFrame.getInstance().addDrawFrame(""+DrawFrameCnt+"번쨰 그림판");
				
			}
		});
		
		open = new JMenuItem("Open");
		open.setMnemonic('O');
		open.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				JFileChooser jfilechooser = new JFileChooser();
				jfilechooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int judge = jfilechooser.showOpenDialog(null);
				
				switch(judge)
				{
				case JFileChooser.APPROVE_OPTION : 
					DrawPanel openPanel =null;
					File x = jfilechooser.getSelectedFile();
					try {
						ObjectInputStream in = new ObjectInputStream(new FileInputStream(x));
						openPanel=(DrawPanel)in.readObject();
						
						MainFrame.getInstance().addDrawFrame(x.getPath());
						MainDesktopPane.getInstance().getDrawFrame(x.getPath()).replacePanel(openPanel);
						in.close();
						
					} catch (IOException | ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
					
					break;
				case JFileChooser.CANCEL_OPTION : 
					
					break;
				}
				
			
				
			}
		});
		
		
		save = new JMenuItem("Save");
		save.setMnemonic('S');
		save.addActionListener(new ActionListener(){


			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
					File x=null;
					JFileChooser jfilechooser = new JFileChooser();
					jfilechooser.setFileSelectionMode(JFileChooser.SAVE_DIALOG);
					int judge = jfilechooser.showOpenDialog(null);
					ObjectOutputStream out = null;
				
					switch(judge)
					{
					case JFileChooser.APPROVE_OPTION : 
							x= jfilechooser.getSelectedFile();
						try {
							
							out = new ObjectOutputStream(new FileOutputStream(x));
							System.out.println(Information.getCurrentJPanel());
							out.writeObject(Information.getCurrentJPanel());
							out.flush();
							out.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
							break;
					case JFileChooser.CANCEL_OPTION : 
						return;	
				}
				
			}
		});
		
		
		
		exit = new JMenuItem("Exit"); 
		exit.setMnemonic('E');
		exit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		fileMenu.add(open);
		fileMenu.add(mkDrawPanel);
		fileMenu.add(save);
		fileMenu.add(exit);
		this.add(fileMenu);
		
		menu2 = new JMenu("Edit");
		menu2_item1 = new JMenuItem("메뉴2-1");
		menu2_item2 = new JMenuItem("메뉴2-2");
		menu2_item3 = new JMenuItem("메뉴2-3");
		menu2_item4 = new JMenuItem("메뉴2-4");
		menu2.add(menu2_item1);
		menu2.add(menu2_item2);
		menu2.add(menu2_item3);
		menu2.add(menu2_item4);
		this.add(menu2);
		
		menu3 = new JMenu("Help");
		inform = new JMenuItem("Information");
		inform.setMnemonic('I');
		
		inform.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e){
		
				JOptionPane.showMessageDialog(null,"     Make by KAU_JAVA_CLASS_2015","Made In KAU"
						,JOptionPane.CLOSED_OPTION); 		
			}
		});
		

		menu3.add(inform);
		this.add(menu3);
		
		
		
		
	}

}
