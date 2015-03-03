package uva.sc.logic;

import java.util.List;

import uva.sc.ast.INode;
import uva.sc.ast.INodeVisitor;
import uva.sc.atom.ID;

public class Form implements INode{
	
	ID id;
	List<Statement> statements;

	public Form (ID id, List<Statement> statementList) {
		this.id = id;
		this.statements = statementList;
	}
	
	public ID getId() {
		return id;
	}

	public List<Statement> getStatements() {
		return statements;
	}
	
	public String toString() {
		String result ="[Form]:{\n\t" + this.id.toString() + "\n";
		for (int i = 0 ; i < this.statements.size() ; i++) {
			result += "\t\t[Statement]:{" + statements.get(i).toString() + "}\n";
		}
		return result + "\n}";
	}

	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}