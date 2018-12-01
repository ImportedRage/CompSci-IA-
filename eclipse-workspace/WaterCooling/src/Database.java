
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
		CPUWaterblock[] waterblocks = new CPUWaterblock[1];
		
		// query database and parse into waterblocks array
		waterblocks[0] = new CPUWaterblock("2011-3", "Copper", "Toby");
		return waterblocks;
		
		
	}
	public GPUWaterblock[] getGpuWaterblocks() {
		GPUWaterblock[] waterblocks = new GPUWaterblock[1]; 
		
		waterblocks[0] = new GPUWaterblock("Name01", "Model01", "Metal01" );
		return waterblocks;
	}
	public Radiator[] getRadiators() {
		Radiator[] rad = new Radiator[1];
		rad[0] = new Radiator("RadName01","999", "Metal:Platinum");
		return rad;
	}
	public Tubing[] getTubing() {
		Tubing[] tub = new Tubing[1];
		tub[0] = new Tubing("TubName01", "True/False", "Diameter:900 Meters");
		return tub;
			
	}
	public Reservoir[] getReservoir() {
		Reservoir[] res = new Reservoir[1];
		res[0] = new Reservoir("ResName01", "Combo:True");
		return res;
			
	}
	public Pump[] getPump() {
		Pump[] pump = new Pump[1];
		pump[0] = new Pump("PumpName","PumpType01", "Pump Brand");
		return pump;
			
	}
	public Fittings[] getFittings() {
		Fittings[] fit = new Fittings[1];
		fit[0] = new Fittings("FittingName01","FittingDiameter:9000");
		return fit;
			
	}
	public Coolant[] getCoolant() {
		Coolant[] cool = new Coolant[1];
		cool[0] = new Coolant("CoolantName01","True");
		return cool;
	}
	
	public ArrayList<Part> partSearch(String name) {
		ArrayList<Part> matchingParts = new ArrayList<Part>();
	    ArrayList<Part> allParts = getAllParts();
	    
	    for(int i = 0; i < allParts.size(); i++) {
	    	if(allParts.get(i).toString().equals(name)) {
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


