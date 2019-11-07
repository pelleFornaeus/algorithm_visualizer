package algorithm_visualizer;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;

public class ToolBar extends JFrame implements ActionListener {
	
	private JPanel toolBar = new JPanel();
	
	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(600, 100));
		toolBar.add(dropDownMenu(), BorderLayout.CENTER);
	}
	
	public JComboBox<String> dropDownMenu() {
		String[] algorithms = {"Bubble Sort", "Merge Sort", "Quick Sort"};
		JComboBox<String> algorithmList = new JComboBox<String>(algorithms);
		algorithmList.setSelectedIndex(0);
		algorithmList.addActionListener(this);
		return algorithmList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JComboBox cb = (JComboBox)e.getSource();
        String algorithm = (String)cb.getSelectedItem();
        System.out.println(algorithm + " Selected");
	}
	
	public JPanel getToolBar() {
		return this.toolBar;
	}
}