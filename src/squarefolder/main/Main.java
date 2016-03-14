package squarefolder.main;

public class Main 
{
	
	private static final int DEFAULT_PORT = 3337;
	
	public static void main(String[] args)
	{
		
		int port;
		
		try
		{
			port = Integer.parseInt(args[0]);
		}
		catch(Exception e)
		{
			//Use default port if either no port was passed, or the passed in port was not a number.
			port = DEFAULT_PORT;
		}
		
		SquareFolder squareFolder = new SquareFolder(port);
	}
}
