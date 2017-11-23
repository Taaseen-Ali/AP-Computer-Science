//Taaseen Ali
//APCS1 pd1
//HW17--Do I repeat myself?
//2017-10-17

public class Repeater{
	
	//While loop implementation
	public static String fenceW(int numPosts){
		int posts = numPosts;
		String fence = "";
		
		if(numPosts == 0) return "";
		//while theres more than one post to be put up
		//"insert" a post and decrement the number of remaining posts
		while(posts > 1){
			fence += "|--";
			posts--;
		}
		
		//put in the last post
		return fence + "|";
	}

	//Recursive implementation
	public static String fenceR(int numPosts){
		//if the function is called with numPosts equal to one
		//put in the last post
		
		if(numPosts == 0) return "";
		if(numPosts == 1){
			return "|";
		}
		
		/*
		if the function is called with more than one post to put in
		put in a post and the thingy in between the post and call the
		again with one less post to put in
		*/
		else{
			return "|--" + fenceR(numPosts-1);
		}
	}
	
	public static void main(String args[]){
		//fencing
		//En garde, prêt, allez!
		System.out.println(fenceW(7));
		System.out.println(fenceR(7));
		
		System.out.println(fenceW(6));
		System.out.println(fenceR(6));
		
		System.out.println(fenceW(5));
		System.out.println(fenceR(5));
		
		System.out.println(fenceW(3));
		System.out.println(fenceR(19));
		
		System.out.println(fenceW(1));
		System.out.println(fenceR(1));
		
		System.out.println(fenceW(0));
		System.out.println(fenceR(0));
	}
}