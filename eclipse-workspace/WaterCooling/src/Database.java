
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
	
	
	public ArrayList<GPU> getGpu() {

			
			ArrayList<GPU> resultsList = new ArrayList<GPU>();
			
			
			String[] columns = new String[] {"name",};
			ArrayList<ArrayList<String>> results = select("gpumodel", "", columns);
			
			for (int i = 0; i < results.size(); i++) {
				
				ArrayList<String> row = results.get(i);
				String name = row.get(0);
				resultsList.add(new GPU(name));
				
			}

			return resultsList;
			
			
			
			
	}
	
	
	public ArrayList<ArrayList<String>> select(String table, String id, String[] columns) {
		/* Firstly, the method takes a "table, id and Array of Properties". The string table refers to the name of the specific table
		 * within the database needed to select from. The string id refers to a specific row within the table, and if the id is the empty string, it will return every row. 
		 * The properties array refers to the number and the different columns of properties (ie: metal, socket etc...) within the database. 
		 *   
		 * The Arraylist within the Arraylist creates a 2D arraylist where each arraylist corresponds to a specific row from the database, with each individual 
		 * object within the database referring to an arraylist within the arraylist. 
		 * 
		 * The arraylist row is an arraylist within the reuslts arraylist that an individual object takes up. 
		 * 
		 * The SQL Statement builds the sql command to select all objects within a specific table, as well as establishing a connection from and to the database. 
		 * It also fills the results array with all the data selected and obtained from the database. 
		 * 
		 * The try { section refers to: 
		 * After executing the query to the SQL, the for loop goes through each column within each row, selecting the data within each row. The While Loop covers
		 * each column within the database and ensures that the for loop ends once all the data have been selected. 
		 * The catch SQL exception catches any potential errors and prints out any possible errors. 
		 * By returning the results, it returns the data from the database. 
		 */
		
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		ArrayList<String> row = new ArrayList<String>();
		
		
		
		// build sql statement
		String sql = "SELECT * FROM " + table;
		if (!id.equals("")) {
			sql += " WHERE id=" + id;
		}
		sql += ";";
		
		// connect to database
		Connection c;

    	try {
    		c = connect();
    		
        	ResultSet rs;
    		Statement stmt = c.createStatement();
    		rs = stmt.executeQuery(sql);
    		while (rs.next()) {
    			// The line below ensures that the previous row is cleared and that any further rows will not include the previous row, 
    			//resulting in only one variable being displayed.  
    			row = new ArrayList<String>();
		    	for (int i = 0; i < columns.length; i++) {
		    		String property = rs.getString(columns[i]);
		    		row.add(property);
		    	}
		    	results.add(row);
    		}
    		c.close();
    	
    	} catch (SQLException e) {
    		System.out.println(table);
			System.out.println(e.getMessage());
			System.out.println();
			
		}
    	
		return results;
	}
	
	
	public ArrayList<CPUWaterblock> getCpuWaterblocks() {
		
		ArrayList<CPUWaterblock> resultsList = new ArrayList<CPUWaterblock>();
		
		
		String[] columns = new String[] { "name", "metal_id", "socket_id" };
		ArrayList<ArrayList<String>> results = select("cpuwaterblock", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String metal_id = row.get(1);
			String metal = select("metal", metal_id, new String[] {"name" }).get(0).get(0);
			
			String socket_id = row.get(2);
			String socket = select("socket", socket_id, new String[] {"name" }).get(0).get(0);
			
			resultsList.add(new CPUWaterblock(socket, metal, name));
			
		}

		return resultsList;
		
		
		
		
		
		
		
	}
	public ArrayList<GPUWaterblock> getGpuWaterblocks() {
		ArrayList<GPUWaterblock> resultsList = new ArrayList<GPUWaterblock>();
		
		
		String[] columns = new String[] { "name", "metal_id", "GPUmodel_id" };
		ArrayList<ArrayList<String>> results = select("gpuwaterblock", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String metal_id = row.get(1);
			String metal = select("metal", metal_id, new String[] {"name" }).get(0).get(0);
			
			String GPUmodel_id = row.get(2);
			String GPUmodel = select("GPUmodel", GPUmodel_id, new String[] {"name" }).get(0).get(0);
			
			resultsList.add(new GPUWaterblock(name, GPUmodel, metal));
			
		}

		return resultsList;
	}
	public ArrayList<Radiator> getRadiators() {	
		ArrayList<Radiator> resultsList = new ArrayList<Radiator>();
		
		
		String[] columns = new String[] { "name", "metal_id", "maxfancount_id" };
		ArrayList<ArrayList<String>> results = select("radiator", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String metal_id = row.get(1);
			String metal = select("metal", metal_id, new String[] {"name" }).get(0).get(0);
			
			String maxfancount_id = row.get(2);
			String maxfancount = select("maxfancount", maxfancount_id, new String[] {"name" }).get(0).get(0);
			
			resultsList.add(new Radiator(name, maxfancount, metal));
			
		}

		return resultsList;
	}
	public ArrayList<Tubing> getTubing() {
		ArrayList<Tubing> resultsList = new ArrayList<Tubing>();
		
		
		String[] columns = new String[] { "name", "material_id", "diameter_id" };
		ArrayList<ArrayList<String>> results = select("tubing", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String material_id = row.get(1);
			
			String bendable = select("material", material_id, new String[] {"bendability" }).get(0).get(0);
				if(bendable.equals("1")) {
					bendable = ("Yes"); 
				} else {
					bendable = ("No");
				}
			
			String diameter_id = row.get(2);
			String diameter = select("diameter", diameter_id, new String[] {"name" }).get(0).get(0);
			
			resultsList.add(new Tubing (name, bendable,diameter ));
			
		}

		return resultsList;
	}
	public ArrayList<Reservoir> getReservoir() {
		ArrayList<Reservoir> resultsList = new ArrayList<Reservoir>();
		
		
		String[] columns = new String[] { "name", "combo_id"};
		ArrayList<ArrayList<String>> results = select("reservoir", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String combo_id = row.get(1);
			
			try {
				ArrayList<ArrayList<String>> comboTable = select("combo", combo_id, new String[] {"name" });
				ArrayList<String> comboRow = comboTable.get(0);
				String combo = comboRow.get(0);
				resultsList.add(new Reservoir (name, combo));
			} catch (IndexOutOfBoundsException e) {
				System.out.println(e);
				
			}
		
			
			
			
		}

		return resultsList;
			
	}
	public ArrayList<Pump> getPump() {
		ArrayList<Pump> resultsList = new ArrayList<Pump>();
		
		
		String[] columns = new String[] { "name", "type_id", "brand_id"};
		ArrayList<ArrayList<String>> results = select("pump", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String type_id = row.get(1);
			String type = select("type", type_id, new String[] {"name" }).get(0).get(0);
			
			String brand_id = row.get(2);
			String brand = select("brand", brand_id, new String[] {"name" }).get(0).get(0);
		
			
			resultsList.add(new Pump (name, type, brand));
			
		}

		return resultsList;
			
	}
	public ArrayList<Fittings> getFittings() {
		ArrayList<Fittings> resultsList = new ArrayList<Fittings>();
		
		
		String[] columns = new String[] { "name", "diameter_id"};
		ArrayList<ArrayList<String>> results = select("fitting", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String diameter_id = row.get(1);
			String diameter = select("diameter", diameter_id, new String[] {"name" }).get(0).get(0);
			
			
		
			
			resultsList.add(new Fittings (name, diameter));
			
		}

		return resultsList;
			
	}
	public ArrayList<Coolant> getCoolant() {
		ArrayList<Coolant> resultsList = new ArrayList<Coolant>();
		
		
		String[] columns = new String[] { "name", "edible_id"};
		ArrayList<ArrayList<String>> results = select("coolant", "", columns);
		
		for (int i = 0; i < results.size(); i++) {
			
			ArrayList<String> row = results.get(i);
			String name = row.get(0);
			
			String edible_id = row.get(1);
			String edible = select("edible", edible_id, new String[] {"name" }).get(0).get(0);
			
		
			resultsList.add(new Coolant (name, edible));
			
		}

		return resultsList;
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
		
		parts.addAll(getCpuWaterblocks());
		
		parts.addAll(getGpuWaterblocks());

		parts.addAll(getRadiators());

		parts.addAll(getTubing());

		parts.addAll(getReservoir());

		parts.addAll(getPump());
	
		parts.addAll(getFittings());

		parts.addAll(getCoolant());
		
		return parts;
	
	
		
	}

	
	
	
	
	
	
}


