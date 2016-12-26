package squarefolder.main;

import javax.swing.UIManager;

import squarefolder.main.SquareFolder.DeviceType;

public class Main 
{
	
	private static final int DEFAULT_PORT = 5557;
	
	public static void main(String[] args)
	{
		System.out.println("Starting SquareFolder");
		
		int port;
		DeviceType type = DeviceType.Client;
		
		try
		{
			port = Integer.parseInt(args[0]);
			
		}
		catch(NumberFormatException e)
		{
			//Use default port if either no port was passed, or the passed in port was not a number.
			port = DEFAULT_PORT;
		}

		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			SquareFolder squareFolder = new SquareFolder(type, port);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
