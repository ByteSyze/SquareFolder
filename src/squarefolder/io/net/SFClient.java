package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class SFClient extends SFDevice
{
	private InetAddress serverAddress;
	
	public SFClient(InetAddress serverAddress, int udpPort, int tcpPort) throws IOException 
	{
		super(udpPort, tcpPort);
		
		this.serverAddress = serverAddress;
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException
	{
		socket = new Socket(serverAddress, tcpPort);
		return false;
	}

	@Override
	public boolean initializeUDPSocket(DatagramSocket socket) throws IOException 
	{
		return false;
	}
	
	@Override
	public void closeTCPSocket(Socket socket) throws IOException
	{
		socket.close();
	}
	
	@Override
	public void closeUDPSocket(DatagramSocket socket) throws IOException
	{
		socket.close();
	}
	
}
