package algorithm_visualizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame extends JFrame implements ActionListener{
	public Frame() {
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(dropDownMenu(), BorderLayout.CENTER);
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
		
	}
}
