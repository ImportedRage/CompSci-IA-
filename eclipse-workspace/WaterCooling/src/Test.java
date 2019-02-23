import java.util.ArrayList;
import javax.swing.*;

public class Test {
	
	public static void printMessages(ArrayList<String> messages) {
		System.out.println(messages.size());
		for(int i = 0; i < messages.size(); i++) {
			System.out.println(messages.get(i));
		}
		
	}

	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("HelloWorldSwing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
	
	
	public static void main(String[] args) {
		CPU cpu1 = new CPU("AMDCPU1","AMD4");
		GPU gpu1 = new GPU("GTX970");
		Case c1 = new Case(444);
		CPUWaterblock block1 = new CPUWaterblock("2011-3", "Copper", "Toby");
		GPUWaterblock gblock1 = new GPUWaterblock("Name1", "Model01", "Metal01");
		Radiator rad1 = new Radiator("RadName","3", "Copper");
		Tubing tub1 = new Tubing("TubeName01", "False, ", "12");
		Reservoir res1 = new Reservoir("ResName01", "Combo:True"); 
		Pump pump1 = new Pump("ThatPumpName", "ThatPumpBrand", "ThatPumpType");
		Fittings fit1 = new Fittings("ThatFittingName", "ThatFittingDiameter:9000");
		Coolant cool1 = new Coolant("Cool1", "Not edible"); 
		
		
		
		WaterCoolerSystem system1 = new WaterCoolerSystem(			cpu1, 
																	gpu1, 
																	c1,
																	block1,
																	gblock1,
																	rad1,
																	tub1,
																	res1,
																	pump1,
																	fit1,
																	cool1);
		system1.check(); 
		ArrayList<String> errors = system1.getErrors();
		ArrayList<String> advice = system1.getAdvice();
		
		printMessages(errors);
		printMessages(advice);
		
		createAndShowGUI();
		
		
		
		
		
	}
	
}
