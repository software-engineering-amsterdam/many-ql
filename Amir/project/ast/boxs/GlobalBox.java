package project.ast.boxs;

import project.ast.IGlobalElement;
import project.main.QuestionPopulatorVisitor;
import project.typeChecking.TypeChecker;
public interface GlobalBox extends IGlobalElement{

	public void accept(QuestionPopulatorVisitor visitor);// {
	public void accept(TypeChecker visitor);// {
	
}
