/*****************************************************
 * class Slots
 * simulates a slot machine in your very own terminal
 * Taaseen Ali
 * APCS1 pd01
 * HW37 -- Rational
 * 2017-11-20
 *****************************************************/
public class Rational{
    protected int p,q;
    protected double num;

    public Rational(){
	p=0;
	q=1;
	num=p/q;
    }
    
    public Rational(int a, int b){
	if(b==0){
	    p=0;
	    q=1;
	    System.out.println("Divide by 0 no bueno");
	}

	else{
	    p=a;
	    q=b;
	}
	num = (double)p/q;
    }
    
    public static int gcdER( int a, int b ){
	if(Math.max(a,b)%Math.min(a,b)==0){
	    return Math.min(a,b);
	}
	else{
	    return gcdER(Math.min(a,b),Math.max(a,b)%Math.min(a,b));
	}
    }
  	
    public String toString(){
       	return "("+ p + "/" + q + ")";
    }

    public double floatValue(){
	return num;
    }

    public void multiply(Rational n){
	p = n.p*p;
	q = n.q*q;
	num = (double)p/q;
    }
			   
    
    public void divide(Rational n){
	p = n.q*p;
	q = n.p*q;
	num = (double)p/q;
    }

    public void add(Rational n){
	p = p*n.q + n.p*q;
	q = q*n.q;
    }

    public void subtract(Rational n){
	p = p*n.q - n.p*q;
	q = q*n.q;
    }

    public int gcd(){
	return gcdER(p,q);
    }

    public void reduce(){
	p = p/gcd();
	q = q/gcd();
    }

    public int compareTo(Rational n){
	if(n.floatValue() == this.floatValue()){
	    return 0;
	}


	else if(n.floatValue() > this.floatValue()){
	    return -1;
	}

	return 1;
    }

    public static void main(String args[]){
	Rational a = new Rational(1,2); //create new rational number
	Rational b = new Rational(2,3); //create new rational number

	System.out.print("#########################");
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());
	System.out.println();           
	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	
	System.out.print("#########################");
	a.multiply(b);
	System.out.println(a + "*" + b + ":");
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());
	System.out.println(a.floatValue());
	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	
	a.divide(b);
	System.out.println();
	System.out.print("#########################");
	System.out.println(a + "/" + b + ":");
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());
 	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	System.out.println("######################");

 	
	Rational r = new Rational(2,3); //Stores the rational number 2/3

	Rational s = new Rational(1,2); //Stores the rational number 1/2

	Rational t = new Rational(4,18); //Stores the rational number 4/18
	
       
	r.add(s);  //Adds r to s, changes r to 7/6.  s remains 1/2 
	System.out.println(r);
	System.out.println();
	System.out.print("#########################");
	System.out.println(r + "+" + s + ":");
	System.out.print("Current value of r: ");
	System.out.println(r.floatValue());
 	System.out.print("Current value of s: ");
	System.out.println(s.floatValue());
	System.out.println("######################");

       
	r.subtract(s); 
	System.out.println(r);
	System.out.println();
	System.out.print("#########################");
	System.out.println(r + "-" + s + ":");
	System.out.print("Current value of r: ");
	System.out.println(r.floatValue());
 	System.out.print("Current value of s: ");
	System.out.println(s.floatValue());
	System.out.println("######################");


	System.out.println(a.compareTo(s));
	System.out.println(r.compareTo(b));
	t.reduce();
	System.out.println(t); //t should be 2/9
	
    }
}
