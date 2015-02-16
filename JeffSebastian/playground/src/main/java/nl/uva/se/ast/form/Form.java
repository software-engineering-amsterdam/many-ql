package nl.uva.se.ast.form;

import java.util.List;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.statement.Statement;

public class Form extends Node<Statement> {

	private final String id;
	
	public Form(String id, List<Statement> statements) {
		super(statements);
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
