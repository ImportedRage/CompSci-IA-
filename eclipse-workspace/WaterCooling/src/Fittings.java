
public class Fittings extends Part{

String diameter;
String partName;



	
	public Fittings(String name, String diameter) {
		this.partName = name; 
		this.diameter = diameter; 
	}
	public String getName() {
		return partName; 
	}
	public String getDiameter() {
		return diameter;
	
	}
	
	public String toString() {
		return this.partName;
	}

	
}
