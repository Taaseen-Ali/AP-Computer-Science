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

    public static void main(String args[]){
	Rational a = new Rational(1,2);
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());

	Rational b = new Rational(2,3);
	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	
	System.out.println(a + "*" + b + ":");
	a.multiply(b);
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());
	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	System.out.println();
	
	System.out.println(a + "/" + b + ":");
	a.divide(b);
	System.out.print("Current value of a: ");
	System.out.println(a.floatValue());
	System.out.print("Current value of b: ");
	System.out.println(b.floatValue());
	
    }
}
