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
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private String currentAlgorithm = "";
	
	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(screenSize.width, 100));
		toolBar.add(runBox(), BorderLayout.EAST);
		toolBar.add(boxAmount(), BorderLayout.WEST);
		toolBar.add(randomizer(), BorderLayout.CENTER);
	}
	
	private JComboBox<String> dropDownMenu() {
		String[] algorithms = {"Choose algorithm", "Bubble Sort", "Merge Sort", "Quick Sort"};
		JComboBox<String> algorithmList = new JComboBox<String>(algorithms);
		algorithmList.setSelectedIndex(0);
		algorithmList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        String algorithm = (String)cb.getSelectedItem();
		        currentAlgorithm = algorithm;
		        System.out.println(algorithm + " Selected");
			}
		});
		return algorithmList;
	}
	
	private JPanel runBox() {
		JPanel runBox = new JPanel();
		runBox.setPreferredSize(new Dimension(200, 100));
		
		JButton runButton = new JButton("Run");
		runButton.setBackground(Color.RED);
		runButton.setOpaque(true);
		runButton.setBorderPainted(false);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(currentAlgorithm + " ran");
			}
		});
		
		runBox.add(dropDownMenu(), BorderLayout.NORTH);
		runBox.add(runButton, BorderLayout.SOUTH);
		
		return runBox;
	}
	
	private JPanel boxAmount() {
		JPanel boxAmount = new JPanel();
		boxAmount.setPreferredSize(new Dimension(100,100));
		
		JFormattedTextField amountField = new JFormattedTextField(createFormatter("##"));
		amountField.setColumns(2);
		amountField.setValue(null);
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
	
	private JPanel randomizer() {
		JPanel randomizerBox = new JPanel();
		randomizerBox.setPreferredSize(new Dimension(200, 100));
		
		JFormattedTextField minValue = new JFormattedTextField(createFormatter("####"));
		minValue.setColumns(3);
		minValue.setValue("0000");
		minValue.addPropertyChangeListener("value", this);
		
		JFormattedTextField maxValue = new JFormattedTextField(createFormatter("####"));
		maxValue.setColumns(3);
		maxValue.setValue("9999");
		maxValue.addPropertyChangeListener("value", this);
		
		JButton randomize = new JButton("Randomize");
		randomize.setBackground(Color.RED);
		randomize.setOpaque(true);
		randomize.setBorderPainted(false);
		randomize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("min: " + minValue.getText() + "\nmax: " + maxValue.getText());
			}
		});
		
		randomizerBox.add(minValue, BorderLayout.WEST);
		randomizerBox.add(maxValue, BorderLayout.EAST);
		randomizerBox.add(randomize, BorderLayout.SOUTH);
		return randomizerBox;
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
	}
}