package qlProject.ast;

import java.util.List;

import qlProject.ast.statement.IStatement;
import qlProject.ast.statement.IStatementsVisitor;

public class Questionnaire {

	List<IStatement> statementsList;

	public Questionnaire (List<IStatement> statements){
		statementsList = statements;
	}


	public List<IStatement> getStatements ()
	{
		return statementsList;
	}

	public void accept(IStatementsVisitor visitor){
		visitor.visit(this);
	}
}