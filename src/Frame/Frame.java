package Frame;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
	
	private ToolBar toolBar;
	private SortingFrame sortingFrame;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Frame() {
		toolBar = new ToolBar();
		sortingFrame = new SortingFrame();
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 20));
		this.add(sortingFrame.getSortingFrame(), BorderLayout.SOUTH);
		this.add(toolBar.getToolBar(), BorderLayout.NORTH);
	}
}
