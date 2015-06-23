package uva.sc.ql.form;

import java.util.List;

import uva.sc.ql.ast.IQLFormNode;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.atom.ID;
import uva.sc.ql.statements.Statement;

public class Form implements IQLFormNode {

    private ID id;
    private List<Statement> statements;

    public Form(ID id, List<Statement> statementList) {
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
	String result = "[Form]:{\n\t" + this.id.toString() + "\n";
	for (Statement statement : this.statements) {
	    result += "\t\t[Statement]:{" + statement.toString()
		    + "}\n";
	}
	return result + "\n}";
    }

    public <T> T accept(IQLFormNodeVisitor<T> visitor) {
	return visitor.visit(this);
    }

}