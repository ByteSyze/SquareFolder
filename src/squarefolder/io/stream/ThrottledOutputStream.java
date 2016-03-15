package squarefolder.io.stream;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * An extension of BufferedOutputStream for the purpose of throttling the maximum speed at which data can be written.
 * */
public class ThrottledOutputStream extends BufferedOutputStream
{
	
	private long baudRate;

	public ThrottledOutputStream(OutputStream stream)
	{
		super(stream);
	}
	
	public ThrottledOutputStream(OutputStream stream, long baudRate)
	{
		super(stream);
		
		this.baudRate = baudRate;
	}
	
	public long getBaudRate()
	{
		return this.baudRate;
	}
	
	public void setBaudRate(long baudRate)
	{
		this.baudRate = baudRate;
	}
	
	@Override
	public void write(byte[] b) throws IOException
	{
		super.write(b);
	}

}
