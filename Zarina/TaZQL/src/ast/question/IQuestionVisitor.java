package ast.question;




public interface IQuestionVisitor<T> {
	//T visit(ID id);
	//T visit(TYPE id);
	 T visit(SimpleQuestion simpleQuestion);
	 T visit(ComputationQuestion calQuestion);
	 T visit(Form form);
	 T visit(IfStatement ifStatement);	 
	 T visit(IfElseStatement ifElseStatement);
}
