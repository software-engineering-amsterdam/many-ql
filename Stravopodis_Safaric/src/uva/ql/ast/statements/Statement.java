package uva.ql.ast.statements;

import java.util.ArrayList;
import java.util.List;

import uva.ql.ast.ASTNode;
import uva.ql.ast.CodeLines;

public class Statement extends ASTNode{

	public List<ASTNode> statements;
	
	public Statement(CodeLines _codeLines){
		super(_codeLines);
		statements = new ArrayList<ASTNode>();
	}
	
	public void addChild(ASTNode stat){
		this.statements.add(stat);
	}
	public List<ASTNode> getChildren(){
		return statements;
	}
	public boolean hasChildren(){
		return this.statements.isEmpty();
	}
	
	@Override
	public String toString(){
		String statementString = "";
		for (ASTNode s : statements){
			statementString+=s.toString();
			if (s != statements.get(statements.size()-1)) statementString+=",";
		}
		return statementString;
	}
	
	public Statement getStatement(){
		return this;
	}
}
