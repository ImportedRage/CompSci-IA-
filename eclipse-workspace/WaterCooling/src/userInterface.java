import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class userInterface {
	// Window Dimensions
	int width;
	int height;
	
	// Header Properties
	Font headerFont;
	Color headerColor;
	int headerWidth;
	int headerHeight;
	
	// Add Component Button Properties
	int btnWidth; 
	int btnHeight;
	
	// Column Header Properties 
	Color columnHeaderColor; 
	Font columnHeaderFont; 
	int columnHeaderWidth; 
	int columnHeaderHeight; 
	
	//makeRow Cell Properties 
	Color cellColor; 
	Font cellFont; 
	int cellWidth;
	int cellHeight;
	
	//makeNavButton Properties 
	int navBtnWidth = (int) Math.round(0.09836065573770492* width); 
	int navBtnHeight = (int) Math.round(0.15* height);
	
	
	
	
	userInterface(int width, int height) {
		this.width = width;
		this.height = height;
		
		this.headerFont = new Font("Serif", 1, (int) Math.round(0.065*height));
		this.headerColor = Color.BLUE;
		this.headerWidth = -1; // calculated per header
		this.headerHeight = (int) 0.875*height;
		
		this.btnWidth = (int) Math.round(0.14754098360655737* width);
		this.btnHeight = (int) Math.round(0.04375* height);
		
		this.columnHeaderFont = new Font("Serif", 3, (int) Math.round(0.0375 * height));
		this.columnHeaderColor = Color.GREEN; 
		
		this.cellColor = Color.BLUE; 
		this.cellFont = new Font("Serif", 3, (int) Math.round(0.03* height));
		this.cellWidth = (int) Math.round(0.16393442622950818* width); 
		this.cellHeight = (int) Math.round(0.0875* height);
	}
	
	public JLabel makeHeader(String text, double x, double y) {
		
		JLabel header = new JLabel (text); 
		header.setForeground(this.headerColor); 
		header.setFont(this.headerFont); 
		headerWidth = text.length() * 5 * width;
		header.setBounds((int) (x * width), (int) (y * height),
						 headerWidth, headerHeight);
		return header; 
	}
	
	
	public JButton makeAddButton(String text, double x, double y, ActionListener al) { 
		JButton btn = new JButton(text);
		 btn.setBounds((int) (x * width), (int) (y * height),
				 btnWidth, btnHeight);
        btn.addActionListener(al);
        return btn;
	}
	
	
	public JButton makeNavButton(String imgPath, double x, double y, JFrame frame) {
		JButton navButton = new JButton(new ImageIcon (imgPath));
		navButton.setBounds((int) (x * width), (int) (y * height),	 			
				navBtnWidth, navBtnHeight);
		navButton.addActionListener(new ActionListener(){  
	    	public void actionPerformed(ActionEvent e){  
	    		changeFrame(frame);  
	    	}  
	    });  
		return navButton;
	
	}
	
	
	
	
	
	public JLabel[] makeColumnHeadings(String[] text, double x, double y) {
		
		JLabel[] columnHeadings = new JLabel[text.length];
		for(int i = 0; i < text.length; i++) {
			JLabel columnHeader = new JLabel (text[i]);
			columnHeader.setForeground(this.columnHeaderColor);
			columnHeader.setFont(this.columnHeaderFont);
			headerWidth = text[i].length() * 5 * width;
			columnHeader.setBounds ((int) (x * width), (int) (y * height),	 			
					headerWidth, headerHeight); 
			x = x + 0.1;
			columnHeadings[i] = columnHeader;
		}
	 	
	 	
	 	return columnHeadings;
	}
	public Component[] makeRow(String[] text, double x, double y, JButton add) {
		Component[] row = new Component[text.length + 1];
		for(int i = 0; i < row.length; i++) {
			JLabel cell = new JLabel(text[i]); 	
			cell.setForeground(cellColor);
			cell.setFont(cellFont);
			cell.setBounds ((int) (x * width), (int) (y * height),	 			
					cellWidth, cellHeight); 
			x = x + 0.1;
			row[i] = cell;
		} 
		row[row.length - 1] = add;
		
	
		return row; 
	}
 
}
