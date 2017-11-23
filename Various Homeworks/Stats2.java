//Taaseen Ali
//APCS1 pd1
//HW13--May ah Hahv S’maur, Please? 
//2017-10-9

public class Stats {
	
	//returns the mean of two ints, a and b
	public static int mean(int a, int b) {
		return (int) (a + b) / 2;
	}

	//returns the mean of two doubles, a and b
	public static double mean(double a, double b) {
		return (a + b) / 2;
	}

	//returns the greater of two ints, a and b
	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	//returns the greater of two doubles, a and b
	public static double max(double a, double b) {
		return (a > b) ? a : b;
	}

	//returns the geometric mean of two ints, a and b
	public static int geoMean(int a, int b) {
		return (int) Math.sqrt(a * b);
	}

	//returns the geometric mean of two doubles, a and b
	public static double geoMean(double a, double b){
		return Math.sqrt(a*b);
	}
	
	//returns the greater of three ints, a, b and c
	public static int max(int a, int b, int c){
		return max(max(a,b),c);
	}
	
	//returns the greater of three doubles, a, b and c
	public static double max(double a, double b, double c){
		return max(max(a,b),c);
	}
	
	//returns the geometric mean of three ints, a, b and c
	public static int geoMean(int a, int b, int c){
		return (int) Math.round(Math.pow((a*b*c), 1.0/3.0));
	}
		
	//returns the geometric mean of three doubles, a, b and c
	public static double geoMean(double a, double b, double c){
		return Math.pow((a*b*c), 1.0/3.0);
	}
	
}

