package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.Socket;

/**
 * A SquareFolder-enabled device.
 * */
public abstract class SFDevice
{
	protected Socket socket;
	protected int 	 port;
	
	public SFDevice(int port) throws IOException
	{	
		this.port = port;
		
		this.initializeTCPSocket(socket);
	}

	public abstract boolean initializeTCPSocket(Socket socket) throws IOException;
	
	public abstract void closeTCPSocket(Socket socket) throws IOException;

}
