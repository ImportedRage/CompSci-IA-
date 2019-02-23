import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Base {
	
	private static String resourcePath = "/home/madacoo/Desktop/robert_choy/CompSci-IA-/resources/";
	//Sentinel/Flag: Reload the WCS mainscreen for UI dependent on user changes 
	boolean wcsChanged = true; 
	
	// Style
    Font fheader; 
    Font sheader; 
    Font bodytext; 
    Font buttontext;
    
    int width;
    int height;
	
    static JFrame createFrame;
	static JFrame baseFrame;
	static JFrame systemFrame;
	static JFrame cpuFrame;
	static JFrame gpuFrame;
	static JFrame radFrame;
	static JFrame tubFrame;
	static JFrame resFrame;
	static JFrame pumpFrame;
	static JFrame fitFrame;
	static JFrame coolFrame;
	static JFrame dummyFrame;
	static JFrame searchFrame;

	
	static JFrame currentFrame;
	int x;
	int y;
	
	WaterCoolerSystem wcs;
	Database db;

	
	
	public Base(int width, int height) {
		this.width = width;
		this.height = height;
		
		fheader = new Font("Serif", 1, (int) Math.round(0.065*height));
	    sheader = new Font("Serif", 3, (int) Math.round(0.0375 * height));
	    bodytext = new Font("Serif", 3, (int) Math.round(0.03* height));
	    buttontext = new Font("Serif", 1, (int) Math.round(0.1375 * height));
		
		
		
		x = 200;
		y = 200;
		
		wcs = new WaterCoolerSystem();
		//wcs.setCpu();
		//wcs.setGpu();
	
		
		//We need an option to gain user input regarding CPU/GPU Model, preferably a dropdown menu/option. 
		
		
		
		
		db = new Database();	
		
		baseFrame = createBaseFrame();
		dummyFrame = createDummyFrame();
		currentFrame = baseFrame;
		systemFrame = createSystemFrame();
		cpuFrame = createCpuFrame(); 
		gpuFrame = createGpuFrame(); 
		radFrame = createRadFrame(); 
		tubFrame = createTubFrame(); 
		resFrame = createresFrame(); 
		pumpFrame = createPumpFrame(); 
		fitFrame = createFitFrame(); 
		coolFrame = createCoolFrame(); 
		searchFrame = createSearchedFrame("");
		
	}
	
	public JFrame createBaseFrame() {

		JFrame frame = new JFrame("WCS");
		
        frame.setSize(WCSChecker.WIDTH,WCSChecker.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		Component[] mainComponents = createMainComponents();
		Component[] firstViewComponents = createFirstViewComponents();
		
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
    	for (int i = 0; i < firstViewComponents.length; i++) {
    		frame.add(firstViewComponents[i]);
    	}
		
    	return frame;
		
	}
	
    public Component[] createWaterblockRow(CPUWaterblock wb, int y) {
    	Component[] comps = new Component[7];
    	
    	JLabel cpuWaterBlockTitleName = new JLabel ("CPU Waterblock Name:");
    	cpuWaterBlockTitleName.setForeground(Color.GREEN);
    	cpuWaterBlockTitleName.setFont(sheader);
    	
    	
    	cpuWaterBlockTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height));
    	
    	comps[3] = cpuWaterBlockTitleName;
    	
     	JLabel cpuWaterBlockSocketName = new JLabel ("Socket Type:");
     	cpuWaterBlockSocketName.setForeground(Color.GREEN);
     	cpuWaterBlockSocketName.setFont(sheader);
     	cpuWaterBlockSocketName.setBounds (
(int) Math.round(0.32786885245901637* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height));
     	comps[4] = cpuWaterBlockSocketName;
    	
     	JLabel cpuWaterBlockMetalName = new JLabel ("Metal Type:");
     	cpuWaterBlockMetalName.setForeground(Color.GREEN);
     	cpuWaterBlockMetalName.setFont(sheader);
     	cpuWaterBlockMetalName.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
    	comps[5] = cpuWaterBlockMetalName;
    	
    	
    	JLabel cpuWaterblockName = new JLabel (wb.getName());    	
    	cpuWaterblockName.setForeground(Color.BLUE);
    	cpuWaterblockName.setFont(bodytext);
    	cpuWaterblockName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height));
        comps[0] = cpuWaterblockName;
    	
     	
    	JLabel cpuWaterblockSocket = new JLabel (wb.getSocket());    	
    	cpuWaterblockSocket.setForeground(Color.GREEN);
    	cpuWaterblockSocket.setFont(bodytext);
    	cpuWaterblockSocket.setBounds (
(int) Math.round(0.32786885245901637* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  

);
        comps[1] = cpuWaterblockSocket;
        
     	
    	JLabel cpuWaterblockMetal = new JLabel (wb.getMetal());    	
    	cpuWaterblockMetal.setForeground(Color.RED);
    	cpuWaterblockMetal.setFont(bodytext);
    	cpuWaterblockMetal.setBounds (
(int) Math.round(0.4918032786885246* width), 
y, 
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.0875* height) 
 );
        comps[2] = cpuWaterblockMetal;
        
        JButton addCPU = new JButton("Add CPU Waterblock");
        addCPU.setBounds(
        		
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) 
);
        comps[6] = addCPU;
        addCPU.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        				wcs.setCWB(wb);
            			wcsChanged = true; 
        	        } 
        	}
        );
        
        
        
    	return comps;
	  
    }
	
    public Component[] createGPUWaterblockRow(GPUWaterblock gwb, int y) {
    	Component[] comps = new Component[7];
    	
    	JLabel gpuWaterBlockTitleName = new JLabel ("GPU Waterblock Name:");
    	gpuWaterBlockTitleName.setForeground(Color.GREEN);
    	gpuWaterBlockTitleName.setFont(sheader);
    	gpuWaterBlockTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) );
    	comps[3] = gpuWaterBlockTitleName;
    	
     	JLabel gpuWaterBlockModelType = new JLabel ("Model Type:");
     	gpuWaterBlockModelType.setForeground(Color.GREEN);
     	gpuWaterBlockModelType.setFont(sheader);
     	gpuWaterBlockModelType.setBounds (
(int) Math.round(0.32786885245901637* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  );
     	comps[4] = gpuWaterBlockModelType;
    	
     	JLabel gpuWaterBlockMetalName = new JLabel ("Metal Type:");
     	gpuWaterBlockMetalName.setForeground(Color.GREEN);
     	gpuWaterBlockMetalName.setFont(sheader);
     	gpuWaterBlockMetalName.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
    	comps[5] = gpuWaterBlockMetalName;
    	
    	
    	JLabel gpuWaterblockName = new JLabel (gwb.getName());    	
    	gpuWaterblockName.setForeground(Color.BLUE);
    	gpuWaterblockName.setFont(bodytext);
    	gpuWaterblockName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  
);
        comps[0] = gpuWaterblockName;
    	
     	
    	JLabel gpuWaterblockSocket = new JLabel (gwb.getModel());    	
    	gpuWaterblockSocket.setForeground(Color.GREEN);
    	gpuWaterblockSocket.setFont(bodytext);
    	gpuWaterblockSocket.setBounds (
(int) Math.round(0.32786885245901637* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  );
        comps[1] = gpuWaterblockSocket;
        
     	
    	JLabel gpuWaterblockMetal = new JLabel (gwb.getMetal());    	
    	gpuWaterblockMetal.setForeground(Color.RED);
    	gpuWaterblockMetal.setFont(bodytext);
    	gpuWaterblockMetal.setBounds (
(int) Math.round(0.4918032786885246* width), 
y, 
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.0875* height) 
);
        comps[2] = gpuWaterblockMetal;
        
        JButton addGPU = new JButton("Add GPU Waterblock");
        addGPU.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) 
);
        comps[6] = addGPU;
        addGPU.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		wcs.setGWB(gwb);
    			wcsChanged = true; 

        	        } 
        	}
        );
        
    	
    	return comps;
	  
    }
    public Component[] createRadiatorRow(Radiator rad, int y) {
    	Component[] comps = new Component[7];
    	
    	JLabel RadiatorTitleName = new JLabel ("Radiator Name:");
    	RadiatorTitleName.setForeground(Color.GREEN);
    	RadiatorTitleName.setFont(sheader);
    	RadiatorTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) );
    	comps[3] = RadiatorTitleName;
    	
     	JLabel RadiatorFanCountNumber = new JLabel ("Maximum Number of Fans:");
     	RadiatorFanCountNumber.setForeground(Color.GREEN);
     	RadiatorFanCountNumber.setFont(sheader);
     	RadiatorFanCountNumber.setBounds (
     			
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height) );
     	comps[4] = RadiatorFanCountNumber;
    	
     	JLabel RadiatorMetalName = new JLabel ("Metal Type:");
     	RadiatorMetalName.setForeground(Color.GREEN);
     	RadiatorMetalName.setFont(sheader);
     	RadiatorMetalName.setBounds (
     			
(int) Math.round(0.5737704918032787* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
    	comps[5] = RadiatorMetalName;
    	
    	
    	JLabel RadiatorName = new JLabel (rad.getName());    	
    	RadiatorName.setForeground(Color.BLUE);
    	RadiatorName.setFont(bodytext);
    	RadiatorName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) );
        comps[0] = RadiatorName;
    	
     	
    	JLabel RadiatorFanCount = new JLabel (rad.getMaxFanCount());    	
    	RadiatorFanCount.setForeground(Color.GREEN);
    	RadiatorFanCount.setFont(bodytext);
    	RadiatorFanCount.setBounds (
(int) Math.round(0.32786885245901637* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
        comps[1] = RadiatorFanCount;
        
     	
    	JLabel RadiatorMetal = new JLabel (rad.getMetal());    	
    	RadiatorMetal.setForeground(Color.RED);
    	RadiatorMetal.setFont(bodytext);
    	RadiatorMetal.setBounds (
(int) Math.round(0.5737704918032787* width), 
y, 
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.0875* height)  );
        comps[2] = RadiatorMetal;
        
        JButton addRad = new JButton("Add Radiators");
        addRad.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) );
        comps[6] = addRad;
        addRad.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setRad(rad);
        			wcsChanged = true; 

        	        } 
        	}
        );    	
    	return comps;
	  
    }
    public Component[] createTubingRow(Tubing tub, int y) {
    	Component[] comps = new Component[7];
    	
    	JLabel TubingTitleName = new JLabel ("Tubing Name:");
    	TubingTitleName.setForeground(Color.GREEN);
    	TubingTitleName.setFont(sheader);
    	TubingTitleName.setBounds (
    			
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) 

);
    	comps[3] = TubingTitleName;
    	
     	JLabel TubingBendability = new JLabel ("Tubing Bendabiliy?:");
     	TubingBendability.setForeground(Color.GREEN);
     	TubingBendability.setFont(sheader);
     	TubingBendability.setBounds (
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height) );
     	comps[4] = TubingBendability;
    	
     	JLabel TubingDiameter = new JLabel ("Tubing Diameter:");
     	TubingDiameter.setForeground(Color.GREEN);
     	TubingDiameter.setFont(sheader);
     	TubingDiameter.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.2459016393442623* width), 
