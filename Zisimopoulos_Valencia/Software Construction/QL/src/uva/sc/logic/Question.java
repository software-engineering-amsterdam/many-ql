package uva.sc.logic;

import uva.sc.ast.INodeVisitor;
import uva.sc.atom.ID;
import uva.sc.types.Type;


public class Question extends Statement{

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
		String result = "[Question]: [String]: " + this.str + ", " + this.id.toString() + ", " + this.type.toString();
		if (this.expr != null) {
			result += this.expr.toString();
		}
		return result;		
	}

	@Override
	public <T> T accept(INodeVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
