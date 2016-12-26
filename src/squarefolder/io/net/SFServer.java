package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SFServer extends SFDevice
{
	
	private ServerSocket serverSocket;

	public SFServer(int port) throws IOException 
	{
		super(port);
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException 
	{
		serverSocket = new ServerSocket(port);
		socket = serverSocket.accept();
		
		return false;
	}
	
	@Override
	public void closeTCPSocket(Socket socket) throws IOException
	{
		socket.close();
	}

}
