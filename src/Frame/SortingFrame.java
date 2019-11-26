package Frame;

import java.awt.*;
import java.util.Random;
import javax.swing.*;

import Sorting_Algorithms.ValueList;

public class SortingFrame extends JFrame implements ArrayCreation {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingFrame = new JPanel();
	private Random random = new Random();
	
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
					textField.setVisible(true);
				}
				if(currentIndex >= n)
					((JFormattedTextField) textField).setText("");
				currentIndex++;
			}
		}
	}
	
	public void randomizeElements(int min, int max) {
		int currentIndex = 0;
		for(Component textField : sortingFrame.getComponents()) {
			int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
			if (textField instanceof JFormattedTextField) { 
					((JFormattedTextField) textField).setText(Integer.toString(randomNumber));
			}
		}
	}
}
