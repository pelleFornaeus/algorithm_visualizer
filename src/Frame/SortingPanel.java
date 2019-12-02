package Frame;

import java.awt.*;

import javax.swing.*;

import Sorting_Algorithms.ValueList;

public class SortingPanel extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingPanel = new JPanel();
	private JFormattedTextField[] valueArray = new JFormattedTextField[999];
	private int valueArraySize = 999;
	
	public SortingPanel() {
		sortingPanel.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 200));
		sortingPanel.setBackground(Color.CYAN);
	}
	
	public JPanel getsortingPanel() {
		return this.sortingPanel;
	}
	
	public void createInitialArray(ValueList valueList) {
		valueArray = valueList.getValueList();
		sortingPanel.removeAll();
		GridLayout gl = new GridLayout(27,37,2,2);
		//FlowLayout gl = new FlowLayout(); //Testing to see if flowLayout increases speed. It does not.
		sortingPanel.setLayout(gl);
		for(JFormattedTextField textField : valueArray) {
			sortingPanel.add(textField);
		}
	}
	
	public void createNewArray(int n) {
		valueArraySize = n;
		int currentIndex = 0;
		for(Component textField : sortingPanel.getComponents()) {
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
		//for(Component textField : sortingPanel.getComponents()) {
		for(JFormattedTextField textField: valueArray) {
			int randomNumber = (int)(Math.random() * (max - min + 1)) + min;
			if (textField instanceof JFormattedTextField) { 
					((JFormattedTextField) textField).setText(Integer.toString(randomNumber));
			}
		}
	}
	public void bubbleSort2() 
    { 
        for (int i = 0; i < valueArraySize-1; i++) 
            for (int j = 0; j < valueArraySize-i-1; j++) 
                if (Integer.parseInt(valueArray[j].getText().trim()) > Integer.parseInt(valueArray[j+1].getText().trim())) 
                { 
                    String temp = valueArray[j].getText(); 
                    valueArray[j].setText(valueArray[j+1].getText());
                    valueArray[j+1].setText(temp);
                    repaint(20);
                    System.out.println("loop step: " +  i + " " + j);
                } 
    }
}