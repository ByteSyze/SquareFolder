package squarefolder.main;

import java.io.IOException;
import java.net.InetAddress;

import squarefolder.gui.swing.SquareFolderFrame;
import squarefolder.io.net.SFClient;
import squarefolder.io.net.SFDevice;
import squarefolder.io.net.SFServer;

/**
 * Main class for the SquareFolder application.
 * */
public class SquareFolder
{
	public enum DeviceType { Server, Client };
	
	/**The port that this instance of SquareFolder runs on.*/
	private int port;
	
	/**The SquareFolderDevice that belongs to this computer.*/
	private SFDevice ourDevice;
	
	/// GUI related stuff ///
	private SquareFolderFrame sfFrame;

	/**
	 * @param	port				what port to bind this SquareFolder's device sockets to.
	 * */
	public SquareFolder(DeviceType type, int port)
	{
		
		this.port = port;
		
		this.sfFrame = new SquareFolderFrame(false);
		
		try 
		{
			if(type == DeviceType.Server)
			{
				ourDevice = new SFServer(port);
			}
			else if(type == DeviceType.Client)
			{
				ourDevice = new SFClient(InetAddress.getLocalHost(), port);
			}
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	public int getPort()
	{
		return this.port;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
	
	public SFDevice getOurDevice()
	{
		return ourDevice;
	}
	
	public SquareFolderFrame getSquareFolderFrame()
	{
		return sfFrame;
	}

}
