
public class Coolant extends Part {
	String edible;
	public Coolant(String name, String edible) {
		partName = name; 
		this.edible = edible; 
	}
	public String getName() {
		return partName; 
	}
	public String getEdible() {
		return edible;
	}
	

}
