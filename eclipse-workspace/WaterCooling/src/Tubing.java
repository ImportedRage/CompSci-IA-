
public class Tubing extends Part{
	String bendable; 
	String diameter; 
	
	public Tubing(String name, String bendable, String diameter) {
		partName = name; 
		this.bendable = bendable; 
		this.diameter = diameter; 
		
	}

	public String getName() {
		return partName; 
	}
	public String getBendable() {
		return bendable;
	}
	public String getDiameter() {
		return diameter;
	}

}