(int) Math.round(0.0875* height) 
 );
    	comps[5] = TubingDiameter;
    	
    	
    	JLabel TubingName = new JLabel (tub.getName());    	
    	TubingName.setForeground(Color.BLUE);
    	TubingName.setFont(bodytext);
    	TubingName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) );
        comps[0] = TubingName;
    	
     	
    	JLabel TubingBendable = new JLabel (tub.getBendable());    	
    	TubingBendable.setForeground(Color.GREEN);
    	TubingBendable.setFont(bodytext);
    	TubingBendable.setBounds (
(int) Math.round(0.20491803278688525* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
        comps[1] = TubingBendable;
        
     	
    	JLabel TubingDiameterSize = new JLabel (tub.getDiameter());    	
    	TubingDiameterSize.setForeground(Color.RED);
    	TubingDiameterSize.setFont(bodytext);
    	TubingDiameterSize.setBounds (
(int) Math.round(0.4918032786885246* width), 
y, 
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.0875* height)  );
        comps[2] = TubingDiameterSize;
        
        JButton addTub = new JButton("Add Tubing");
        addTub.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) 
 );
        comps[6] = addTub;
        addTub.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setTub(tub);
        			wcsChanged = true; 

        	        } 
        	}
        );    	    	
    	return comps;
    }
    public Component[] createReservoirRow(Reservoir res, int y) {
    	Component[] comps = new Component[5];
    	
    	JLabel ReservoirTitleName = new JLabel ("Reservoir Name:");
    	ReservoirTitleName.setForeground(Color.GREEN);
    	ReservoirTitleName.setFont(sheader);
    	ReservoirTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) 
 );
    	comps[0] = ReservoirTitleName;
    	
     	JLabel ReservoirCombo = new JLabel ("Reservoir Combo?:");
     	ReservoirCombo.setForeground(Color.GREEN);
     	ReservoirCombo.setFont(sheader);
     	ReservoirCombo.setBounds (
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height) 
);
     	comps[1] = ReservoirCombo;
    	
    	JLabel ReservoirName = new JLabel (res.getName());    	
    	ReservoirName.setForeground(Color.BLUE);
    	ReservoirName.setFont(bodytext);
    	ReservoirName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) );
        comps[2] = ReservoirName;
    	
     	
    	JLabel ReservoirComboCondition = new JLabel (res.getCombo());    	
    	ReservoirComboCondition.setForeground(Color.GREEN);
    	ReservoirComboCondition.setFont(bodytext);
    	ReservoirComboCondition.setBounds (
(int) Math.round(0.20491803278688525* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
        comps[3] = ReservoirComboCondition;
        
        JButton addRes = new JButton("Add Tubing");
        addRes.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) );
        comps[4] = addRes;
        addRes.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setRes(res);
        			wcsChanged = true; 

        	        } 
        	}
        );    	    	    	
    	return comps;
    }
    public Component[] createPumpRow(Pump pump, int y) {
    	Component[] comps = new Component[7];
    	
    	JLabel PumpTitleName = new JLabel ("Pump Name:");
    	PumpTitleName.setForeground(Color.GREEN);
    	PumpTitleName.setFont(sheader);
    	PumpTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) 
 );
    	comps[3] = PumpTitleName;
    	
     	JLabel PumpTypeName = new JLabel ("Pump Type?:");
     	PumpTypeName.setForeground(Color.GREEN);
     	PumpTypeName.setFont(sheader);
     	PumpTypeName.setBounds (
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height)  );
     	comps[4] = PumpTypeName;
    	
     	JLabel PumpBrandName = new JLabel ("Pump Brand:");
     	PumpBrandName.setForeground(Color.GREEN);
     	PumpBrandName.setFont(sheader);
     	PumpBrandName.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.2459016393442623* width), 
