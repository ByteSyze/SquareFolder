package squarefolder.io.stream;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

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

}
