package ast.question;


public interface IQuestionVisitor<T> {

	 public T visit(Question question);
	
	 public T visit(SimpleQuestion simpleQuestion);
	 public T visit(ComputationQuestion calQuestion); 
	 public T visit(IfStatement ifStatement);	 
	 public T visit(IfElseStatement ifElseStatement);
	 
}
