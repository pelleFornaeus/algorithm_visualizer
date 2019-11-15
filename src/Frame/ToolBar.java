package Frame;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ToolBar extends JFrame implements ActionListener, PropertyChangeListener {
	
	private JPanel toolBar = new JPanel();
	private int min = 0;
	private int max = 9999;
	private int boxNumber = 0;
	private String algorithm = "";
	private JButton randomize;
	private JButton addBoxes;
	private JFormattedTextField maxValue;
	private JFormattedTextField minValue;
	
	public ToolBar() {
		toolBar.setPreferredSize(new Dimension(800, 100));
		toolBar.add(boxAmount(), BorderLayout.WEST);
		toolBar.add(randomizer(), BorderLayout.CENTER);
		toolBar.add(runButtonDropDownBox(), BorderLayout.EAST);
	}
	
	private JPanel runButtonDropDownBox() {
		JPanel runButtonDropDownBox = new JPanel();
		runButtonDropDownBox.add(dropDownMenu(), BorderLayout.NORTH);
		runButtonDropDownBox.add(runButton(), BorderLayout.SOUTH);
		return runButtonDropDownBox;
	}
	
	private JComboBox<String> dropDownMenu() {
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
		return algorithmList;
	}
	
	//Creates the button to run the program. Should be red until it can actually be clicked.
	private JButton runButton() {
		JButton runButton = new JButton("Run");
		runButton.setBackground(Color.RED); //Red as default
		runButton.setOpaque(true); //Must see through it to see background color
		runButton.setBorderPainted(false);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(algorithm + " ran");
			}
		});		
		return runButton;
	}
	
	private JPanel boxAmount() {
		JPanel boxAmount = new JPanel();
		boxAmount.setPreferredSize(new Dimension(100,100));
		
		JFormattedTextField amountField = new JFormattedTextField(createFormatter("##"));
		amountField.setColumns(2);
		amountField.setValue(null);
		amountField.addPropertyChangeListener("value", this);
		amountField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boxNumber = Integer.parseInt(amountField.getText());
				if (boxNumber > 0)
					addBoxes.setBackground(Color.GREEN);
				else
					addBoxes.setBackground(Color.RED);
			}
		});
		
		addBoxes = new JButton("Make Array");
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
		
		minValue = new JFormattedTextField(createFormatter("####"));
		minValue.setColumns(3);
		minValue.setValue("0000");
		minValue.addPropertyChangeListener("value", this);
		minValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				min = Integer.parseInt(minValue.getText());
				max = Integer.parseInt(maxValue.getText());
				if(min < max)
					randomize.setBackground(Color.GREEN);
				else 
					randomize.setBackground(Color.RED);
			}
		});
		
		maxValue = new JFormattedTextField(createFormatter("####"));
		maxValue.setColumns(3);
		maxValue.setValue("9999");
		maxValue.setBackground(Color.YELLOW);
		maxValue.addPropertyChangeListener("value", this);
		maxValue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				min = Integer.parseInt(minValue.getText());
				max = Integer.parseInt(maxValue.getText());
				if(min < max)
					randomize.setBackground(Color.GREEN);
				else 
					randomize.setBackground(Color.RED);
			}
		});
		
		//Randomize button should be red until it can be clicked.
		randomize = new JButton("Randomize");
		randomize.setBackground(Color.GREEN);
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
	
	public int getMin() {
		return this.min;
	}
	
	public int getMax() {
		return this.max;
	}
	
	public int getBoxNumber() {
		return this.boxNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {}
}