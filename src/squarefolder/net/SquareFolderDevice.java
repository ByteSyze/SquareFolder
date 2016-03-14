package squarefolder.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * 
 * A SquareFolder-enabled device.
 * 
 * */
public class SquareFolderDevice
{
	private InetAddress inetAddress;
	private NetworkInterface networkInterface;
	
	public SquareFolderDevice(InetAddress inetAddress) throws SocketException
	{
		this.inetAddress = inetAddress;
		
		networkInterface = NetworkInterface.getByInetAddress(inetAddress);
	}
	
	public InetAddress getInetAddress()
	{
		return this.inetAddress;
	}
	
	public void setInetAddress(InetAddress inetAddress)
	{
		this.inetAddress = inetAddress;
	}

}
