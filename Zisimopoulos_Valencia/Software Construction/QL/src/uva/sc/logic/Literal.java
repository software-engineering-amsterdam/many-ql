package uva.sc.logic;


public class Literal extends Node{
	String str;
	Double d;
	int i;
	boolean bool;
	
	public Literal (String str){
		this.str = str;
	}
	
	public Literal (Double d){
		this.d = d;
	}
	
	public Literal (int i){
		this.i = i;
	}
	
	public Literal (boolean bool){
		this.bool = bool;
	}
	
	public String toString() {
		return "[String]: " + this.str + "[Double]: " + this.d + 
			   "[Integer]: " + this.i + "[Boolean]: " + this.bool;
	}
	
}
