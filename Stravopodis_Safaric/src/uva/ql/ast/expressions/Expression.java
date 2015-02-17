package uva.ql.ast.expressions;
import uva.ql.ast.*;
import uva.ql.parser.Visitor;
import uva.ql.supporting.Tuple;

public class Expression extends ASTNode {
		
	public Expression (Tuple<Integer, Integer> codeLines){
		super(codeLines);
	}
	
	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
	}	
}
