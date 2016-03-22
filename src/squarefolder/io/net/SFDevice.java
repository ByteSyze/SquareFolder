package squarefolder.io.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;

/**
 * A SquareFolder-enabled device.
 * */
public class SFDevice
{
	private InetAddress inetAddress;
	private NetworkInterface networkInterface;
	
	public SFDevice(InetAddress inetAddress) throws SocketException
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
