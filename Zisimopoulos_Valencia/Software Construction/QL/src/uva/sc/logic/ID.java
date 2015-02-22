package uva.sc.logic;

public class ID extends Expression{
	
	private String id;

	public ID(String id){
		this.id = id;
	}
	public String toString(){
		return "[ID]: " + id;
	}
}
