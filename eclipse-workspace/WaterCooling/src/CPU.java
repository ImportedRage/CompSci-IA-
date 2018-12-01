
public class CPU extends Part{
	String socket;
	String partName;


	public CPU(String name, String socket) {
		this.socket = socket; 
		this.partName = name; 
	}
	
	public String toString() {
		return this.partName;
	}

	


}
