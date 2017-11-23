//Taaseen Ali
//APCS1 pd1
//HW15-- Wayne's World
//2017-10-11

public class Coin{
    private double value, bias;
    private String upFace;
    public String name;
    public int flipCtr, headsCtr, tailsCtr;
   
	//Default constructor
    public Coin(){
		setBias(.5);
		setName("Default");
		setUpFace("heads");
    }
	
	//Constructor which sets denomination to the name of the coin
	public Coin(String denomination){
		this();
		name = denomination;
	}
	
	//Constructor which sets denomination to the name of the coin and initializes
	//the coin with an upFace of startingFace
	public Coin(String denomination, String startingFace){
		this(denomination);
		setUpFace(startingFace);
	}

	//"flips" the coin based on the psuedorandom output of Math.random()
    public String flip(){
		flipCtr++;
		
		if(Math.random() < bias){
			setUpFace("heads");
			headsCtr++;
		}
		else{
			setUpFace("tails");
			tailsCtr++;
		}
		
		return upFace;
    }
	
	//changes the probability for which the coin will land on heads after calling flip()
    public void setBias(double newBias){
		bias = newBias;
    }

    //sets the upFace
	public void setUpFace(String face){
		upFace = face;
    }
	
    public void setName(String newName){
		name = newName;
    }
	
	//appropriately assigns value a double value based on the coins name
	public double assignValue(){
		if(name.equals("penny")) value = .01;
		else if(name.equals("nickel")) value = .05;
		else if(name.equals("dime")) value = .1;
		else if(name.equals("quarter")) value = .25;
		else if(name.equals("dollar")) value = 1.0;
		else value = 0;
		
		return value;
	}
	
	public String toString(){
		return name + ": " + upFace;
	}
	
	//coins are defined to be equal when their upFaces are identical
	public boolean equals(Coin c){
		return upFace.equals(c.upFace);
	}
	
	/*
	public static void main(String args[]){
		Coin mine = new Coin();
		Coin jacks = new Coin("penny");
		Coin toms = new Coin("nickel", "tails");
		
		System.out.println("Testing constructors...");
		
		System.out.println(mine);
		System.out.println(jacks);
		System.out.println(toms);

		System.out.println("Flipping coin a bunch of times w/ bias set to 0.5 ");
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		System.out.println("Flipping coin a bunch of times w/ bias set to 1.0 ");
		toms.setBias(1.0);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		
		System.out.println("Flipping coin a bunch of times w/ bias set to 0.0");
		toms.setBias(0);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		
		System.out.println("Flipping coin a bunch of times w/ bias set to .3 ");
		toms.setBias(.3);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		toms.flip();
		System.out.println(toms);
		
		
		System.out.println("trying out the assign value thing");
		toms.assignValue();
		System.out.println(toms);
		System.out.println(toms.value);
		//k im goin to sleep

		System.out.println("equal or not equal");
		
		System.out.println("tom: " + toms);
		System.out.println("jack: " + jacks);
		System.out.println(toms.equals(jacks));
	}
	*/
	
}
