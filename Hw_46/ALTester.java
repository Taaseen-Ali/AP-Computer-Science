// Taaseen Ali
// APCS1 pd1
// HW46 -- Al<B> Sorted!. 
// 2017-12-4

import java.util.ArrayList;

public class ALTester{
    public static void main(String args[]){
	ArrayList<Comparable> ls = new ArrayList<Comparable>(); //create new ArrayList that stores Comparable objects 

	for(int i = 0; i<23; i++)
	    ls.add((int)(Math.random()*100)); //populate it with 23 random Integers
	System.out.println(ls); //print results 
    }
}
