package squarefolder.dir;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import static java.nio.file.StandardWatchEventKinds.*;

/**
 * Responsible for watching and reporting changes to specified path.
 * */
public class SFDirectoryWatcher extends Thread
{
	
	private Path path;
	
	private WatchService watcher;
	private WatchKey 	 registerKey;
	
	public SFDirectoryWatcher(Path path) throws IOException
	{
		this.path = path;
		this.watcher = FileSystems.getDefault().newWatchService();
		this.registerKey = path.register(watcher, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
	}
	
	public void run()
	{
		WatchKey key;
		
	    try 
	    {
	        key = watcher.take();
	        for (WatchEvent<?> event: key.pollEvents())
		    {
		        WatchEvent.Kind<?> kind = event.kind();

		        if (kind == OVERFLOW)
		        {
		            return;
		        }
		        
		        WatchEvent<Path> ev = (WatchEvent<Path>)event;
		        Path filename = ev.context();

		    }
		    
		    boolean valid = key.reset();
		    
		    if (!valid) 
		    {
		    	//TODO handle invalid watch keys
		        return;
		    }
	    } catch (InterruptedException x) {}
	}
}
