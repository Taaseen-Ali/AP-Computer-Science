//Taaseen Ali
//APCS1 pd1
//HW07-- On the Origins of a BigSib
//2017-09-26   

public class BigSib{
    private String helloMsg;
	public BigSib(){
		helloMsg = "hello";
	}
	public BigSib(String msg){
		helloMsg = msg;
	}
	
    public void setHelloMsg(String msg){
		helloMsg = msg;
    }
    
    public String greet(String name){
		return helloMsg + " " + name;
    }
}
