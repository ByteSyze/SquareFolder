package squarefolder.io.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;

import javax.net.SocketFactory;

import squarefolder.main.SquareFolder;

/**
 * <p>Responsible for handling the Multicast scanning done by 
 * SquareFolder for intercommunication between SquareFolder devices.</p>
 * 
 * <p>The main purpose of multicasting in SquareFolder is to "scan" for
 * responsive SquareFolder devices in the Multicast Group by sending out
 * a multicasted message, then waiting for individualized responses.</p>
 * */
public class SFDeviceScanner implements Runnable
{
	
	public static final byte[] MULTICAST_MSG_PING = {0x01};
	
	private SquareFolder squareFolder;
	
	private DatagramSocket socket;
	private InetAddress multicastGroup;
	
	/**Datagram Packet set up for saying "Hey, anybody out there?"*/
	private DatagramPacket pingPacket;
	
	public SFDeviceScanner(SquareFolder sq, String multicastAddress, int port) throws IOException
	{
		squareFolder = sq;
		
		socket = new DatagramSocket(port);
		
		byte[] ourAddress = squareFolder.getOurDevice().getInetAddress().getAddress();
		
		pingPacket = new DatagramPacket(MULTICAST_MSG_PING, 1);
		
	}
	
	public void run()
	{
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        System.out.println("Sending");
		try 
		{
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            System.out.println("RECEIVED: " + sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();
            DatagramPacket sendPacket =
            new DatagramPacket(sendData, sendData.length, IPAddress, port);
            socket.send(sendPacket);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
}
