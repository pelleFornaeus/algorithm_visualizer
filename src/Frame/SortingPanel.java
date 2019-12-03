package Frame;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import Sorting_Algorithms.ValueList;

public class SortingPanel extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingPanel = new JPanel();
	private static JFormattedTextField[] valueArray = new JFormattedTextField[999];
	private static int valueArraySize = 999;
	private static int comparisons = 0;
	int sortedElements;
	boolean swapped;
	
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
					textField.setBackground(Color.WHITE);
			}
		}
	}
	
	public void worstCase() {
		int currentNumber = valueArraySize;
		for(JFormattedTextField textField: valueArray) {
			textField.setText(Integer.toString(currentNumber));
			textField.setBackground(Color.WHITE);
			currentNumber--;
		}
	}
	
	public void bestCase() {
		int currentNumber = 1;
		for(JFormattedTextField textField: valueArray) {
			textField.setText(Integer.toString(currentNumber));
			textField.setBackground(Color.WHITE);
			currentNumber++;
		}
	}
	
	public void bubbleSort2() { 
		sortedElements = valueArraySize - 1;
		comparisons = 0;
		SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
				int j = 0;
				for (int i = 0; i < valueArraySize-1; i++) {
					swapped = false;
		            for (j = 0; j < valueArraySize-i-1; j++) {
		            	comparisons++;
		                if (Integer.parseInt(valueArray[j].getText().trim()) > Integer.parseInt(valueArray[j+1].getText().trim())) { 
		                    int temp = Integer.parseInt(valueArray[j].getText().trim());
		                    publish(temp);
		                    valueArray[j].setText(valueArray[j+1].getText().trim());
		                    valueArray[j+1].setText(Integer.toString(temp));
		                    System.out.println("loop step: " +  i + " " + j);
		                    swapped = true;
		                } 
		                valueArray[j+1].setBackground(Color.RED);
		                Thread.sleep(10);
		                valueArray[j+1].setBackground(Color.WHITE);
		            }
		            if(!swapped)
		            	break;
		            valueArray[sortedElements].setBackground(Color.GREEN);
		            sortedElements--;
				}
				for(int i = 0; i < valueArraySize; i++) {
					valueArray[i].setBackground(Color.GREEN);
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
    public static void mergeSort() 
    { 
    	comparisons = 0;
    	SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {
			@Override
			protected Void doInBackground() throws Exception {
		        int currentSize;  
		        int leftStart; 
		        for (currentSize = 1; currentSize <= valueArraySize-1;  
		                      currentSize = 2*currentSize) 
		        { 
		            for (leftStart = 0; leftStart < valueArraySize-1; leftStart += 2*currentSize) 
		            { 
		                int mid = Math.min(leftStart + currentSize - 1, valueArraySize-1); 
		                int rightEnd = Math.min(leftStart + 2*currentSize - 1, valueArraySize-1); 
		                for(int i = leftStart; i < mid; i++) {
		                	valueArray[i].setBackground(Color.YELLOW);
		                }
		                for(int i = mid; i < rightEnd; i++) {
		                	valueArray[i].setBackground(Color.BLUE);
		                }
		                merge(leftStart, mid, rightEnd); 
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
                for(int i = 0; i < valueArraySize; i++) {
                	valueArray[i].setBackground(Color.GREEN);
                }
            }
		}; 
		worker.execute();
    } 
      
    static void merge(int l, int m, int r) throws InterruptedException 
    { 
        int i, j, k; 
        int n1 = m - l + 1; 
        int n2 = r - m; 
      
        /* create temp arrays */
        int L[] = new int[n1]; 
        int R[] = new int[n2]; 
      
        /* Copy data to temp arrays L[] 
        and R[] */
        for (i = 0; i < n1; i++) 
            L[i] = Integer.parseInt(valueArray[l + i].getText().trim()); 
        for (j = 0; j < n2; j++) 
            R[j] = Integer.parseInt(valueArray[m + 1+ j].getText().trim()); 
      
        /* Merge the temp arrays back into 
        arr[l..r]*/
        i = 0; 
        j = 0; 
        k = l; 
        while (i < n1 && j < n2) 
        { 
        	comparisons++;
        	valueArray[k].setBackground(Color.RED);
            if (L[i] <= R[j]) 
            { 
                valueArray[k].setText(Integer.toString(L[i])); 
                i++; 
            } 
            else
            { 
            	valueArray[k].setText(Integer.toString(R[j])); 
                j++; 
            } 
            Thread.sleep(10);
            valueArray[k].setBackground(Color.WHITE);
            k++; 
        } 
      
        /* Copy the remaining elements of  
        L[], if there are any */
        while (i < n1) 
        { 
        	valueArray[k].setBackground(Color.RED);
        	valueArray[k].setText(Integer.toString(L[i])); 
        	Thread.sleep(10);
        	valueArray[k].setBackground(Color.WHITE);
            i++; 
            k++; 
        } 
      
        /* Copy the remaining elements of 
        R[], if there are any */
        while (j < n2) 
        { 
        	valueArray[k].setBackground(Color.RED);
        	valueArray[k].setText(Integer.toString(R[j]));
        	Thread.sleep(10);
        	valueArray[k].setBackground(Color.WHITE);
            j++; 
            k++; 
        } 
    } 
}