package squarefolder.io.stream;

import java.io.BufferedInputStream;
import java.io.InputStream;

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

}
