package qlProject.ast.statement;


public interface IStatement {

	public void accept (IStatementsVisitor visitor);

}