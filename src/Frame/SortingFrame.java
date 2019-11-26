package Frame;

import java.awt.*;
import javax.swing.*;

import Sorting_Algorithms.ValueList;

public class SortingFrame extends JFrame implements ArrayCreation {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingFrame = new JPanel();
	
	public SortingFrame() {
		sortingFrame.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 200));
		sortingFrame.setBackground(Color.CYAN);
	}
	
	public JPanel getSortingFrame() {
		return this.sortingFrame;
	}
	
	@Override
	public void createInitialArray(ValueList valueList) {
		sortingFrame.removeAll();
		GridLayout gl = new GridLayout(27,37,2,2);
		sortingFrame.setLayout(gl);
		sortingFrame.setBackground(Color.BLACK);
		for(JFormattedTextField textField : valueList.getValueList()) {
			sortingFrame.add(textField);
		}
	}
	
	public void createNewArray(int n) {
		int currentIndex = 0;
		for(Component textField : sortingFrame.getComponents()) {
			textField.setVisible(false);
			if (textField instanceof JFormattedTextField) { 
				if(currentIndex < n) {
					textField.setBackground(Color.RED);
					textField.setVisible(true);
				}
				currentIndex++;
				if(currentIndex >= n)
					((JFormattedTextField) textField).setText("");
			}
		}
	}
}