(int) Math.round(0.0875* height) 
);
    	comps[5] = PumpBrandName;
    	
    	
    	JLabel PumpName = new JLabel (pump.getName());    	
    	PumpName.setForeground(Color.BLUE);
    	PumpName.setFont(bodytext);
    	PumpName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
        comps[0] = PumpName;
    	
     	
    	JLabel PumpType = new JLabel (pump.getType());    	
    	PumpType.setForeground(Color.GREEN);
    	PumpType.setFont(bodytext);
    	PumpType.setBounds (
(int) Math.round(0.20491803278688525* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) );
        comps[1] = PumpType;
        
     	
    	JLabel PumpBrand = new JLabel (pump.getBrand());    	
    	PumpBrand.setForeground(Color.RED);
    	PumpBrand.setFont(bodytext);
    	PumpBrand.setBounds (
(int) Math.round(0.4918032786885246* width), 
y, 
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.0875* height) );
        comps[2] = PumpBrand;
        
        JButton addPump = new JButton("Add Pump");
        addPump.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) );
        comps[6] = addPump;
        addPump.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setPump(pump);
        			wcsChanged = true; 

        	        } 
        	}
        );    	    	    	    	
    	return comps;
    }
    public Component[] createFittingsRow(Fittings fit, int y) {
    	Component[] comps = new Component[5];
    	
    	JLabel FittingsTitleName = new JLabel ("Fittings Name:");
    	FittingsTitleName.setForeground(Color.GREEN);
    	FittingsTitleName.setFont(sheader);
    	FittingsTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height)  );
    	comps[0] = FittingsTitleName;
    	
     	JLabel FittingsDiameter = new JLabel ("Fitting(s) Size?:");
     	FittingsDiameter.setForeground(Color.GREEN);
     	FittingsDiameter.setFont(sheader);
     	FittingsDiameter.setBounds (
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height)  );
     	comps[1] = FittingsDiameter;
    	
    	JLabel FittingsTitle = new JLabel (fit.getName());    	
    	FittingsTitle.setForeground(Color.BLUE);
    	FittingsTitle.setFont(bodytext);
    	FittingsTitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  );
        comps[2] = FittingsTitle;
    	
     	
    	JLabel FittingsDiameterSize = new JLabel (fit.getDiameter());    	
    	FittingsDiameterSize.setForeground(Color.GREEN);
    	FittingsDiameterSize.setFont(bodytext);
    	FittingsDiameterSize.setBounds (
(int) Math.round(0.20491803278688525* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height)  );
        comps[3] = FittingsDiameterSize;
        
        JButton addFit = new JButton("Add Fittings");
        addFit.setBounds(
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height) 
);
        comps[4] = addFit;
        addFit.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setFit(fit);
        			wcsChanged = true; 

        	        } 
        	}
        );    	        	
    	return comps;
    }
	
    public Component[] createCoolantRow(Coolant cool, int y) {
    	Component[] comps = new Component[5];
    	
    	JLabel CoolantTitleName = new JLabel ("Coolant Name:");
    	CoolantTitleName.setForeground(Color.GREEN);
    	CoolantTitleName.setFont(sheader);
    	CoolantTitleName.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.0875* height) 
 );
    	comps[0] = CoolantTitleName;
    	
     	JLabel CoolantEdibleQuestion = new JLabel ("Is the Coolant Edible?:");
     	CoolantEdibleQuestion.setForeground(Color.GREEN);
     	CoolantEdibleQuestion.setFont(sheader);
     	CoolantEdibleQuestion.setBounds (
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.40625* height), 
(int) Math.round(0.45081967213114754* width), 
(int) Math.round(0.0875* height) 
);
     	comps[1] = CoolantEdibleQuestion;
    	
    	JLabel CoolantName = new JLabel (cool.getName());    	
    	CoolantName.setForeground(Color.BLUE);
    	CoolantName.setFont(bodytext);
    	CoolantName.setBounds (
(int) Math.round(0.01639344262295082* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
);
        comps[2] = CoolantName;
    	
     	
    	JLabel CoolantEdible = new JLabel (cool.getEdible());    	
    	CoolantEdible.setForeground(Color.GREEN);
    	CoolantEdible.setFont(bodytext);
    	CoolantEdible.setBounds (
    			
(int) Math.round(0.20491803278688525* width), 
y, 
(int) Math.round(0.16393442622950818* width), 
(int) Math.round(0.0875* height) 
 );
        comps[3] = CoolantEdible;
        
        JButton addCool = new JButton("Add Coolants");
        addCool.setBounds(
        		
(int) Math.round(0.7377049180327869* width), 
y, 
(int) Math.round(0.14754098360655737* width), 
(int) Math.round(0.04375* height)  );
        comps[4] = addCool;
        addCool.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        			wcs.setCool(cool);
        			wcsChanged = true; 

        	        } 
        	}
        );    	        	    	
    	return comps;
    }
    
	public JFrame createCpuFrame() {
		JFrame frame = new JFrame ("cpu123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("CPU Waterblocks"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        //20,150,1000,300
        
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 
 );
        frame.add(testtitle);
        
        int y = 400;
        ArrayList<CPUWaterblock> waterblocks = db.getCpuWaterblocks();
        
        for (int i = 0; i < waterblocks.size(); i++) {
	        Component[] row = createWaterblockRow(waterblocks.get(i), y);
	        y += 0.05*height;
	        for (int j = 0; j < row.length; j++) {
	        	frame.add(row[j]);
	        }
	        //y += 50;
        }
        
        
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
		
    	}
		return frame;
	}
	public JFrame createGpuFrame() {
		JFrame frame = new JFrame ("gpu123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("GPU Waterblocks"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) );
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
		
    	}
    	int y = 400;
        ArrayList <GPUWaterblock> waterblocks = db.getGpuWaterblocks();
        
        for (int i = 0; i < waterblocks.size(); i++) {
	        Component[] row = createGPUWaterblockRow(waterblocks.get(i), y);
	        y += 0.05 * height;
	        for (int j = 0; j < row.length; j++) {
	        	frame.add(row[j]);
	        	
	        }
        }
		return frame;
	}
	
	
	public JFrame createRadFrame() {
		JFrame frame = new JFrame ("rad123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Radiators"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 
);
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
    	int y = 400;
        ArrayList<Radiator> rad = db.getRadiators();
        
        for (int i = 0; i < rad.size(); i++) {
	        Component[] row = createRadiatorRow(rad.get(i), y);
	        y += 0.05 * height;
	        for (int j = 0; j < row.length; j++) {
	        	frame.add(row[j]);
	        	
	        }
        }
		return frame;
	}
	
	public JFrame createTubFrame() {
		JFrame frame = new JFrame ("tube123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Tubing"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) );
        frame.add(testtitle);
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
		
    	}
        int y = 400;
        ArrayList<Tubing> tub = db.getTubing();
        
        for (int i = 0; i < tub.size(); i++) {
	        Component[] row = createTubingRow(tub.get(i), y);
	        y += 0.05 * height; 
	        for (int j = 0; j < row.length; j++) {
	        	frame.add(row[j]);
	        }
	        //y += 50;
        }
		return frame;
	}
	
	public JFrame createresFrame() {
		JFrame frame = new JFrame ("res123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Reservoirs"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 

);
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
    		int y = 400;
            ArrayList<Reservoir> res = db.getReservoir();
            
            for (int i = 0; i < res.size(); i++) {
    	        Component[] row = createReservoirRow(res.get(i), y);
    	        y += 0.05 * height; 
    	        for (int j = 0; j < row.length; j++) {
    	        	frame.add(row[j]);
    	        }
    	        //y += 50;
    	}
		return frame;
	}
	
	public JFrame createPumpFrame() {
		JFrame frame = new JFrame ("pump123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Pumps"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) );
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
    	}
        int y = 400;
        ArrayList<Pump> pump = db.getPump();
        
        for (int i = 0; i < pump.size(); i++) {
	        Component[] row = createPumpRow(pump.get(i), y);
	        y += 0.05 * height;
	        for (int j = 0; j < row.length; j++) {
	        	frame.add(row[j]);
	        }
	        //y += 50;
        }
		return frame;
		

	}
	
	public JFrame createFitFrame() {
		JFrame frame = new JFrame ("fitting123");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Fittings"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) );
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
		
    	}
    	  int y = 400;
          ArrayList<Fittings> fit = db.getFittings();
          
          for (int i = 0; i < fit.size(); i++) {
  	        Component[] row = createFittingsRow(fit.get(i), y);
  	        y += 0.05 * height; 
  	        for (int j = 0; j < row.length; j++) {
  	        	frame.add(row[j]);
  	        }
  	        //y += 50;
          }
  		return frame;
  			}
	
	public JFrame createCoolFrame() {
		JFrame frame = new JFrame ("Coolant");
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("Coolants"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) );
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
		
    	}
    		 int y = 400;
             ArrayList<Coolant> cool = db.getCoolant();
             
             for (int i = 0; i < cool.size(); i++) {
     	        Component[] row = createCoolantRow(cool.get(i), y);
     	        y += 0.05 * height; 
     	        for (int j = 0; j < row.length; j++) {
     	        	frame.add(row[j]);
     	        }
     	        //y += 50;
             }
     		return frame;
     }
    	
	public JFrame createSystemFrame() {
		
		JFrame frame = new JFrame("CreateSys");
		
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);

        JComponent[] searchFunction = createSearchFunction(frame);
	    frame.add(searchFunction[0]);
	    frame.add(searchFunction[1]);
        
   
        JButton testSys = new JButton("TEST");
        testSys.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.85* height), 
