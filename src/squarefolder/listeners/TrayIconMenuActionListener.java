package squarefolder.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import squarefolder.main.SquareFolder;

/**
 * Listener for all action events related to a SquareFolder's TrayIcon.
 * */
public final class TrayIconMenuActionListener implements ActionListener
{
	
	/**The instance of SquareFolder that this listener is attached to.*/
	private SquareFolder squareFolder;
	
	public TrayIconMenuActionListener(SquareFolder sq)
	{
		squareFolder = sq;
	}
	
	/**Handles adding this listener to the menu items.*/
	public void addListenerToMenuItems()
	{
		squareFolder.exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == squareFolder.exit)
		{
			System.out.println("Stopping SquareFolder");
			squareFolder.dispose();
			System.exit(0);
		}
	}
	
}
