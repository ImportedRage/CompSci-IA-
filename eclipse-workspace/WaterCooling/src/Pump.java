
public class Pump extends Part { 
	String type;
	String brand;
	
	public Pump(String name, String type, String brand) {
		partName = name; 
		this.type = type; 
		this.brand = brand; 
	
	
	}
	
	public String getName() {
		return partName; 
	}
	public String getType() {
		return type;
	}
	public String getBrand() {
		return brand;
	}

}
