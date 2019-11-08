package algorithm_visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{
	
	private ToolBar toolBar;
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Frame() {
		toolBar = new ToolBar();
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 20));
		this.add(toolBar.getToolBar(), BorderLayout.NORTH);
	}
}
