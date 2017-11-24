/*****************************************************
 * Taaseen Ali
 * APCS1 pd01
 * HW39 -- Swapper
 * 2017-11-22
 *****************************************************/

/*****************************************************
This program prompts the user to input an integer between 0 and 3
4 consecutive times in order to attain the corresponding
coordinates to two elements in the two dimension array.
 ****************************************************/


/*****************************************************
Improvements for v2:
-improved user prompts
-improved layout of 2 dimension

 ****************************************************/

import cs1.Keyboard;

public class Swapper{    
    String[][] arr;
    
    public Swapper(){
	arr = new String[4][4];
	for(String[] subArr: arr){
	    for(int i=0; i<subArr.length; i++){
		String s = ((int)(Math.random()*9)) + "";
		subArr[i] = s;
	    }
	}

	System.out.println(arr[0][0]);
    }

    
    public void print(){
	System.out.println("######################");
	System.out.println("   |0|1|2|3| ");
	for(int i=0; i<arr.length; i++){
	    System.out.print("|" + i + "| ");
	    for(int k=0; k<arr[i].length; k++){
		System.out.print(arr[i][k] + " ");
	    }
	    System.out.println();
	}
	System.out.println("######################");	
    }



    public void print(int x1, int y1, int x2, int y2){
	System.out.println("######################");
	System.out.println("   |0|1|2|3| ");
	for(int i=0; i<arr.length; i++){
	    System.out.print("|" + i + "| ");
	    for(int k=0; k<arr[i].length; k++){
		if((k==y1 && i==x1) || (k==y2 && i==x2)){
		    System.out.print("\b");
		    System.out.print("(" + arr[i][k] + ")");}
		else{
		    System.out.print(arr[i][k] + " ");
		}
	    }
	    System.out.println();
	}
	System.out.println("######################");
    }

    
    public void swap(int x1, int y1, int x2, int y2){
	String firstObj = arr[x1][y1];
	arr[x1][y1] = arr[x2][y2];
	arr[x2][y2] = firstObj;
	
    }
	
	    
    public static void main(String args[]){
	Swapper s = new Swapper();

	s.print();
	
	System.out.print("y1:");
	int a = Keyboard.readInt();
    
	System.out.print("x1:");
	int b = Keyboard.readInt();
	
	System.out.print("y2:");
	int c = Keyboard.readInt();
	
	System.out.print("x2:");
	int d = Keyboard.readInt();
	
	s.swap(a,b,c,d);
	s.print(a,b,c,d);
    }
}