(int) Math.round(0.20491803278688525* width), 
(int) Math.round(0.1* height) );
    	frame.add(testSys);
        testSys.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
        		wcs.check();
        		System.out.println(wcs.getAdvice());
        		System.out.println(wcs.getErrors());
        	}
        });	
        
        ArrayList<CPU> CPUListArr = db.getCpu();
        String[] CPUList = new String[CPUListArr.size()];
        for(int i = 0; i < CPUListArr.size(); i++) {
      	  String name = CPUListArr.get(i).toString();  
      	  CPUList[i] = name;    
        }
        
      JComboBox CPUBox = new JComboBox(CPUList);
      
      //CPUBox.setSelectedIndex(4);
      CPUBox.addActionListener(new ActionListener(){  
     	public void actionPerformed(ActionEvent e){  
     	      String cpuString = (String) CPUBox.getSelectedItem();
     	      for(int i = 0; i < CPUListArr.size(); i++) {
     	    	  if(cpuString.equals(CPUListArr.get(i).toString())) {
     	    		 wcs.setCpu(CPUListArr.get(i));
         			wcsChanged = true; 
         			return;
     	    	  }
     	      }
     		//System.out.println(CPUBox.getSelectedItem());

	        } 
     }
     );
     
      CPUBox.setBounds(170,330,200,50);
      frame.add(CPUBox);
      
      
      
      
      ArrayList<GPU> GPUListArr = db.getGpu();    
      String[] GPUList = new String[GPUListArr.size()];
      for(int i = 0; i < GPUListArr.size(); i++) {
    	  String name = GPUListArr.get(i).toString();  
    	  GPUList[i] = name;    
      }
      JComboBox GPUBox = new JComboBox(GPUList);
      GPUBox.setSelectedIndex(4);
     // petList.addActionListener((ActionListener) this);
      GPUBox.setBounds(170,410,200,50);      
      frame.add(GPUBox);

        	
      
      
      
		JLabel CreateSysTitle = new JLabel ("Create a new system "); 
		CreateSysTitle.setForeground(Color.BLUE);
		CreateSysTitle.setFont(fheader);
		CreateSysTitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 

);
        frame.add(CreateSysTitle);
        
        JLabel showSysCPU = new JLabel ("Current CPU:");
        showSysCPU.setForeground(Color.BLUE);
        showSysCPU.setFont(bodytext);
        showSysCPU.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.275* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(showSysCPU);
        
        JLabel currentCPU = new JLabel(wcs.CPUtoString());
        currentCPU.setForeground(Color.BLUE);
        currentCPU.setFont(bodytext);
        currentCPU.setBounds(
(int) Math.round(0.13934426229508196* width), 
(int) Math.round(0.275* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentCPU);
        
        JLabel showSysGPU = new JLabel ("Current GPU:");
        showSysGPU.setForeground(Color.BLUE);
        showSysGPU.setFont(bodytext);
        showSysGPU.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.35* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysGPU);
        
        JLabel currentGPU = new JLabel(wcs.GPUtoString());
        currentGPU.setForeground(Color.BLUE);
        currentGPU.setFont(bodytext);
        currentGPU.setBounds(
(int) Math.round(0.13934426229508196* width), 
(int) Math.round(0.35* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 

);
        frame.add(currentGPU);
        
        JLabel showSysCWB = new JLabel ("Current CPU Waterblock:");
        showSysCWB.setForeground(Color.BLUE);
        showSysCWB.setFont(bodytext);
        showSysCWB.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.425* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysCWB);
        
        JLabel currentCPUWB = new JLabel(wcs.CPUWBtoString());
        currentCPUWB.setForeground(Color.BLUE);
        currentCPUWB.setFont(bodytext);
        currentCPUWB.setBounds(
(int) Math.round(0.23770491803278687* width), 
(int) Math.round(0.425* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentCPUWB);
       
        JLabel showSysGWB = new JLabel ("Current GPU Waterblock:");
        showSysGWB.setForeground(Color.BLUE);
        showSysGWB.setFont(bodytext);
        showSysGWB.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.5* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(showSysGWB);
        
        JLabel currentGPUWB = new JLabel(wcs.GPUWBtoString());
        currentGPUWB.setForeground(Color.BLUE);
        currentGPUWB.setFont(bodytext);
        currentGPUWB.setBounds(
(int) Math.round(0.23770491803278687* width), 
(int) Math.round(0.5* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentGPUWB);
        
        JLabel showSysRad = new JLabel ("Current Radiator:");
        showSysRad.setForeground(Color.BLUE);
        showSysRad.setFont(bodytext);
        showSysRad.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.575* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(showSysRad);
        
        JLabel currentRad = new JLabel(wcs.RadtoString());
        currentRad.setForeground(Color.BLUE);
        currentRad.setFont(bodytext);
        currentRad.setBounds(
(int) Math.round(0.1721311475409836* width), 
(int) Math.round(0.575* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentRad);
       
        JLabel showSysTub = new JLabel ("Current Tubing:");
        showSysTub.setForeground(Color.BLUE);
        showSysTub.setFont(bodytext);
        showSysTub.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.275* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysTub);
        
        JLabel currentTub = new JLabel(wcs.TubtoString());
        currentTub.setForeground(Color.BLUE);
        currentTub.setFont(bodytext);
        currentTub.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.275* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentTub);
 
        JLabel showSysRes = new JLabel ("Current Reservoir:");
        showSysRes.setForeground(Color.BLUE);
        showSysRes.setFont(bodytext);
        showSysRes.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.35* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysRes);
        
        JLabel currentRes = new JLabel(wcs.RestoString());
        currentRes.setForeground(Color.BLUE);
        currentRes.setFont(bodytext);
        currentRes.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.35* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(currentRes);
    
        JLabel showSysPump = new JLabel ("Current Pump:");
        showSysPump.setForeground(Color.BLUE);
        showSysPump.setFont(bodytext);
        showSysPump.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.425* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(showSysPump);
        
        JLabel currentPump = new JLabel(wcs.PumptoString());
        currentPump.setForeground(Color.BLUE);
        currentPump.setFont(bodytext);
        currentPump.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.425* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentPump);
        
        JLabel showSysFit = new JLabel ("Current Fittings:");
        showSysFit.setForeground(Color.BLUE);
        showSysFit.setFont(bodytext);
        showSysFit.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.5* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysFit);

        JLabel currentFit = new JLabel(wcs.FittoString());
        currentFit.setForeground(Color.BLUE);
        currentFit.setFont(bodytext);
        currentFit.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.5* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(currentFit);

        
        JLabel showSysCool = new JLabel ("Current Coolant:");
        showSysCool.setForeground(Color.BLUE);
        showSysCool.setFont(bodytext);
        showSysCool.setBounds (
(int) Math.round(0.4918032786885246* width), 
(int) Math.round(0.575* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) 
);
        frame.add(showSysCool);
        
        JLabel currentCool = new JLabel(wcs.CooltoString());
        currentCool.setForeground(Color.BLUE);
        currentCool.setFont(bodytext);
        currentCool.setBounds(
(int) Math.round(0.6557377049180327* width), 
(int) Math.round(0.575* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.375* height) );
        frame.add(currentCool);
    
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
    
    	/* tab1 */

           	return frame;
	}



