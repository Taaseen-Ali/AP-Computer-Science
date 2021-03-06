/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/
/***************************
Taaseen Ali
APCS1 -- pd1
HW40 -- Array of steel
2017-11-27 M

 ***************************/


public class SuperArray
{

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor �V initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = 10;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String retstr = "";
	for(int i=0; i<_size;i++){
	    retstr += _data[i] + " ";
	}
    return retstr;

    }


    //double capacity of SuperArray
    private void expand()
    {
	int tempData[] = new int[_size*2];
	for(int i=0; i<_size; i++){
	    tempData[i] = _data[i];
	}
	_data = tempData;
	_size = _size*2;

    }


    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int oldVal = _data[index];
	_data[index] = newVal;
	return oldVal;
    }


    //main method for testing
    public static void main( String[] args )
    {

	  SuperArray curtis = new SuperArray();
	  System.out.println( "Printing empty SuperArray curtis..." );
	  System.out.println( curtis );

	  for( int i = 0; i < curtis._data.length; i++ ) {
	  curtis.set( i, i * 2 );
	  }

	  System.out.println("Printing populated SuperArray curtis...");
	  System.out.println(curtis);

	  for( int i = 0; i < 3; i++ ) {
	  curtis.expand();
	  System.out.println("Printing expanded SuperArray curtis...");
	  System.out.println(curtis);

	  }
	  	/*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
    }//end main()


}//end class
