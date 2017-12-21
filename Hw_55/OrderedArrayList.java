// Taaseen Ali
// APCS1 pd1
// HW55 -- Never Fear Big Oh is here!
// 2017-12-15

import java.util.ArrayList;

public class OrderedArrayList{
    private ArrayList<Comparable> data = new ArrayList<Comparable>();
    
    /******************************************************************************
    //(For strictly number of iterations in this meth and not calls to other meths)
    //Best case: c is smaller than smallest element in data  --> 1 iteration
    //Worst case: c is latgerr thant the largest element in data --> O(n)
    //            This would necessitate the for loop to iterate thtough every element
    //            in data before returning. (n total iterations)'
    //
    //(For total number of iterations including those done by meths called withn this
    //meth)
    //Best/worst case: --> O(n)
    //                For every element that you add, you must iterate from 0 to the
    //                index of the first element greeater than c. YOu must then call
    //                add(i,c) which necessitates shifting elements from i to the end
    //                to the right by one index. You have thus iterated through the 
    //                entire array by the end of the method
    ******************************************************************************/
    public void add(Comparable c){
	for(int i=0; i<data.size(); i++){       //for each meaningful element
	    if(data.get(i).compareTo(c) >= 0){  //if c is less than the element being compared
		data.add(i, c);                 //add c before the element that is is being compared to
		return;                         //and exit the function
	    }
	}

	data.add(c);                            //else add it to the end of the ArrayList
    }

    /******************************************************************************
    //Best case: the value of c lies in the middle of the data set --> 1 iteration
    //           The first conditional would immediatley trigger. 
    //Worst case: C is either the largeest/ smallest elemenet in data --> O(lg(n))
    //           This would require that the list halfed repeatedy until it is
    //           narrowed down to either the leftmost or rightmost elements. This
    //           would equate to a run time proportional to lg(n).
    ******************************************************************************/
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

    /******************************************************************************
    //Best/ worst case: This function only returns the element at idex i, which can
    //                  be done in conatant time --> O(1)
    ******************************************************************************/
    public Comparable get(int i){
	return data.get(i);             //use ArrayList implementation of get
    }

    /******************************************************************************
    //Best case: i is the last index of arraylist --> 1 iteration 
    //           This would not require any extra "left justification" steps. 
    //Worst case: i = 0 --> O(n)
    //           This would mean that the element at i is removed and that every
    //           other element is shifted left, requiring n-1 total iterations
    ******************************************************************************/
    public Comparable remove(int i){
	return data.remove(i);          //use ArrayList implementation of remove
    }

    /******************************************************************************
    //Best/ worst case: This function returns the value of an instance var, which
    //                  can be done in conatant time --> O(1)
    ******************************************************************************/    
    public int size(){
	return data.size();             //use ArrayList implementation of size
    }


    /******************************************************************************
    //Best/ worst case: This function returns the value of an instance var, which
    //                  can be done in conatant time --> O(1)
    ******************************************************************************/        
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
