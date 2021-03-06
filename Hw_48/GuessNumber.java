// Taaseen Ali
// APCS1 pd1
// HW48 -- Keep Guessing
// 2017-12-6m

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
	_lo = Math.min(a,b);
	_hi = Math.max(a,b);
	_guessCtr = 1;
	_target = (int) (Math.random()*_hi+_lo);

    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {
	System.out.println("Pick a number from " + _lo + "-" +  _hi);
	int num = Keyboard.readInt();
	if(_target==num)
	    System.out.println("Correct! It took " + _guessCtr + " guesses.");

	else{
	    if(num<_target){
		_lo = num+1;
		System.out.println("To low, try again...");
	    }
	    else if(num>_target){
		_hi = num-1;
		System.out.println("To high, try again...");
	    }
	    _guessCtr++;
	    playRec();
	}
	
	    
    }


    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
	int num= _lo-1;;
	for(; num != _target; _guessCtr++){
	    System.out.println("Pick a number from " + _lo + "-" +  _hi);
	    num = Keyboard.readInt();
	    if(num<_target){
		_lo = num+1;
		System.out.println("To low, try again...");
	    }
	    else if(num>_target){
		_hi = num-1;
		System.out.println("To high, try again...");
	    }

	}

	System.out.println("Correct! It took " + _guessCtr + " guesses.");
		
    }


    //wrapper for playRec/playIter to simplify calling
    public void play() 
    { 
	//use one or the other below:
	playRec();
	//playIter();
    }


    //main method to run it all
    public static void main( String[] args ) 
    {

	//instantiate a new game
	GuessNumber g = new GuessNumber(1,100);

	//start the game
	g.play();

    }//end main

}//end class
