package ToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

public class AlgoDropDown {
	
	private JComboBox<String> dropDownMenu;
	private String algorithm;
	
	public AlgoDropDown() {
		String[] algorithms = {"Choose algorithm", "Bubble Sort", "Merge Sort", "Quick Sort"};
		JComboBox<String> algorithmList = new JComboBox<String>(algorithms);
		algorithmList.setSelectedIndex(0);
		algorithmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        algorithm = (String)cb.getSelectedItem();
		        System.out.println(algorithm + " Selected");
			}
		});
	}
	
	public JComboBox<String> getDropDownMenu() {
		return dropDownMenu;
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
}
