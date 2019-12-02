package Frame;

import javax.swing.*;
import Sorting_Algorithms.ValueList;
import ToolBar.ToolBar;

import java.awt.*;

public class Frame extends JFrame{
	
	private ToolBar toolBar;
	private SortingPanel sortingPanel = new SortingPanel();
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private ValueList valueList = new ValueList(999);
	
	public Frame() {
		toolBar = new ToolBar();
		toolBar.setSortingPanel(sortingPanel);
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 20));
		this.add(sortingPanel.getsortingPanel(), BorderLayout.SOUTH);
		this.add(toolBar.getToolBar(), BorderLayout.NORTH);
		sortingPanel.createInitialArray(valueList);
	}
}
