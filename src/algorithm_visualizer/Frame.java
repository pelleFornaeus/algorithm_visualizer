package algorithm_visualizer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Frame extends JFrame implements ActionListener{
	public Frame() {
		this.setTitle("Algorithm Visualizer");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public JComboBox dropDownMenu() {
		String[] algorithms = {"Bubble Sort", "Merge Sort", "Quick Sort"};
		JComboBox algorithmList = new JComboBox(algorithms);
		algorithmList.setSelectedIndex(0);
		algorithmList.addActionListener(this);
		return algorithmList;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}
