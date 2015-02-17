package uva.ql.ast.question;

import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.expressions.Type;
import uva.ql.ast.expressions.literals.Identifier;
import uva.ql.ast.statements.Statement;
import uva.ql.supporting.Tuple;

public class Question extends Statement implements ASTNode{
	
	protected Identifier identifier;
	protected Type type;
	protected List<Statement> children;
	
	public Question(Identifier _identifier, Type _type){
		this.identifier = _identifier;
		this.type = _type;
	}
	
	public void addChild(Statement child){
		this.children.add(child);
	}
	
	@Override
	public Tuple<Integer, Integer> getCodeLine() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString(){
		return null;
	}
}



