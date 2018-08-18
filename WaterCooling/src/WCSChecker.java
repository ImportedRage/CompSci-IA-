import java.awt.event.*;
import javax.swing.*;       

public class WCSChecker {

    private static void createAndShowGUI() {
    	
    	ImageIcon icon = new ImageIcon("C:\\Users\\CS\\Desktop\\watercooling v2\\IA Resources\\banner.png");
    
    	JLabel label1 = new JLabel(icon);
    	
    	
    	JButton[] buttons = new JButton[9];
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setLocation(-1250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        label1.setBounds(0, 0, 1212, 108);
        frame.add(label1);
        
        for (int i = 0; i < 9; i++) {
        	int x = i*100 + 50;
	        JButton button = new JButton(new ImageIcon("C:\\Users\\CS\\Desktop\\watercooling v2\\logo.png"));
	        button.setBounds(x,120,90,90);
	        button.addActionListener(new ActionListener(){  
	        	public void actionPerformed(ActionEvent e){  
	        	            button.setText("Welcome to Hell.");  
	        	        }  
	        	    });  
	        frame.add(button);
	        buttons[i] = button;

        }
        
        frame.setSize(1212,700);
        frame.setLayout(null);
        frame.setVisible(true);
        
        buttons[2].setText("cheese button");
        
        
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

}