public JComponent[] createSearchFunction(JFrame frame) {
	
	JTextField searchBar = new JTextField();
	    	searchBar.setColumns(20);
	    	searchBar.setBounds(
	(int) Math.round(0.6967213114754098* width), 
	(int) Math.round(0.3125* height), 
	(int) Math.round(0.16393442622950818* width), 
	(int) Math.round(0.0875* height) 
	);
	    	
 
	JButton searchBtn = new JButton("Search for Components");
	searchBtn.setBounds(
(int) Math.round(0.860655737704918* width), 
(int) Math.round(0.3125* height), 
(int) Math.round(0.05737704918032787* width), 
(int) Math.round(0.0875* height) );
	searchBtn.addActionListener(new ActionListener(){  
		public void actionPerformed(ActionEvent e){ 
			String search = searchBar.getText();
			String specialChar = "!@#$%^&*()_+=?><,./\\;:[]{}`~";
			
			for(int i = 0; i < search.length(); i++) {
				for(int j = 0; j < specialChar.length(); j++) {
					if(search.charAt(i) == specialChar.charAt(j)) {
						
					JOptionPane.showMessageDialog(frame,
							"Error! Special Characters Detected. Please refrain from using special characters when searching components. Thanks.",
							"STOP!",
							    JOptionPane.WARNING_MESSAGE);
						
					}
				}
			}
			
			searchFrame = createSearchedFrame(search);
			changeFrame(searchFrame);
			/*for (int i = 0; i < parts.size(); i++) {
				System.out.println(parts.get(i));
			} */
		}  
    });

		JComponent[] items = new JComponent[2];
		items[0] = searchBar;
		items[1] = searchBtn;		
		
		return items;

}
		
	
	

	public JFrame createSearchedFrame(String search) {
		JFrame frame = new JFrame("Search Results");
		
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        JLabel searchResult = new JLabel ("Search Results");    	
        searchResult.setForeground(Color.BLUE);
        searchResult.setFont(fheader);
        searchResult.setBounds (
			(int) Math.round(0.01639344262295082* width), 
			(int) Math.round(0.34375* height), 
			(int) Math.round(0.4098360655737705* width), 
			(int) Math.round(0.0875* height) );
        frame.add(searchResult);
       
        JComponent[] searchFunction = createSearchFunction(frame);
	    frame.add(searchFunction[0]);
	    frame.add(searchFunction[1]);
    	
    	

	    ArrayList<Part> results = db.partSearch(search);
	    Part part;
	    Component[] comps = new Component[0];
	    y = (int) (0.5*height);

        for(int i = 0; i < results.size(); i++) {
            part = results.get(i);
            	 if (part instanceof CPUWaterblock) comps = createWaterblockRow((CPUWaterblock)part,y);
            else if (part instanceof GPUWaterblock) comps = createGPUWaterblockRow((GPUWaterblock)part,y);
            else if (part instanceof Radiator) 		comps = createRadiatorRow((Radiator)part,y);
            else if (part instanceof Tubing) 		comps = createTubingRow((Tubing)part,y);
            else if (part instanceof Reservoir) 	comps = createReservoirRow((Reservoir)part,y);
    		else if (part instanceof Pump) 			comps = createPumpRow((Pump)part,y);
    		else if (part instanceof Fittings) 		comps = createFittingsRow((Fittings)part,y);
    		else if (part instanceof Coolant) 		comps = createCoolantRow((Coolant)part,y);
            y += 0.05 * height;
    	}
    		
		for(int j = 0; j < comps.length; j++ ) {
            frame.add(comps[j]);
		}
/*tab2*/
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
    	
		return frame;
	    
	}
       

        
        
        
      
	
	
	public JFrame createDummyFrame() {
		JFrame frame = new JFrame("WCS");
		
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.GRAY);
        
		JLabel testtitle = new JLabel ("testing123"); 
		testtitle.setForeground(Color.BLUE);
        testtitle.setFont(fheader);
        testtitle.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 
);
        frame.add(testtitle);
        
        Component[] mainComponents = createMainComponents();
    	for (int i = 0; i < mainComponents.length; i++) {
    		frame.add(mainComponents[i]);
    	}
		
    	return frame;
		
	}
	
	
	

    public Component[] createFirstViewComponents() {
    	
    	Component[] comps = new Component[4];
    	
    	int i = 0;
    	
        // Create Title Text
        JLabel title = new JLabel("Why Water-Cooling?");
        title.setForeground(Color.BLUE);
        title.setFont(fheader);
        title.setBounds (
(int) Math.round(0.01639344262295082* width), 
(int) Math.round(0.1875* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.375* height) 
);
        comps[i++] = title;
        
        // Create Subtitle Text 
        JLabel subtitle = new JLabel("Why Not?");
        subtitle.setForeground(Color.BLACK);
        subtitle.setFont(sheader);
        subtitle.setBounds(
(int) Math.round(0.012295081967213115* width), 
(int) Math.round(0.125* height), 
(int) Math.round(0.4098360655737705* width), 
(int) Math.round(0.625* height) 
);
        comps[i++] = subtitle;
        
        // Create Body Text 
        JLabel btext = new JLabel(""
        		+ "<html><p style=\"width:" + 0.40983606557 * width  + "px\">"
        		+ "In all seriousness, water-cooling your personal "
        		+ "computer is the next step in truly becoming an "
        		+ "enthusiast. The best components are only worthy of "
        		+ "the best cooling-system out there- water-cooling. "
        		+ "While water-cooling may seem extremely "
        		+ "complicated for the beginning novice, ihere at WCPC "
        		+ "we strive to simplify this process for you, and direct "
        		+ "you on your journey to becoming a water-cooler."
        		+ "</p></html>");
        btext.setForeground(Color.BLACK);
        btext.setFont(bodytext);
        btext.setBounds(
(int) Math.round(0.012295081967213115* width), 
(int) Math.round(0.4375* height), 
(int) Math.round(0.819672131147541* width), 
(int) Math.round(0.3125* height) 

);
        comps[i++] = btext;
        
        // Create Front page photo 
        
        JLabel frontpic = new JLabel(new ImageIcon(resourcePath + "examplepic.JPG"));
        frontpic.setBounds(
(int) Math.round(0.5647540983606557* width), 
(int) Math.round(0.3375* height), 
(int) Math.round(0.4057377049180328* width), 
(int) Math.round(0.4375* height) 
);
        comps[i++] = frontpic;

        
        return comps;
        
        
    }
    
    private static int xLocation(int n) {
    	return n*(120+12) + 18;
    }
    
    
    public void changeFrame(JFrame targetFrame) {
    	if (currentFrame == targetFrame) return;
		x = currentFrame.getX();
		y = currentFrame.getY();
		JFrame tmp = currentFrame;
		currentFrame = targetFrame;
		show();
		tmp.setVisible(false);
    }
    
    
    
    
    
    
    
    
    
    public Component[] createMainComponents() {
    	Component[] comps = new Component[11]; 
    	int i = 0;
    	
    	// Create banner
    	JLabel banner = new JLabel(new ImageIcon(resourcePath + "banner.png"));
        banner.setBounds(0, 0, width, 
        		(int) Math.round(0.135* height) 
);
        comps[i++] = banner;
        

        
        // Create buttons
        int bcount = 0; 
        
        // new system button
        JButton buildsys = new JButton(new ImageIcon(resourcePath + "b1.png"));
        buildsys.setBounds(
        		(int) Math.round(0.014754098360655738* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) 
);
        bcount++;
        
        buildsys.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		
        		if(wcsChanged == true) {
        			systemFrame = createSystemFrame();
        			wcsChanged = false; 
        		}
        		
        		changeFrame(systemFrame);
        	 }  
        });  
        comps[i++] = buildsys;

        // view water cooling parts button
        // temporarily first view buttonsystemFrame
        JButton viewcpu = new JButton(new ImageIcon(resourcePath + "b2.png"));
        viewcpu.setBounds(
        		(int) Math.round(0.12295081967213115* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) );
        bcount++;
        viewcpu.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        		changeFrame(cpuFrame);
        	}  
        });  
        comps[i++] = viewcpu;
        
        JButton viewgpu = new JButton(new ImageIcon(resourcePath + "b3.png"));
        viewgpu.setFont(buttontext);
        viewgpu.setBounds(
        		(int) Math.round(0.23114754098360657* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) 
);

        bcount++;
        viewgpu.setBackground(Color.ORANGE);
        viewgpu.addActionListener(new ActionListener(){  
        	
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(gpuFrame);  
        	        }  
        	    });  
        comps[i++] = viewgpu;
        
        JButton rad = new JButton(new ImageIcon(resourcePath + "b4.png"));
        rad.setBounds(
        		(int) Math.round(0.33934426229508197* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) );
        bcount++;
        rad.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(radFrame);  
        	        }  
        	    });  
        comps[i++] = rad;
       
        JButton tube = new JButton(new ImageIcon(resourcePath + "b5.png"));
        tube.setBounds(
        		(int) Math.round(0.44754098360655736* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height));
        bcount++;
        tube.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(tubFrame);  
        	        }  
        	    });  
        comps[i++] = tube;
        
        JButton res = new JButton(new ImageIcon(resourcePath + "b6.png"));
        res.setBounds(
        		(int) Math.round(0.5557377049180328* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height));
        bcount++;
        res.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(resFrame);  
        	        }  
        	    });  
        comps[i++] = res;

        JButton pump = new JButton(new ImageIcon(resourcePath + "b7.png"));
        pump.setBounds(
        		(int) Math.round(0.6639344262295082* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) );
        bcount++;
        pump.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(pumpFrame);  
        	        }  
        	    });  
        comps[i++] = pump;

        JButton fit = new JButton(new ImageIcon(resourcePath + "b8.png"));
        fit.setBounds(
        		(int) Math.round(0.7721311475409836* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) );
        bcount++;
        fit.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	            changeFrame(fitFrame);  
        	        }  
        	    });  
        comps[i++] = fit;
        JButton cool = new JButton(new ImageIcon(resourcePath + "b9.png"));
        cool.setBounds(
        		(int) Math.round(0.8803278688524591* width), 
        		(int) Math.round(0.14375* height), 
        		(int) Math.round(0.09836065573770492* width), 
        		(int) Math.round(0.15* height) );
        bcount++;
        cool.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){  
        	           changeFrame(coolFrame);  
        	        }  
        	    });  
        comps[i++] = cool;
        
        
        // Create TextIcon 
        
        JLabel botbanner = new JLabel(new ImageIcon(resourcePath + "botbanner2.png"));
        botbanner.setBounds(
(int) Math.round(0.0* width), 
(int) Math.round(0.76875* height), 
(int) Math.round(0.9934426229508196* width), 
(int) Math.round(0.255* height) );
        comps[i++] = botbanner;
        
    	return comps;
    }
    
    public void loadWorkspace(Component[] comps) {
    	for (int i = 0; i < comps.length; i++) {
    		baseFrame.add(comps[i]);
    	}
    	
    }
    
    public void unloadWorkspace(Component[] comps) {
    	for (int i = 0; i < comps.length; i++) {
    		baseFrame.remove(comps[i]);
    	}
    	
    }
    //tab 3

    	
    	
    	
    
    public void show() {
        // Show frame
    	currentFrame.setLocation(x, y);
        currentFrame.setLayout(null);
        currentFrame.setVisible(true);
    }
    
    

}
