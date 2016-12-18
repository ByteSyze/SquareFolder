package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SFServer extends SFDevice
{

	public SFServer(InetAddress myAddress, int udpPort, int tcpPort) throws IOException 
	{
		super(myAddress, udpPort, tcpPort);
	}

	@Override
	public boolean initializeTCPSocket(Socket socket) throws IOException 
	{
		socket = new Socket();
		socket.bind(new InetSocketAddress(socket.getInetAddress(), tcpPort));
		return false;
	}

	@Override
	public boolean initializeUDPSocket(DatagramSocket socket) throws IOException 
	{
		udpSocket = new DatagramSocket(udpPort);
		return false;
	}

}
