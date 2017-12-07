// Taaseen Ali
// APCS1 pd1
// HW47 -- Ascending
// 2017-12-5m

import java.util.ArrayList;

public class OrderedArrayList{
    private ArrayList<Comparable> data = new ArrayList<Comparable>();

    public void add(Comparable c){
	for(int i=0; i<data.size(); i++){       //for each meaningful element
	    if(data.get(i).compareTo(c) >= 0){  //if c is less than the element being compared
		data.add(i, c);                 //add c before the element that is is being compared to
		return;                         //and exit the function
	    }
	}

	data.add(c);                            //else add it to the end of the ArrayList
    }

    public Comparable get(int i){
	return data.get(i);             //use ArrayList implementation of get
    }

    public Comparable remove(int i){
	return data.remove(i);          //use ArrayList implementation of remove
    }

    public int size(){
	return data.size();             //use ArrayList implementation of size
    }

    public String toString(){
	return data.toString();           //use ArrayList implementation of toString
    }

    public static void main(String args[]){
	OrderedArrayList oal = new OrderedArrayList(); //create new ordered list

	for(int i=0; i<100; i++){
	    oal.add((int) (Math.random()*1000)+ -500); //adding 100 ints to OrderedArray between -500 and 499
	}
	
	System.out.println(oal);
	
	for(int i=0; i<50; i++){
	    oal.remove((int) (Math.random()*50));     //removing 50 of these items to see if invariant is maintained
	}

	System.out.println(oal);
	
    }
}
