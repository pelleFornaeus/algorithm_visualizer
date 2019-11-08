package algorithm_visualizer;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToolBar extends JFrame implements ActionListener, PropertyChangeListener {
	
	private JPanel toolBar = new JPanel();
	private int boxNumber;
	
	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(600, 100));
		toolBar.add(dropDownMenu(), BorderLayout.CENTER);
		toolBar.add(boxAmount(), BorderLayout.WEST);
	}
	
	private JComboBox<String> dropDownMenu() {
		String[] algorithms = {"Choose algorithm", "Bubble Sort", "Merge Sort", "Quick Sort"};
		JComboBox<String> algorithmList = new JComboBox<String>(algorithms);
		algorithmList.setSelectedIndex(0);
		algorithmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        String algorithm = (String)cb.getSelectedItem();
		        System.out.println(algorithm + " Selected");
			}
		});
		return algorithmList;
	}
	
	private JPanel boxAmount() {
		JPanel boxAmount = new JPanel();
		boxAmount.setPreferredSize(new Dimension(100,100));
		
		JFormattedTextField amountField = new JFormattedTextField(createFormatter("##"));
		amountField.setValue(boxNumber);
		amountField.setColumns(3);
		amountField.addPropertyChangeListener("value", this);
		
		JButton addBoxes = new JButton("Make Array");
		addBoxes.setBackground(Color.RED);
		addBoxes.setOpaque(true);
		addBoxes.setBorderPainted(false);
		
		addBoxes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(amountField.getText());
			}
		});
		boxAmount.add(amountField, BorderLayout.NORTH);
		boxAmount.add(addBoxes, BorderLayout.SOUTH);
		return boxAmount;
	}
	
	protected MaskFormatter createFormatter(String s) {
	    MaskFormatter formatter = null;
	    try {
	        formatter = new MaskFormatter(s);
	    } catch (java.text.ParseException exc) {
	        System.out.println("formatter is bad: " + exc.getMessage());
	        System.exit(-1);
	    }
	    return formatter;
	}

	public JPanel getToolBar() {
		return this.toolBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
}