/*****************************************************
 * Taaseen Ali
 * APCS1 pd01
 * HW38 -- Swapper
 * 2017-11-21
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
	for(String[] subArray:arr){
	    for(String s: subArray){
		System.out.print(s);
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
	
	System.out.println("Specify the 1st Ycor: ");
	int a = Keyboard.readInt();

	
	System.out.println("Specify the 1st Xcor: ");
	int b = Keyboard.readInt();
	
	System.out.println("Specify the 2nd Ycor: ");
	int c = Keyboard.readInt();
	
	System.out.println("Specify the 2nd Xcor: ");
	int d = Keyboard.readInt();
	
	s.swap(a,b,c,d);
	s.print();
    }
}
