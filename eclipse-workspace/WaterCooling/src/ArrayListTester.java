import java.util.*;

public class ArrayListTester {

	public static void main(String[] args) {
		ArrayList <Part> PL = new ArrayList <Part>(); 
		CPU testCpu = new CPU("TestCpu", "TestCpu001");
		GPU testGpu = new GPU("TestGpu", "TestGpu002");
		Radiator testRad = new Radiator("TestRadiator", "a LOT of fans", "TestRad003");
		
		PL.add(testCpu);
		PL.add(testGpu);
		PL.add(testRad);
		
	for(int i = 0; i < PL.size(); i++) {
		System.out.println(PL.get(i));
	}
				
		
		
		
		
		
	}

}
