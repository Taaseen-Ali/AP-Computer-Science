/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Taaseen Ali
 * APCS1 pd01
 * HW26 -- Shmoney
 * 2017-11-07
 *****************************************************/

public class Slots
{

  private static final String[] FRUITS = {
    "lime", "lime", "lime", 
    "lemon", "lemon", "lemon", 
    "cherry", "cherry", "cherry", 
    "orange", "orange", "orange", 
    "grapefruit", "grapefruit", "grapefruit", 
    "tangerine", "tangerine", "tangerine", 
    "ugli", "ugli", "ugli",
    "peach", "peach", "peach"
  };
  
  
  private String[] _fruits; //to be init'd by each instance


  /*=====================================
    Slots() -- default constructor
    pre:  constant array FRUITS exists, has been initialized
    post: mutable array _fruits contains same elements as FRUITS
    =====================================*/
  public Slots()
  {
    //allocate memory for _fruits based on size of FRUITS:
    _fruits = new String[FRUITS.length];
	
	//for each element in FRUITS save a copy of the same element in _fruits
	for(int i=0;i<FRUITS.length;i++){ 
		_fruits[i] = FRUITS[i];
	}
	
  }


  /*=====================================
    String toString() -- overrides inherited toString()
    pre:  
    post: returns String of elements in slots 0 thru 2, separated by tabs
    =====================================*/
  public String toString()
  {
	//return the first three elements with tabs.
    return _fruits[0] + "\t" + _fruits[1] + "\t" + _fruits[2];
  }


  /*=====================================
    void swap(int,int) -- array swap util fxn
    pre:  _fruits array exists
    post: elements at indices i, j are swapped
    =====================================*/
  private void swap( int i, int j )
  {
	//save the ith element
    String firstFruit = _fruits[i];
	//swap the ith element with jth element
	_fruits[i] = _fruits[j];
	//swap the jth element with ith element
	_fruits[j] = firstFruit;
  }


  /*=====================================
    void spinOnce() -- simulate a pull of the slot machine lever
    pre:  _fruits array exists
    post: randomized order of elements in _fruits array
    =====================================*/
  public void spinOnce()
  {
	int slotOne, slotTwo, slotThree;
	//randomizzzeee
	slotOne = (int)(Math.random()*(FRUITS.length-1));
	slotTwo = (int)(Math.random()*(FRUITS.length-1));
	slotThree = (int)(Math.random()*(FRUITS.length-1));
	
	//and swap
	swap(0,slotOne);
	swap(1,slotTwo);
	swap(2,slotThree);
	
  }


  /*=====================================
    boolean jackpot() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    false otherwise
    =====================================*/
  public boolean jackpot()
  {
	//3 limes is a jackpottttt
    return _fruits[0].equals("lime") && _fruits[1].equals("lime") && _fruits[2].equals("lime");
  }


  /*=====================================
    boolean miniWin() -- checks for a winning combo
    pre:  _fruits is existing array
    post: returns true if first 3 slots represent winning combo,
    or if first 3 slots mutually distinct, 
    false otherwise
    =====================================*/
  public boolean miniWin()
  {
	//if any two slots are the same, the statement inside parens is true
	//but is negated
	//so if any two elements are equal, distinct is false
    boolean distinct = !(_fruits[0].equals(_fruits[1]) || _fruits[0].equals(_fruits[2]) || _fruits[1].equals(_fruits[2]));
	return distinct || jackpot();
  }


  //main() method for testing
  public static void main( String[] args )
  {
	//TY TBM OMG IF I DIDNT HAVE THIS I WOULDNT HAVE TIME TO SLEEP TONIGHT
    //usage: move bar below down 1 line at a time to test functionality...
      Slots machine01 = new Slots();
      Slots machine02 = new Slots();

      //test to verify slot machines function indepently
      System.out.println();
      System.out.println( "Machine01 initial state:\t" + machine01 );
      System.out.println( "Machine02 initial state:\t" + machine02 );

      System.out.println( "\nSpinning machine01...\n" );

      machine01.spinOnce();

      System.out.println();
      System.out.println( "Machine01 state:\t" + machine01 );
      System.out.println( "Machine02 state:\t" + machine02 );
      System.out.println();


      //test gamble-until-you-win mechanism

      System.out.println( "Preparing to spin until a mini win! . . ." );
      System.out.println( "------------------------------------" );

      //if you haven't won, spin again until you win!
      while( machine01.miniWin() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "WIN\n" );



      System.out.println( "Preparing to spin until...jackpot! . . ." );
      System.out.println( "------------------------------------" );

      //if you haven't won, spin again until you win!
      while( machine01.jackpot() == false ) {
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "LOSE\n" );
      machine01.spinOnce();
      }

      System.out.println( "====================================" );
      System.out.println( "Your spin..." + "\t" + machine01 );
      System.out.println( "JACKPOT!\n" );
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main

}//end class Slots
