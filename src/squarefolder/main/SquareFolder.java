package squarefolder.main;

import java.io.IOException;
import java.net.InetAddress;

import javax.swing.JFrame;

import squarefolder.io.net.SquareFolderDevice;

/**
 * 
 * Main class for the SquareFolder application.
 * 
 * */
public class SquareFolder extends JFrame
{

	private static final long serialVersionUID = 1L;
	
	public static final String NAME = "SquareFolder Folder Syncing Tool";
	
	private int port;
	
	/** The SquareFolderDevice that belongs to this computer.*/
	private SquareFolderDevice ourDevice;
	
	public SquareFolder(int port) throws IOException
	{
		super(NAME);
		
		this.port = port;
		
		ourDevice = new SquareFolderDevice(InetAddress.getLocalHost());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
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
