package squarefolder.io.stream;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * An extension of BufferedInputStream for the purpose of throttling the maximum speed at which data can be read.
 * */
public class ThrottledInputStream extends BufferedInputStream
{
	
	private long baudRate;

	public ThrottledInputStream(InputStream stream)
	{
		super(stream);
	}
	
	public ThrottledInputStream(InputStream stream, long baudRate)
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
	public int read() throws IOException
	{
		return super.read();
	}
	
	@Override
	public int read(byte[] b) throws IOException
	{
		return super.read(b);
	}

}
