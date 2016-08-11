package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.Socket;

/**
 * A SquareFolder-enabled device.
 * */
public abstract class SFDevice
{
	private InetAddress 		inetAddress;
	private NetworkInterface 	networkInterface;
	
	protected DatagramSocket	udpSocket;
	protected Socket			tcpSocket;

	
	protected int udpPort, tcpPort;
	
	public SFDevice(InetAddress inetAddress, int udpPort, int tcpPort) throws IOException
	{
		this.inetAddress = inetAddress;
		this.networkInterface = NetworkInterface.getByInetAddress(inetAddress);
		
		this.initializeUDPSocket(udpSocket);
		this.initializeTCPSocket(tcpSocket);
	}
	
	public InetAddress getInetAddress()
	{
		return this.inetAddress;
	}
	
	public void setInetAddress(InetAddress inetAddress)
	{
		this.inetAddress = inetAddress;
	}

	public abstract boolean initializeUDPSocket(DatagramSocket socket) throws IOException;
	public abstract boolean initializeTCPSocket(Socket socket) throws IOException;

}
