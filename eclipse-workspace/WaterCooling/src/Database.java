
import java.sql.*;
import java.util.*;

public class Database {
	
	Connection c;
	
	Database() {
	      Connection c = null;
	      
	      try {
	         Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:watercoolers.odb");
	      } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	   

	}
	
	int countCpuWaterblocks() {
		// query database for amount of cpu waterblocks
		return 1;
	}
	
	public CPU[] getCpu() {
		CPU[] CPUList = new CPU[1];
		CPUList[0] = new CPU("IntelCPU001", "2011-3");
		return CPUList; 
	}
	public GPU[] getGpu() {
		GPU[] GPUList = new GPU[1]; 
		GPUList[0] = new GPU("NVidiaGPU001", "GTX1080");
		return GPUList;
	}
	
	
	public CPUWaterblock[] getCpuWaterblocks() {
		//int n = countCpuWaterblocks();
		CPUWaterblock[] waterblocks = new CPUWaterblock[2];
		
		// query database and parse into waterblocks array
		waterblocks[0] = new CPUWaterblock("2011-3", "Copper", "Toby");
		waterblocks[1] = new CPUWaterblock("2011-3", "Copper", "Kevin");
		return waterblocks;
		
		
	}
	public GPUWaterblock[] getGpuWaterblocks() {
		GPUWaterblock[] waterblocks = new GPUWaterblock[2]; 
		
		waterblocks[0] = new GPUWaterblock("Name01", "Model01", "Metal01" );
		waterblocks[1] = new GPUWaterblock("Name01", "Mode101", "Meta102");
		return waterblocks;
	}
	public Radiator[] getRadiators() {
		Radiator[] rad = new Radiator[2];
		rad[0] = new Radiator("RadName01","999", "Metal:Platinum");
		rad[1] = new Radiator("RadName02", "999", "Metal: Metal");
		return rad;
	}
	public Tubing[] getTubing() {
		Tubing[] tub = new Tubing[2];
		tub[0] = new Tubing("TubName01", "True/False", "Diameter:900 Meters");
		tub[1] = new Tubing("TubName02", "Probably...", "Diameter: 9 Lightyears");
		return tub;
			
	}
	public Reservoir[] getReservoir() {
		Reservoir[] res = new Reservoir[2];
		res[0] = new Reservoir("ResName01", "Combo:True");
		res[1] = new Reservoir("ResName02", "Combo: Probably...");
		return res;
			
	}
	public Pump[] getPump() {
		Pump[] pump = new Pump[2];
		pump[0] = new Pump("PumpName","PumpType01", "Pump Brand");
		pump[1] = new Pump("PumpName02", "PumpType01", "A brand");
		return pump;
			
	}
	public Fittings[] getFittings() {
		Fittings[] fit = new Fittings[2];
		fit[0] = new Fittings("FittingName01","FittingDiameter:9000");
		fit[1] = new Fittings("FittingName02", "FittingDiameter: Really big");
		return fit;
			
	}
	public Coolant[] getCoolant() {
		Coolant[] cool = new Coolant[2];
		cool[0] = new Coolant("CoolantName01","True");
		cool[1] = new Coolant("CoolantName02", "Maybe");
		return cool;
	}
	
	public ArrayList<Part> partSearch(String name) {
		ArrayList<Part> matchingParts = new ArrayList<Part>();
	    ArrayList<Part> allParts = getAllParts();
	    
	    for(int i = 0; i < allParts.size(); i++) {
	    	if(allParts.get(i).toString().equals(name)) { // bug, GPUWAterblock replaces all component names with th elast component name. Must fix. 
	    		matchingParts.add(allParts.get(i));
	    	}
	    }
		
		return matchingParts;
	}

	private ArrayList<Part> getAllParts() {
		ArrayList<Part> parts = new ArrayList<Part>();
		Part[] partArr;
		
		partArr = getCpu();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getGpu();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getCpuWaterblocks();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getGpuWaterblocks();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		partArr = getRadiators();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		partArr = getTubing();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getReservoir();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getPump();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getFittings();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
		
		partArr = getCoolant();
		for (int i = 0; i < partArr.length; i++) {
			parts.add(partArr[i]);
		}
	
		
		return parts;
	
	
		
	}

	
	
	
	
	
	
}


