//Taaseen Ali
//APCS1 pd1
//HW20--For the Lulz Love of Strings
//2017-10-19

public class Foresrever{
	public static String fenceF(int posts){
		if(posts < 1) return "";
		String fence = "";
		for(int i=0; i<posts-1; i++){
			fence += "|--";
		}
		fence += "|";
		return fence;
	
	}
	
	public static String reverseF(String word){
		String reversed = "";
		for(int i=word.length(); i>0; i--){
			reversed += word.substring(i-1, i);
		}
		return reversed;
	}
	
	public static String reverseR(String word){
		if (word.length() > 1){
			return reverseR(word.substring(1)) + word.substring(0,1);
		}
		return word;
	}
	public static void main(String args[]){
		System.out.println("=======Tests for fence========");
		System.out.println(fenceF(5));
		System.out.println(fenceF(1));
      	System.out.println(fenceF(-5));
		System.out.println("=======Test for reverseF=========");
		System.out.println(reverseF(""));
		System.out.println(reverseF("brownmykolyk is hard to spell and i hope i spelt it right"));
		System.out.println(reverseF("abcddefgh"));
		System.out.println("=======Test for reverseR=========");
		System.out.println(reverseR("Ding Dong"));
		System.out.println(reverseR(""));
		System.out.println(reverseR("i need sleep"));
    }
}