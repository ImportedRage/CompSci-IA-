
public class GPUWaterblock extends Part{
	String model;
	String metal;
	String partName;
	
	public GPUWaterblock(String name,String model,String metal  ) {
		this.partName = name; 
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
	public String toString() {
		return this.partName;
	}

	
}
