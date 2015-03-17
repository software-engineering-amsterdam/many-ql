package uva.sc.ql.statements;

import uva.sc.core.types.Type;
import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.ID;
import uva.sc.ql.expression.Expression;

public class Question implements Statement {

    String str;
    ID id;
    Type type;
    Expression expr;

    public Question(String str, ID id, Type type, Expression expr) {
	this.str = str;
	this.id = id;
	this.type = type;
	this.expr = expr;
    }

    public Question(String str, ID id, Type type) {
	this.str = str;
	this.id = id;
	this.type = type;
    }

    public String getStr() {
	return str;
    }

    public ID getId() {
	return id;
    }

    public Type getType() {
	return type;
    }

    public Expression getExpr() {
	return expr;
    }

    public String toString() {
	String result = "[Question]: [String]: " + this.str + ", "
		+ this.id.toString() + ", " + this.type.toString();
	if (this.expr != null) {
	    result += this.expr.toString();
	}
	return result;
    }

    public <T> T accept(IQLStatementNodeVisitor<T> visitor) {
	return visitor.visit(this);
    }
    
}
