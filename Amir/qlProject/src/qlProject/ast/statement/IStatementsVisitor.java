package qlProject.ast.statement;

import qlProject.ast.Questionnaire;
import qlProject.ast.statement.assignment.ComputedAssignment;
import qlProject.ast.statement.assignment.DirectAssignment;

public interface IStatementsVisitor {

	public void visit (Questionnaire q);
	
	public void visit (IfStatement s);

	public void visit (ComputedAssignment a);

	public void visit (DirectAssignment a);

}