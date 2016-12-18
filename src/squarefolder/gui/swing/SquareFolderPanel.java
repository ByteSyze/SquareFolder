package squarefolder.gui.swing;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * The main graphical user interface for SquareFolder.
 * */
public class SquareFolderPanel extends JPanel
{
	private static final long serialVersionUID = -4315991884342900446L;
	
	public SquareFolderPanel()
	{
		super();
		
		this.setPreferredSize(new Dimension(640,480));
	}
}
