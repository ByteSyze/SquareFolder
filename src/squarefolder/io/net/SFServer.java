package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SFServer extends SFDevice
{
	
	private ServerSocket serverSocket;

	public SFServer(int udpPort, int tcpPort) throws IOException 
	{
		super(udpPort, tcpPort);
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException 
	{
		serverSocket = new ServerSocket(tcpPort);
		socket = serverSocket.accept();
		
		return false;
	}

	@Override
	public boolean initializeUDPSocket(DatagramSocket socket) throws IOException 
	{
		udpSocket = new DatagramSocket(udpPort);
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
