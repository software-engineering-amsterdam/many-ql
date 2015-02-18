package uva.ql.ast.statements;

import uva.ql.ast.ASTNode;
import uva.ql.parser.Visitor;
import uva.ql.supporting.Tuple;

public class Statement extends ASTNode{

	public Statement(Tuple<Integer, Integer> _codeLines){
		super(_codeLines);
	}
	
	@Override
	public String toString(){
		return this.getClass().toString();
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
	}
}
