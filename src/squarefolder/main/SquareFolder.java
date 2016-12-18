package squarefolder.main;

import squarefolder.gui.swing.SquareFolderFrame;
import squarefolder.io.net.SFDevice;

/**
 * Main class for the SquareFolder application.
 * */
public class SquareFolder
{
	
	/**The port that this instance of SquareFolder runs on.*/
	private int port;
	
	/**The SquareFolderDevice that belongs to this computer.*/
	private SFDevice ourDevice;
	
	/// GUI related stuff ///
	private SquareFolderFrame sfFrame;

	/**
	 * @param	port				what port to bind this SquareFolder's device sockets to.
	 * */
	public SquareFolder(int port)
	{
		
		this.port = port;
		
		this.sfFrame = new SquareFolderFrame(false);
		
		//ourDevice = new SFDevice(InetAddress.getLocalHost());
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
