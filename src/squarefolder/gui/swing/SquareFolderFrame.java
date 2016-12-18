package squarefolder.gui.swing;

import javax.swing.JFrame;

import squarefolder.listeners.TrayIconMenuActionListener;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;


public class SquareFolderFrame extends JFrame
{
	
	public static final String NAME = "SquareFolder - Folder Syncing Tool";

	private static final long serialVersionUID = 5029578704108845653L;
	
	private PopupMenu popup;
	private TrayIcon trayIcon;
	private SystemTray sysTray;
	
	public MenuItem exit;
	
	/**
	 * @param	visibleOnStart		determines whether to make the frame visible immediately after instantiating.
	 * */
	public SquareFolderFrame(boolean visibleOnStart)
	{
		super(NAME);
		
		SquareFolderPanel sfPanel = new SquareFolderPanel();
		
		this.add(sfPanel);
		this.pack();
		this.setVisible(visibleOnStart);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		this.setupTrayIcon();
	}
	
	private void setupTrayIcon()
	{
		if(SystemTray.isSupported()) 
		{
			try 
			{
		 		popup = new PopupMenu();
				trayIcon = new TrayIcon(ImageIO.read(new File("squarefolder.png")));
				sysTray = SystemTray.getSystemTray();
				   
				exit = new MenuItem("Exit");
				   
				popup.add(exit);
				   
				trayIcon.setPopupMenu(popup);
	        	sysTray.add(trayIcon);
	        	
	        	TrayIconMenuActionListener listener = new TrayIconMenuActionListener(this);
	        	listener.addListenerToMenuItems();
	        	
	    	} 
			catch (Exception e) 
			{
	        	System.out.println("TrayIcon could not be added.");
	    	}
		}
	}
	
	public void hideSquareFolder()
	{
		this.setVisible(false);
	}
	
}
