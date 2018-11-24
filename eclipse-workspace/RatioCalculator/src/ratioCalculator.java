import java.util.Scanner;

public class ratioCalculator {


	public static String cal(String in) {
		
		
		String copyin = ""; 
		
		for(int i = 0; i < in.length(); i++) {
			if(in.charAt(i) != ' ') {
				copyin = copyin + in.charAt(i);	
			}
		}
		
		String[] arr = copyin.split(",");
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		int width = Integer.parseInt(arr[2]);
		int height = Integer.parseInt(arr[3]);
		
		double c1; 
		c1 = (double) x / 1220.0; 
		String result1 = "";
		result1 = c1 + "* width";
		
		double c2; 
		c2 = (double) y/800.0; 
		String result2 = "";
		result2 = c2 + "* height";
		
		double c3; 
		c3 = (double) width/1220.0; 
		String result3 = "";
		result3 = c3 + "* width";
		
		double c4; 
		c4 = (double) height/800.0; 
		String result4 = "";
		result4 = c4 + "* height";
		
		return "\n(int) Math.round(" + result1 + "), \n" +
				"(int) Math.round(" + result2 + "), \n" + 
				"(int) Math.round(" + result3 + "), \n" + 
				"(int) Math.round(" + result4 + ") \n";
		
		
	}
	
	
	
	public static void main(String[] args) {
		while (true) {
			Scanner s = new Scanner(System.in); 
			String in = s.nextLine();
			System.out.println(cal(in));
		}

	}

}
