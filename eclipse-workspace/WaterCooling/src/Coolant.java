
public class Coolant extends Part {
	String edible;
	String partName;

	public Coolant(String name, String edible) {
		this.partName = name; 
		this.edible = edible; 
	}
	public String getName() {
		return partName; 
	}
	public String getEdible() {
		return edible;
	}
	
	public String toString() {
		return this.partName;
	}


}
