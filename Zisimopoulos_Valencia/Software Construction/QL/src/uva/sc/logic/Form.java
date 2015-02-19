package uva.sc.logic;

import java.util.List;

public class Form extends Node{
	
	String id;
	List<Statement> statements;
	
	public Form (String id, List<Statement> statementList) {
		this.id = id;
		this.statements = statementList;
	}
	
}