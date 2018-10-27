
public class Radiator extends Part{
	String maxfancount;
	String metal;
	
	public Radiator(String name, String maxfancount, String metal) {
		partName = name;
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
	
	
}