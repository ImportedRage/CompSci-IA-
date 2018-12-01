
public class Radiator extends Part{
	String maxfancount;
	String metal;
	String partName;

	
	public Radiator(String name, String maxfancount, String metal) {
		this.partName = name;
		this.maxfancount = maxfancount; 
		this.metal = metal; 
}

	public String getName() {
		return partName;
	}

	public String getMaxFanCount() {
		return maxfancount;
	}

	public String getMetal() {
		return metal;
	}
	
	public String toString() {
		return this.partName;
	}

	
}