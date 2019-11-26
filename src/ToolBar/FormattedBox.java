package ToolBar;

import javax.swing.JFormattedTextField;
import javax.swing.text.MaskFormatter;

public class FormattedBox {
	
	private JFormattedTextField formattedBox;
	
	//Creates a box with only number inputs being possible and numberOfDigits possible digits
	public FormattedBox(int numberOfDigits, int columns) {
		String Formatter = "#";
		for(int i = 1; i < numberOfDigits; i++) {
			Formatter += "#";
		}
		formattedBox = new JFormattedTextField(createFormatter(Formatter));
		formattedBox.setColumns(columns);
	}
	
	public JFormattedTextField getBox() {
		return formattedBox;
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
