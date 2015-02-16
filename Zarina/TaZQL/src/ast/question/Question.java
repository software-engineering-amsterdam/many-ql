package ast.question;


public class Question extends IQuestionVisitable {
	
	public Question () {
		
	}
		
	@Override
	public <T> T accept(IQuestionVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
