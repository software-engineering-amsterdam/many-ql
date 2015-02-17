package uva.ql.ast;


import java.util.ArrayList;
import java.util.List;

import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.expressions.math.Addition;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class Form implements ASTNode{
	
	protected Identifier identifier;
	protected List<Statement> children;
	
	public Form (Identifier _identifier, List <Statement> stats){
		this.identifier = _identifier;
		this.children = stats;
	}
	public void addChild(Statement child){
		this.children.add(child);
	}
	
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
}
