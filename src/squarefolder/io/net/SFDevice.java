package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 * A SquareFolder-enabled device.
 * */
public abstract class SFDevice
{
	
	protected DatagramSocket	udpSocket;
	protected Socket			tcpSocket;

	
	protected int udpPort, tcpPort;
	
	public SFDevice(int udpPort, int tcpPort) throws IOException
	{	
		this.udpPort = udpPort;
		this.tcpPort = tcpPort;
		
		this.initializeUDPSocket(udpSocket);
		this.initializeTCPSocket(tcpSocket);
	}
	
	/**
	 * Closes all sockets associated with this device. Ignores any thrown IOExceptions.
	 * */
	public void closeSockets()
	{
		try 
		{
			closeUDPSocket(udpSocket);
			closeTCPSocket(tcpSocket);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public abstract boolean initializeUDPSocket(DatagramSocket socket) throws IOException;
	public abstract boolean initializeTCPSocket(Socket socket) throws IOException;
	
	public abstract void closeUDPSocket(DatagramSocket socket) throws IOException;
	public abstract void closeTCPSocket(Socket socket) throws IOException;

}
