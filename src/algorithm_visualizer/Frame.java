package algorithm_visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame{
	
	private ToolBar toolBar;
	
	public Frame() {
		toolBar = new ToolBar();
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(toolBar.getToolBar(), BorderLayout.CENTER);
	}
}
