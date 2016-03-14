package squarefolder.main;

import javax.swing.JFrame;

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
	
	public SquareFolder(int port)
	{
		super(NAME);
		
		this.port = port;
		
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

}
