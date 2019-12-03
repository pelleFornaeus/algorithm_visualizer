package Frame;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import Sorting_Algorithms.ValueList;

public class SortingPanel extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingPanel = new JPanel();
	private JFormattedTextField[] valueArray = new JFormattedTextField[999];
	private int valueArraySize = 999;
	private int comparisons = 0;
	
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
	
	public void worstCase() {
		int currentNumber = valueArraySize;
		for(JFormattedTextField textField: valueArray) {
			textField.setText(Integer.toString(currentNumber));
			currentNumber--;
		}
	}
	
	public void bestCase() {
		int currentNumber = 0;
		for(JFormattedTextField textField: valueArray) {
			textField.setText(Integer.toString(currentNumber));
			currentNumber++;
		}
	}
	
	public void bubbleSort2() { 
		comparisons = 0;
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				int j = 0;
				for (int i = 0; i < valueArraySize-1; i++) {
		            for (j = 0; j < valueArraySize-i-1; j++) {
		            	comparisons++;
		                if (Integer.parseInt(valueArray[j].getText().trim()) > Integer.parseInt(valueArray[j+1].getText().trim())) { 
		                    int temp = Integer.parseInt(valueArray[j].getText());
		                    publish(temp);
		                    valueArray[j].setText(valueArray[j+1].getText());
		                    valueArray[j+1].setText(Integer.toString(temp));
		                    System.out.println("loop step: " +  i + " " + j);
		                } 
		                valueArray[j+1].setBackground(Color.RED);
		                Thread.sleep(10);
		                valueArray[j+1].setBackground(Color.WHITE);
		            }
				}
				return null;
			}
			@Override
            protected void process(List<Integer> chunks) {
            }

            @Override
            protected void done() {
                System.out.println("Done in " + comparisons + " comparisons");
            }
		}; 
		worker.execute();
	}
}