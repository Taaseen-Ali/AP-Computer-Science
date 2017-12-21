// Taaseen Ali
// APCS1 pd1
// HW57 -- How deep does the rabbit hole go?
// 2017-12-20

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

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) {
	matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size() 
    {
	return matrix[1].length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty() 
    {
	for(Object[] row: matrix){ //if everything is null, return true, else return false
	    for(Object o: row){
		if(!(o==null)) return false;
	    }
	}

	return true;
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {
	Object temp = get(r,c);
	matrix[r][c] = newVal;
	return temp;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString()
    {
	String ret = "";
	for(int i=0; i<size(); i++){
	    ret += "| ";
	    for(Object o: matrix[i]){
		ret += o + " ";
	    }
	    ret += "|\n";
	}
	return ret;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide ) 
    {
	Matrix m  = (Matrix) rightSide;
	if(!(m.size()==this.size())) return false;

	for(int i=0; i<size(); i++){
	    for(int k=0; k<size();k++){
		if(m.get(i,k) != this.get(i,k)) return false; //if any elements don't match return false else return true
	    }
	}
	return true;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	for(int i=0; i<matrix[c1].length; i++){
	    set(i, c1-1, set(i, c2-1, get(i,c1-1))); //for each element in a row, switch it with its corresponding element in the other column
	}
	      
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	for(int i=0; i<size(); i++){
	    set(r1-1, i, set(r2-1, i, get(r1-1, i))); //same logic as swapColumn
	}
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	System.out.println("Creating new Matrix m:");
	Matrix m = new Matrix(10);
	System.out.println(m);
	System.out.print("Is m empty? ");
	System.out.println(m.isEmpty());
	System.out.println();
	System.out.println("Populating matrix m ");
	System.out.println();
	for(int i=0; i<m.size(); i++){
	    for(int k=0; k<m.size(); k++){
		m.set(i,k,i);
	    }
	}
   
	System.out.println(m);
	System.out.print("Is matrix empty? ");
	System.out.println(m.isEmpty());

	System.out.println("Swapping rows 3&4:");
	System.out.println();
	
	m.swapRows(3,4);
	System.out.println(m);

	System.out.println("=================================");
	
	System.out.println("Creating new Matrix p:");
	Matrix p = new Matrix(10);
	System.out.println(p);
	System.out.print("Is matrix empty? ");
	System.out.println(p.isEmpty());
	System.out.println();
	System.out.println("Populating matrix p ");
	System.out.println();
	for(int i=0; i<p.size(); i++){
	    for(int k=0; k<p.size(); k++){
		p.set(i,k,k);
	    }
	}
   
	System.out.println(p);
	System.out.print("Is matrix empty? ");
	System.out.println(p.isEmpty());

	System.out.println("Swapping columns 5&9:");
	System.out.println();
	
	p.swapColumns(5,9);
	System.out.println(p);
	
	System.out.println("=================================");
	System.out.print("Are m and p equal? ");
	System.out.println(m.equals(p));

       
    }

}//end class Matrix
