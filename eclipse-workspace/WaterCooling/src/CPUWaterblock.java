
public class CPUWaterblock extends Part{
	String socket; 
	String metal;
	String partName;


	public CPUWaterblock(String socket, String metal, String name) {
		this.socket = socket; 
		this.metal = metal; 
		this.partName = name; 
	}
	
	public String getName() {
		return partName;
	}
	public String getSocket() {
		return socket;
	}
	public String getMetal() {
		return metal; 
	}

	public String toString() {
		return this.partName;
	}


}
	