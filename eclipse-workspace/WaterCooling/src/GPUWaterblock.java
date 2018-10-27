
public class GPUWaterblock extends Part{
	String model;
	String metal;
	
	public GPUWaterblock(String model, String metal, String name) {
		partName = name; 
		this.model = model;
		this.metal = metal; 
	}

	public String getName() {
		return partName; 
	}
	public String getModel() {
		return model;
	}
	public String getMetal() {
		return metal;
	}
	
}
