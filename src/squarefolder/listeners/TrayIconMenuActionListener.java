package squarefolder.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import squarefolder.gui.swing.SquareFolderFrame;
import squarefolder.main.SquareFolder;

/**
 * Listener for all action events related to a SquareFolder's TrayIcon.
 * */
public final class TrayIconMenuActionListener implements ActionListener
{
	
	/**The instance of SquareFolder that this listener is attached to.*/
	private SquareFolderFrame sfFrame;
	
	public TrayIconMenuActionListener(SquareFolderFrame sff)
	{
		sfFrame = sff;
	}
	
	/**Handles adding this listener to the menu items.*/
	public void addListenerToMenuItems()
	{
		sfFrame.exit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == sfFrame.exit)
		{
			System.out.println("Stopping SquareFolder");
			sfFrame.dispose();
			System.exit(0);
		}
	}
	
}
