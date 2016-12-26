package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class SFClient extends SFDevice
{
	private InetAddress serverAddress;
	
	public SFClient(InetAddress serverAddress, int port) throws IOException 
	{
		super(port);
		
		this.serverAddress = serverAddress;
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException
	{
		socket = new Socket(serverAddress, port);
		return false;
	}
	
	@Override
	public void closeTCPSocket(Socket socket) throws IOException
	{
		socket.close();
	}
	
}
