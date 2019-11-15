package Frame;

import java.awt.*;
import javax.swing.*;

public class SortingFrame extends JFrame {
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	private JPanel sortingFrame = new JPanel();
	
	public SortingFrame() {
		sortingFrame.setPreferredSize(new Dimension(screenSize.width - 20, screenSize.height - 200));
		sortingFrame.setBackground(Color.CYAN);
	}
	
	public JPanel getSortingFrame() {
		return this.sortingFrame;
	}
}
