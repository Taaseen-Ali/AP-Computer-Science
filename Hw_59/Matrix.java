// Taaseen Ali
// APCS1 pd1
// HW59 -- Make the matrix work for you.
// 2017-12-21

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] _matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix()
    {
	_matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	_matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return _matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return _matrix[r-1][c-1];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty( int r, int c ) 
    {
	return get(r,c) == null;

    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object retVal = _matrix[r-1][c-1];
	_matrix[r-1][c-1] = newVal;
	return retVal;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {
	String foo = "";
	for( int i =0; i < size(); i++ ) {
	    foo += "| ";
	    for( int j=0; j < size(); j++ ) {
		foo += _matrix[i][j] + " "; //get(i+1,j+1)
	    }
	    foo += "|\n";
	}
	
	return foo;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	boolean foo = false;

	if (this == rightSide) foo = true;  
	// checks for aliases  ex. m1.equals(m1) is true

	else if ( rightSide instanceof Matrix 
		  && size() == ( (Matrix)rightSide).size() ) {
	    Matrix r = (Matrix) rightSide; //for cleaner code later
	    foo = true;
	    outer:
	    for( int i = 0; i < size(); i++ ) {
		for( int j = 0; j < size(); j++ ) {
		    if ( !isEmpty(i,j) && ( !get(i,j).equals(r.get(i,j) ) ) ) {
			foo = false;
			break outer;
		    }
		    else if ( !( isEmpty(i,j) && r.isEmpty(i,j) ) ) {
			foo = false;
			break outer;
		    }
		}
	    }
	}
	return foo;
    }//end equals()



    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	c1 = c1-1;
	c2 = c2-1;
    
	for( int i = 0; i < size(); i++ ) {
	    set( i, c1, set( i, c2, get(i,c1) ) );
	}
    }//O(n) b/c must visit n rows


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	r1 = r1-1;
	r2 = r2-2;
	Object [] temp = _matrix[r1];
	_matrix[r1] = _matrix[r2];
	_matrix[r2] = temp; 
    }//O(1)


    //            PHASE 2
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    //returns copy of row r
    public Object[] getRow( int r )
    {
	Object[] ret = new Object[size()]; 
	for(int i=0; i<size(); i++){
	    ret[i] = _matrix[r-1][i];  //copy via iteration and return ret
	}
	return ret;
    }//O(?)

    //replaces row r with 1D array newRow
    //returns old row
    public Object [] setRow( int r, Object[] newRow )
    {
	Object[] ret = getRow(r);       //since a 2d array is sorta like single 1d array with refereneces to other 1d arrays
	_matrix[r-1] = newRow;          // just change one of the references
	return ret;
    }//O(?)

    public Object [] setCol( int c, Object[] newCol )
    {
	Object[] ret = new Object[size()];
	for(int i=1; i<=size(); i++){
	    ret[i-1] = this.set(i,c, newCol[i-1]); 
	}

	return ret;
    }//O(?)

    //M[i,j] -> M[j,i] for all i,j
    public void transpose()
    {
	Object[][] temp = new Object[size()][size()];
	for(int i=1; i<=size(); i++){
	    for(int k=1; k<=i; k++){
		set(i,k, set(k,i, get(i,k)));
	    }
	}

    }//O(n^2)
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
   
    
    //main method for testing
    public static void main( String[] args ) 
    {
	Matrix m1 = new Matrix(); // 2 x 2
	Matrix m2 = new Matrix(10); // 10 x 10
	System.out.println("m1 size: " + m1.size());
	System.out.println("m2 size: " + m2.size());
	System.out.println("m1 get(1,1) : " + m1.get(1,1));
	System.out.println("m1 isEmpty(1,1) : " + m1.isEmpty(1,1));	

	Matrix x = new Matrix(2); // 2x2
	System.out.println(x);
	x.set(1,1,"how"); 
	x.set(1,2,"now"); 
	x.set(2,1,"bro"); 
	x.set(2,2,"cow"); 
	System.out.println(x);

	Matrix m3 = new Matrix(3); //3x3
	System.out.println(m1);
	System.out.println("=================================");
	System.out.println("=================================");
	System.out.println("Creating new Matrix m:");
	Matrix m = new Matrix(10);
	System.out.println(m);
	System.out.println();
	System.out.println("Populating matrix m ");
	System.out.println();
	for(int i=1; i<m.size()+1; i++){
	    for(int k=1; k<m.size()+1; k++){
		m.set(i,k,i);
	    }
	}
   
	System.out.println(m);
	System.out.println("transposing m");
	System.out.println();
	
	m.transpose();
	System.out.println(m);

	System.out.println("=================================");
	
	System.out.println("Creating new Matrix p:");
	Matrix p = new Matrix(10);
	System.out.println(p);
	System.out.println();
	System.out.println("Populating matrix p ");
	System.out.println();
	for(int i=1; i<p.size()+1; i++){
	    for(int k=1; k<p.size()+1; k++){
		p.set(i,k,k);
	    }
	}
   
	System.out.println(p);
	System.out.println("Getting 1st element of 3rd row of p");

	System.out.println(p.getRow(3)[0]);
	System.out.println("Setting 4th row of p to [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]");
	p.setRow(4, new Object[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1});
	System.out.println(p);

	System.out.println("Setting 4th col of p to [-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]");
	p.setCol(4, new Object[] {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1});
	System.out.println(p);
	System.out.println("=================================");

    }//end main()

}//end class Matrix
