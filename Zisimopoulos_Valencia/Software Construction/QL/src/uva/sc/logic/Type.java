package uva.sc.logic;

public class Type extends Node{

	String type;
	
	public Type(String type) {
		this.type = type;
	}
	
	public String toString() {
		return "[Type]: " + this.type;
	}
	
}