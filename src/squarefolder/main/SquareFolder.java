package squarefolder.main;

import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import squarefolder.io.net.SquareFolderDevice;
import squarefolder.listeners.TrayIconMenuActionListener;

/**
 * Main class for the SquareFolder application.
 * */
public class SquareFolder extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "SquareFolder Folder Syncing Tool";
	
	/**The port that this instance of SquareFolder runs on.*/
	private int port;
	
	/**The SquareFolderDevice that belongs to this computer.*/
	private SquareFolderDevice ourDevice;
	
	/// GUI related stuff ///
	
	private PopupMenu popup;
	private TrayIcon trayIcon;
	private SystemTray sysTray;
	
	public MenuItem exit;
	
	public SquareFolder(int port) throws IOException
	{
		super(NAME);
		
		this.port = port;
		
		ourDevice = new SquareFolderDevice(InetAddress.getLocalHost());
		
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
	
	public int getPort()
	{
		return this.port;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	public SquareFolderDevice getOurDevice()
	{
		return ourDevice;
	}

}
