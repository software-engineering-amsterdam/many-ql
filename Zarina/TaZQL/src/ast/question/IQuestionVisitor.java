package ast.question;




public interface IQuestionVisitor<T> {
	//T visit(ID id);
	//T visit(TYPE id);
	 T visit(SimpleQuestion node);
	 T visit(ComputationQuestion node);
	 T visit(Form f);
	 
	 //test
	 
}
