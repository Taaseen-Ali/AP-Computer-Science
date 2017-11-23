//Taaseen Ali
//APCS1 pd1
//HW16--Get It While You Can
//2017-10-15

public class Driver
{
  public static void main( String[] args )
  {
	int x = 100;
    int y = 200;
    int numMatches = 0, counter = 0;

    //build Objects from blueprint specified by class Coin

    //test default constructor
   
    Coin mine = new Coin();

    //test 1st overloaded constructor
    Coin yours = new Coin( "quarter" );

    //test 2nd overloaded constructor
    Coin wayne = new Coin( "dollar", "heads" );

    //test toString() methods of each Coin
    System.out.println("mine: " + mine);
    System.out.println("yours: " + yours);
    System.out.println("wayne: " + wayne);

    //flip the coins until either coin has landed on heads x times
    while(mine.headsCtr<x || yours.headsCtr<x){
		mine.flip();
		yours.flip();
		System.out.println(mine + " heads has showed up " + mine.headsCtr + " times");
		System.out.println(yours + " heads has showed up " + yours.headsCtr + " times");
	}
	
	//flip the coins until there have been y matches between the two coins
	while(numMatches<y){
		mine.flip();
		yours.flip();
		if(mine.equals(yours)) numMatches++;
		System.out.println(mine + " " + numMatches + " matches");
		System.out.println(yours + " " + numMatches + " matches");
	}
	
	//reset numMatches
	numMatches = 0;

	//flip the ocins until there have been both over 13000 matches and
	//the number of matches is divisible by 2001
	while(!(numMatches>13000 && numMatches % 2001==0)){
		mine.flip();
		yours.flip();
		counter++;
		if(mine.equals(yours)) numMatches++;
		System.out.println("counter: " + counter); //counter keeps track of number of flips
		System.out.println("Matches: " + numMatches);
		
	}
	
    //test equals() method
    if ( yours.equals(wayne) ) 
	    System.out.println( "Matchee matchee!" );
    else
	    System.out.println( "No match. Firestarter you can not be." );


  }//end main()

}//end class