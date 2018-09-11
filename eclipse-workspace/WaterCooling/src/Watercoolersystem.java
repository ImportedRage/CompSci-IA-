import java.util.ArrayList;

public class Watercoolersystem {

	
	CPU cpu; 
	GPU gpu;
	GPUWaterblock gwb; 
	CPUWaterblock cwb; 
	Radiator rad; 
	Tubing tub; 
	Reservoir res; 
	Pump pump; 
	Fittings fit; 
	Coolant cool; 
	Case c4; 
	
	ArrayList<String> errors;
	ArrayList<String> advice;
	
	
	public Watercoolersystem(CPU cpu, GPU gpu, Case c4, CPUWaterblock cwb, GPUWaterblock gwb, Radiator rad, Tubing tub, Reservoir res, Pump pump, Fittings fit, Coolant cool) {  
		this.cpu = cpu; 
		this.gpu = gpu; 
		this.c4 = c4;
		this.cwb = cwb; 
		this.gwb = gwb; 
		this.rad = rad; 
		this.tub = tub; 
		this.res = res;
		this.pump = pump; 
		this.fit = fit; 
		this.cool = cool;
	}
	
	public boolean uniformMetals() {
		String m1 = this.cwb.metal;
		String m2 = this.gwb.metal; 
		String m3 = this.rad.metal;
		return m1.equals(m2) && m2.equals(m3);
		
	}
	
	public void check() {
		errors = new ArrayList<String>();
		advice = new ArrayList<String>();    
		
		if(this.cwb.socket != this.cpu.socket) {
			errors.add("The currently selected CPU Waterblock is incompatible with your current CPU Model."
					+ " Please select another CPU Waterblock."); 
		}
		
		if(this.gwb.model != this.gpu.model) {
			errors.add("The currently selected GPU Waterblock is incompatible with your current GPU Model."
					+ "Please select another GPU Waterblock.");
		}
		
		if(this.tub.bendable == false) {
			advice.add("The currently selected Tubing does not support heat-treatment to enable bendability,"
					+ "the use of angled fittings is required in your currently selected water-cooling system.");
		} 
		
		if(this.rad.maxfancount != this.c4.maxfancount) {
			advice.add("Do ensure that your selected radiator can be fit into your PC case. "
					+ "This can be done by simply checking the fan size,counts of your PC case, "
					+ "the fan count of the radiator should correspond with the number of fans and fan sizes of your PC case."); 
		}
		
		if(this.res.combo == false) {
			advice.add("The currently selected reservoir does not contain a pump unit,"
					+ "you would have to purchase an additional pumo unit for your system to function properly.");
		}
		
		if(this.tub.diameter != this.fit.diameter) {
			advice.add("Do ensure that you have the required number of fittings for your system. "
					+ "Each component generally requires 2 - 3 fittings depending on the configuration. Also ensure that"
					+ "your fitting corrosponds with your tubing diameter to ensure compatibility.");
		}
		
		if(this.cool.edible == true) {
			advice.add("The currently selected coolant does not contain some form of biocide/silver coil and will require biocide/silver coil"
					+ "to be incorporated into the coolant to deter bacterial grwoth.");

		}
		
		if(!uniformMetals() ) {
			advice.add("The current selection of radiators, CPU waterblock and GPU waterblock(s) have different "
					+ "set(s) of metals, to ensure system longevity, we recommend keeping all metals uniform to prevent metal corrosion.");
		} 
		
		
	}
	
	public ArrayList<String> getAdvice() {
		return this.advice;
	}
	
	public ArrayList<String> getErrors() {
		return this.errors;
	}
	
	
	
}

