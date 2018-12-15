
public class Reservoir extends Part{
	String combo; 
	String partName;

	public Reservoir(String name, String combo) {
		this.partName = name; 	
		this.combo = combo; 

		}
	public String getName() {
		return partName;
	}

	public String getCombo() {
		return combo;
	}
	public String toString() {
		return this.partName;
	}
}
