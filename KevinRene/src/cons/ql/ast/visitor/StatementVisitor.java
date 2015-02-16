package cons.ql.ast.visitor;

import cons.ql.ast.statement.*;

public interface StatementVisitor {
	public void visit(Block blockNode);
	public void visit(ComputedQuestion compQuestionNode);
	public void visit(Form formNode);
	public void visit(If ifThenNode);
	public void visit(Question questionNode);
}
