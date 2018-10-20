
public class GPUWaterblock {
	String name; 
	String model;
	String metal;
	
	public GPUWaterblock(String model, String metal, String name) {
		this.name = name; 
		this.model = model;
		this.metal = metal; 
	}

	public String getName() {
		return name; 
	}
	public String getModel() {
		return model;
	}
	public String getMetal() {
		return metal;
	}
	public String toString() {
		
		return name;
	}

}
