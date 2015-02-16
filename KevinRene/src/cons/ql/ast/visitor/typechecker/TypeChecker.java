package cons.ql.ast.visitor.typechecker;

import cons.ql.ast.visitor.Visitor;

public class TypeChecker extends Visitor {
	public TypeChecker() {
		super(new ArithmeticTypeChecker(),
				new QLTypeChecker(),
				new RelationalTypeChecker(),
				new StatementTypeChecker(),
				new UnaryTypeChecker());
	}	
}
