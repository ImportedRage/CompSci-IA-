
import java.sql.*;
import java.util.*;

public class Database {
	
	Database() {
		/* check if database exists, if not create it */
		//Connection conn = connect();

	}
	
	private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:/home/madacoo/Desktop/robert_choy/CompSci-IA-/eclipse-workspace/WaterCooling/watercooler.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connected to database.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
	
	int countCpuWaterblocks() {
		// query database for amount of cpu waterblocks
		return 1;
	}
	
	
	public CPU[] getCpu() {
		
		CPU[] CPUList = new CPU[1];
		
		/*
		String sql = "SELECT * FROM cpus"; // table does not exist
		
		try (
				Connection c    = connect();
		        Statement stmt  = c.createStatement();
		        ResultSet rs    = stmt.executeQuery(sql)
	        ) {
	        while (rs.next()) {
	        	String name = rs.getString("name");
	        	String model = rs.getString("model");
	        	System.out.println(name + " " + model); // this should add a new CPU to CPUList
	        
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		CPUList[0] = new CPU("IntelCPU001", "2011-3");
		return CPUList; 
	}
	
	
	public GPU[] getGpu() {
		GPU[] GPUList = new GPU[1]; 
		GPUList[0] = new GPU("NVidiaGPU001", "GTX1080");
		return GPUList;
	}
	
	
	public ArrayList<CPUWaterblock> getCpuWaterblocks() {
		
		ArrayList<CPUWaterblock> resultsList = new ArrayList<CPUWaterblock>();
		
		String sql = "SELECT * FROM cpuwaterblock";
		
		try (
				Connection c    = connect();
		        Statement cwbStmt  = c.createStatement();
		        ResultSet rs    = cwbStmt.executeQuery(sql);
		        
	        ) {
	        while (rs.next()) {
	        	
	        	/* read through each column of a result and use those values to make a CpuWaterblock */
	        	
	        	String name = rs.getString("name");
	        	
	        	// metal_id
	        	int metal_id = rs.getInt("metal_id");
	        	
	        	Statement metStmt = c.createStatement();
	        	ResultSet metRs = metStmt.executeQuery("SELECT * FROM metal WHERE id=" + metal_id + ";");
	        	
	        	String metal = metRs.getString("name");
	        	
	        	// socket_id
	        	int socket_id = rs.getInt("socket_id");
	        	
	        	Statement socStmt = c.createStatement();
	        	ResultSet socRs = socStmt.executeQuery("SELECT * FROM socket WHERE id=" + socket_id + ";");
	        	
	        	String socket = socRs.getString("name");
	        	
	        	
	        	
	        	resultsList.add(new CPUWaterblock(socket, metal, name));
	        	
	        	
	        	System.out.println(name + " " + metal); // this should add a new CPU to CPUList
	        	
	        	// add new CpuWaterblock to an array.
	        	
	        
	        }
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		/* print out the resultList */
		
		
		
		return resultsList;
		
		
		
		
		
		
		
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
		if (name.equals("")) return matchingParts;
		
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
		
		//parts.addAll(getCpuWaterblocks());
		ArrayList<CPUWaterblock> cwbs = getCpuWaterblocks();
		System.out.println("cwb size:" + cwbs.size());
		for (int i = 0; i < cwbs.size(); i++) {
			parts.add(cwbs.get(i));
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


