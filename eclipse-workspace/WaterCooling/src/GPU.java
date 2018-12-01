
public class GPU extends Part{
	String model;
	String partName;
	public GPU(String name, String model) {
		this.model = model; 
		this.partName = name; 
	}

	public String toString() {
		return this.partName;
	}

	
}
