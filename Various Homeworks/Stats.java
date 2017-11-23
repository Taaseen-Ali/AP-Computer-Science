public class Stats{
    public static int gcd(int a, int b){
		int div=1, ans = 1, min, max;
		max = Math.max(a,b);
		min = Math.min(a,b);
		while(div < min){
			if(max%div == 0 && min%div == 0){//if the remainder of both nums is 0 when
				ans = div;					 //dividing by div, make the gcd found so far
			}								 // to be the current value of div
			div++;							 //increment div by one;
		}
		return ans;
    }

    public static int gcdER( int a, int b ){
		if(Math.max(a,b)%Math.min(a,b)==0){  //if the remainder of the to nums is 0
			return Math.min(a,b);			 //return the smaller of the two
		}
		else{
			return gcdER(Math.min(a,b),Math.max(a,b)%Math.min(a,b)); //if the remainder isn't 0
		}															 //call the function w/ the difference
																	 //and the min
    }

    public static int gcdEW( int a, int b){
		int diff, min, max;
		max = Math.max(a,b);
		min = Math.min(a,b);
		diff = max % min;
		while(diff != 0){
			max = min; 		//see the alg description
			min = diff;		//bascally the same thing but in code
			diff = max%min;
		}
	
		return min;
    }
		     

    public static void main( String[] args){
		
		System.out.println("Brute force");
		System.out.println(gcd(12,16));
		System.out.println("Euclidean algorithm recursively");
		System.out.println(gcdER(12,16));
		System.out.println("Euclidean algorithm w/ while loop");
		System.out.println(gcdEW(12,16));
		
		System.out.println("=============================");
		System.out.println("Brute force");
		System.out.println(gcd(411,685)); //should return 137
		System.out.println("Euclidean algorithm recursively");
		System.out.println(gcdER(411,685));
		System.out.println("Euclidean algorithm w/ while loop");
		System.out.println(gcdEW(411,685));
    }
	
}