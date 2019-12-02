package Frame;

import java.awt.*;
import javax.swing.*;

import Sorting_Algorithms.ValueList;

public class SortingFrame extends JFrame implements ArrayCreation {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingFrame = new JPanel();
	private JFormattedTextField[] valueArray = new JFormattedTextField[999];
	private int valueArraySize = 999;
	
	public SortingFrame() {
		sortingFrame.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 200));
		sortingFrame.setBackground(Color.CYAN);
	}
	
	public JPanel getSortingFrame() {
		return this.sortingFrame;
	}
	
	@Override
	public void createInitialArray(ValueList valueList) {
		valueArray = valueList.getValueList();
		sortingFrame.removeAll();
		GridLayout gl = new GridLayout(27,37,2,2);
		sortingFrame.setLayout(gl);
		for(JFormattedTextField textField : valueArray) {
			sortingFrame.add(textField);
		}
	}
	
	public void createNewArray(int n) {
		valueArraySize = n;
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
		//for(Component textField : sortingFrame.getComponents()) {
		for(JFormattedTextField textField: valueArray) {
			int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
			valueArray[7].setBackground(Color.YELLOW);
			if (textField instanceof JFormattedTextField) { 
					((JFormattedTextField) textField).setText(Integer.toString(randomNumber));
			}
		}
	}
	
	public void bubbleSort() {
		JFormattedTextField previous = new JFormattedTextField();
		previous.setText("0");
		previous.setBackground(Color.YELLOW);
		JFormattedTextField[] array = (JFormattedTextField[])sortingFrame.getComponents();
		for(Component textField : sortingFrame.getComponents()) {
			if (textField instanceof JFormattedTextField) { 
				for(Component secondTextField : sortingFrame.getComponents()) {
					if (Integer.parseInt(previous.getText()) > Integer.parseInt(((JFormattedTextField) secondTextField).getText())) 
			        { 
						String temp = previous.getText(); 
						String currentText = (((JFormattedTextField) secondTextField).getText());
			            previous.setText(currentText); 
			            ((JFormattedTextField)secondTextField).setText(temp);
			        } 
					previous = (JFormattedTextField)secondTextField;
				}
			}
		}
	}
	public void bubbleSort2() 
    { 
        for (int i = 0; i < valueArraySize-1; i++) 
            for (int j = 0; j < valueArraySize-i-1; j++) 
                if (Integer.parseInt(valueArray[j].getText()) > Integer.parseInt(valueArray[j+1].getText())) 
                { 
                    // swap arr[j+1] and arr[i] 
                    String temp = valueArray[j].getText(); 
                    valueArray[j].setText(valueArray[j+1].getText());
                    valueArray[j+1].setText(temp);
                } 
    }
}