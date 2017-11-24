/*****************************************************
 * Taaseen Ali
 * APCS1 pd01
 * HW39 -- Swapper
 * 2017-11-22
 *****************************************************/

import cs1.Keyboard;

public class Swapper{
    String[][] arr;
    
    public Swapper(){
	arr = new String[4][4];
	for(String[] subArr: arr){
	    for(int i=0; i<subArr.length; i++){
		String s = ((int)(Math.random()*9)) + " ";
		subArr[i] = s;
	    }
	}

	System.out.println(arr[0][0]);
    }

    
    public void print(){
	System.out.println("   |1|2|3|4| ");
	for(int i=0; i<arr.length; i++){
	    System.out.print("|" + i + "| ");
	    for(int k=0; k<arr[i].length; k++){
		System.out.print(arr[i][k]);
	    }
	    System.out.println();
	}
    }
		
    public void swap(int x1, int y1, int x2, int y2){
	String firstObj = arr[x1][y1];
	arr[x1][y1] = arr[x2][y2];
	arr[x2][y2] = firstObj;
	
    }
	
	    
    public static void main(String args[]){
	Swapper s = new Swapper();

	s.print();
	
	System.out.println("Specify the y1: ");
	int a = Keyboard.readInt();

	System.out.println("Specify the x1: ");
	int b = Keyboard.readInt();
	
	System.out.println("Specify the y2: ");
	int c = Keyboard.readInt();
	
	System.out.println("Specify the x2: ");
	int d = Keyboard.readInt();
	
	s.swap(a,b,c,d);
	s.print();
    }
}
