package uva.sc.logic;

import java.util.List;

public class Form extends Node{
	
	String id;
	List<Statement> statements;
	
	public Form (String id, List<Statement> statementList) {
		this.id = id;
		this.statements = statementList;
	}
	
	public String toString() {
		String result ="[Form]:{\n\t" + "[ID]: " + this.id + "\n";
		for (int i = 0 ; i < this.statements.size() ; i++)
			result += "\t\t[Statement]:{" + statements.get(i).toString() + "}\n";
		return result + "\n}";
	}
	
}