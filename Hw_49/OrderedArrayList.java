// Taaseen Ali
// APCS1 pd1
// HW49 -- Halving the Halves
// 2017-12-8

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

    public void addBin(Comparable c){
	int l=0,r=data.size()-1;
	int m = l + (r-l)/2;;
	Comparable item;
	while (l <= r)
	    {
		m = l + (r-l)/2;
		item = data.get(m);
		// Check if x is present at mid
		if (item.compareTo(c)==0) 
		    break;  
 
		// If x greater, ignore left half  
		if (item.compareTo(c)>0) 
		    l = m + 1; 
 
		// If x is smaller, ignore right half 
		else
		    r = m - 1; 
	    }
	data.add(m, c);
	
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
	    oal.addBin((int) (Math.random()*1000)); //adding 100 ints to OrderedArray between 1000 and 0
	}

	System.out.println(oal);
	for(int i=0; i<50; i++){
	    oal.remove((int) (Math.random()*50));     //removing 50 of these items to see if invariant is maintained
	}

	System.out.println(oal);
	
    }
}
