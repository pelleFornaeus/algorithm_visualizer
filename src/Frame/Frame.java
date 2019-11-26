package Frame;

import javax.swing.*;
import Sorting_Algorithms.ValueList;
import ToolBar.ToolBar;

import java.awt.*;

public class Frame extends JFrame{
	
	private ToolBar toolBar;
	private SortingFrame sortingFrame = new SortingFrame();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ValueList valueList = new ValueList(999);
	
	public Frame() {
		toolBar = new ToolBar();
		toolBar.setSortingFrame(sortingFrame);
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 20));
		this.add(sortingFrame.getSortingFrame(), BorderLayout.SOUTH);
		this.add(toolBar.getToolBar(), BorderLayout.NORTH);
		sortingFrame.createInitialArray(valueList);
	}
}
