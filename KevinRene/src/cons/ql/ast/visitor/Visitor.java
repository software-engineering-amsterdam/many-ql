package cons.ql.ast.visitor;

import java.util.HashMap;

import cons.ql.ast.Statement;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.literal.QLBoolean;
import cons.ql.ast.expression.literal.QLFloat;
import cons.ql.ast.expression.literal.QLIdent;
import cons.ql.ast.expression.literal.QLInt;
import cons.ql.ast.expression.literal.QLString;

public abstract class Visitor {
	private ArithmetricVisitor arithmeticVisitor;
	private QLTypeVisitor qlTypeVisitor;
	private RelationalVisitor relationalVisitor;
	private StatementVisitor statementVisitor;
	private UnaryVisitor unaryVisitor;
	
	public Visitor(
			ArithmetricVisitor arithmeticVisitor, 
			QLTypeVisitor qlTypeVisitor, 
			RelationalVisitor relationalVisitor, 
			StatementVisitor statementVisitor, 
			UnaryVisitor unaryVisitor) {
		this.arithmeticVisitor = arithmeticVisitor;
		this.qlTypeVisitor = qlTypeVisitor;
		this.relationalVisitor = relationalVisitor;
		this.statementVisitor = statementVisitor;
		this.unaryVisitor = unaryVisitor;
	}
	
	@SuppressWarnings("rawtypes")
	public void visit(QLType typeNode) {		
		switch(typeNode.getName()) {
		case "QLInt": 
			qlTypeVisitor.visit((QLInt) typeNode);
			break;
		case "QLBoolean": 
			qlTypeVisitor.visit((QLBoolean) typeNode);
			break;
		case "QLFloat": 
			qlTypeVisitor.visit((QLFloat) typeNode);
			break;
		case "QLString": 
			qlTypeVisitor.visit((QLString) typeNode);
			break;
		case "QLIdent": 
			qlTypeVisitor.visit((QLIdent) typeNode);
			break;
		}
	}

	public void visit(Unary unaryNode) {
		System.out.println("Unary node visited.");
	}

	public void visit(Binary binaryNode) {
		switch(binaryNode.getClass().getSimpleName()) {
			case "Add" :
				arithmeticVisitor.visit((Add) binaryNode);
				break;
		}
	}

	public void visit(Statement statementNode) {
		System.out.println("Statement node visited.");
	}
}
