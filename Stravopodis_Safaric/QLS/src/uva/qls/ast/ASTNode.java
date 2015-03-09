package uva.qls.ast;
import uva.qls.ast.CodeLines;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.GenericValue;
import uva.qls.supporting.Tuple;
public abstract class ASTNode {
	
	protected CodeLines codeLines;
	
	public ASTNode (CodeLines _codeLines) {
		this.codeLines=_codeLines;
	}

	public abstract Tuple<Integer, Integer> getLOCTuple();
	public abstract CodeLines getLOC();
	public abstract GenericValue<?> evaluate();
	public abstract <T> T accept(StatementVisitor<T> visitor);
	
}
