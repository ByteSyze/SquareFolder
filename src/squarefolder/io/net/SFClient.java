package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;

public class SFClient extends SFDevice
{
	private InetAddress serverAddress;
	
	public SFClient(InetAddress myAddress, InetAddress serverAddress, int udpPort, int tcpPort) throws IOException 
	{
		super(myAddress, udpPort, tcpPort);
		
		this.serverAddress = serverAddress;
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException
	{
		socket.connect(new InetSocketAddress(serverAddress, tcpPort));
		return false;
	}

	@Override
	public boolean initializeUDPSocket(DatagramSocket socket) throws IOException 
	{
		return false;
	}
	
}
