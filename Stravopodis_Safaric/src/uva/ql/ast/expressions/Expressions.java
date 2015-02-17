package uva.ql.ast.expressions;
import uva.ql.ast.*;
import uva.ql.supporting.*;

public interface Expressions extends ASTNode {
	
	@Override
	public Tuple<Integer,Integer> getCodeLine();
	
}
