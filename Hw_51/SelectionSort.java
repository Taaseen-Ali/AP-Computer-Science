/***************************************
 * class SelectionSort -- implements SelectionSort algorithm
 ***************************************/
// Taaseen Ali
// APCS1 pd1
// HW51 -- Selection
// 2017-12-12
import java.util.ArrayList;

public class SelectionSort 
{
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
	for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
	    randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
	    al.set( i, al.set( randomIndex, al.get(i) ) );
	}
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	for(int k=0; k<data.size(); k++){  //for each element in data
	    Comparable min=data.get(k);    //set the min to one index more than the last sorted element
	    int minIndex=k;                
	    for(int i=k+1; i<data.size(); i++){  //for each element after this element check for equality
		if(data.get(i).compareTo(min) <0){
		    min = data.get(i);
		    minIndex = i;               //store the index of the smallest element encountered
		}
	    }
	    data.set(k, data.set(minIndex, data.get(k)));  //swap the element in position k with this element, rinse and repeat
	}
    }//end selectionSortV


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable>
	selectionSort( ArrayList<Comparable> input ) 
    {
	ArrayList<Comparable> retAr = new ArrayList<Comparable>();
	
	for(Comparable c: input)  //copy the elements from input to retAr
	    retAr.add(c);
	selectionSortV(retAr);   //sort retAr
	return retAr;            //and return it
    }//end selectionSort 


    public static void main( String [] args ) 
    {
	/*===============for VOID methods=============    
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );


	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );

	  ============================================*/

	ArrayList bob = new ArrayList<Character>();
	bob.add("s");
	bob.add("e");
	bob.add("l");
	bob.add("e");
	bob.add("c");
	bob.add("t");
	bob.add("i");
	bob.add("o");
	bob.add("n");
	bob.add("s");
	bob.add("o");
	bob.add("r");
	bob.add("t");
	
	System.out.println( "ArrayList bob before sorting:\n" + bob );
	ArrayList bobSorted = selectionSort( bob );
	System.out.println( "sorted version of ArrayList bob:\n" 
			    + bobSorted );
	System.out.println( "ArrayList bob after sorting:\n" + bob );

	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	ArrayList glenSorted = selectionSort( glen );
	System.out.println( "sorted version of ArrayList glen:\n" 
			    + glenSorted );
	System.out.println( "ArrayList glen after sorting:\n" + glen );

	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	ArrayList cocoSorted = selectionSort( coco );
	System.out.println( "sorted version of ArrayList coco:\n" 
			    + cocoSorted );
	System.out.println( "ArrayList coco after sorting:\n" + coco );
	 
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
