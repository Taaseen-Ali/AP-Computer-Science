//Taaseen Ali
//APCS1 pd1
//HW21--Karmacomma
//2017-10-23
public class Commafier{
	public static String commafyR(int i){
		String num = Integer.toString(i);
		if(i>999){
			return commafyR(i/1000)+ "," + num.substring(num.length()-3);
		}
		
		return num;
	}
	
	
	public static String commafyF(int i){
		String retStr = "";
		String num = Integer.toString(i);
		for(int k=num.length(); k>0; k--){
			retStr = num.substring(k-1, k) + retStr;
			if(((num.length()-k)%3)==2){
				retStr = "," + retStr;
			}
		}
		return retStr;
	}
	
			
			
			
	public static void main(String args[]){
		for(String a:args){
			int n = Integer.parseInt(a);
			System.out.println(commafyR(n));
			System.out.println(commafyF(n));
		}
		
		/*
		System.out.println("===========================");
		System.out.println("Recursive Implementation Tests");
		System.out.println("===========================");
		System.out.println(commafyR(1));
		System.out.println(commafyR(12));
		System.out.println(commafyR(123));
		System.out.println(commafyR(1234));
		System.out.println(commafyR(999));
		System.out.println(commafyR(9999));
		System.out.println(commafyR(99999));
		System.out.println(commafyR(48712827));
		
		
		System.out.println("===========================");
		System.out.println("Iterative Implementation Tests");
		System.out.println("===========================");
		System.out.println(commafyF(1));
		System.out.println(commafyF(12));
		System.out.println(commafyF(123));
		System.out.println(commafyF(1234));
		System.out.println(commafyF(999));
		System.out.println(commafyF(9999));
		System.out.println(commafyF(99999));
		System.out.println(commafyF(48712827));
		
		*/
		
	}
}
	
	