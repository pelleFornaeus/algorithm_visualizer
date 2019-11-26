package Sorting_Algorithms;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class ValueList {
	
	JFormattedTextField[] valueList;
	
	public ValueList(int numberOfValues) {
		updateValueList(numberOfValues);
	}
	
	public void updateValueList(int numberOfValues) {
		valueList = new JFormattedTextField[numberOfValues];
		for (int i = 0; i < numberOfValues; i++) {
			valueList[i] = new JFormattedTextField(createFormatter("###"));
			valueList[i].setColumns(3);
		}
	}
	
	public JFormattedTextField[] getValueList() {
		return valueList;
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
}