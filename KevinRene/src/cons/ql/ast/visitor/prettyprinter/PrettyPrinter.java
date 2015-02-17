package cons.ql.ast.visitor.prettyprinter;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.Identifier;
import cons.ql.ast.expression.arithmetic.Add;
import cons.ql.ast.expression.arithmetic.Div;
import cons.ql.ast.expression.arithmetic.Mul;
import cons.ql.ast.expression.arithmetic.Sub;
import cons.ql.ast.expression.literal.BooleanLiteral;
import cons.ql.ast.expression.literal.FloatLiteral;
import cons.ql.ast.expression.literal.IntegerLiteral;
import cons.ql.ast.expression.literal.StringLiteral;
import cons.ql.ast.expression.relational.And;
import cons.ql.ast.expression.relational.Eq;
import cons.ql.ast.expression.relational.GEq;
import cons.ql.ast.expression.relational.GT;
import cons.ql.ast.expression.relational.LEq;
import cons.ql.ast.expression.relational.LT;
import cons.ql.ast.expression.relational.NEq;
import cons.ql.ast.expression.relational.Or;
import cons.ql.ast.expression.type.QLBoolean;
import cons.ql.ast.expression.type.QLFloat;
import cons.ql.ast.expression.type.QLInteger;
import cons.ql.ast.expression.type.QLNumeric;
import cons.ql.ast.expression.type.QLString;
import cons.ql.ast.expression.unary.Neg;
import cons.ql.ast.expression.unary.Not;
import cons.ql.ast.expression.unary.Pos;
import cons.ql.ast.statement.*;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class PrettyPrinter implements StatementVisitor, ExpressionVisitor {
	private String prefix = "";
	
	public void printAST(ASTNode tree) {
		tree.accept(this);
	}
	
	private void printNode(ASTNode node, boolean isTail) {
		String type = node.getClass().getSimpleName();
		String nodeString = node.toString().split("\\(")[0];
		
		System.out.println(prefix + (isTail ? "└── " : "├── ") + nodeString + " : " + type);
	}
	
	private void indent() {
		this.prefix += "   ";
	}
	
	private void unindent() {
		this.prefix = this.prefix.substring(0, this.prefix.length() - 3);
	}
	
	@Override
	public void visit(Block blockNode) {
		printNode(blockNode, true);
		
		indent();
		StatementVisitor.super.visit(blockNode);
		unindent();
	}

	@Override
	public void visit(ComputedQuestion compQuestionNode) {
		printNode(compQuestionNode, true);
		
		indent();
		StatementVisitor.super.visit(compQuestionNode);
		unindent();
	}

	@Override
	public void visit(Form formNode) {
		printNode(formNode, true);
		
		indent();		
		StatementVisitor.super.visit(formNode);
		unindent();
	}

	@Override
	public void visit(If ifNode) {
		printNode(ifNode, true);
		
		indent();		
		StatementVisitor.super.visit(ifNode);
		unindent();
	}

	@Override
	public void visit(Question questionNode) {
		printNode(questionNode, true);
		
		indent();		
		StatementVisitor.super.visit(questionNode);
		unindent();
	}
	
	@Override
	public void visit(Add addNode) {
		printNode(addNode, true);
		
		indent();
		ExpressionVisitor.super.visit(addNode);
		unindent();
	}

	@Override
	public void visit(Div divNode) {
		printNode(divNode, true);
		
		indent();
		ExpressionVisitor.super.visit(divNode);
		unindent();
	}

	@Override
	public void visit(Mul mulNode) {
		printNode(mulNode, true);
		
		indent();
		ExpressionVisitor.super.visit(mulNode);
		unindent();
	}

	@Override
	public void visit(Sub subNode) {
		printNode(subNode, true);
		
		indent();
		ExpressionVisitor.super.visit(subNode);
		unindent();
	}

	@Override
	public void visit(Identifier identNode) {
		printNode(identNode, true);
	}

	@Override
	public void visit(QLBoolean booleanNode) {
		printNode(booleanNode, true);
	}

	@Override
	public void visit(QLFloat floatNode) {
		printNode(floatNode, true);
	}

	@Override
	public void visit(QLInteger intNode) {
		printNode(intNode, true);
	}

	@Override
	public void visit(QLNumeric numericNode) {
		printNode(numericNode, true);
	}

	@Override
	public void visit(QLString stringNode) {
		printNode(stringNode, true);
	}

	@Override
	public void visit(BooleanLiteral booleanNode) {
		printNode(booleanNode, true);
	}

	@Override
	public void visit(FloatLiteral floatNode) {
		printNode(floatNode, true);
	}

	@Override
	public void visit(IntegerLiteral intNode) {
		printNode(intNode, true);
	}

	@Override
	public void visit(StringLiteral stringNode) {
		printNode(stringNode, true);
	}

	@Override
	public void visit(And andNode) {
		printNode(andNode, true);
		
		indent();
		ExpressionVisitor.super.visit(andNode);
		unindent();
	}

	@Override
	public void visit(Eq eqNode) {
		printNode(eqNode, true);
		
		indent();
		ExpressionVisitor.super.visit(eqNode);
		unindent();
	}

	@Override
	public void visit(GEq geqNode) {
		printNode(geqNode, true);
		
		indent();
		ExpressionVisitor.super.visit(geqNode);
		unindent();
	}

	@Override
	public void visit(GT gtNode) {
		printNode(gtNode, true);
		
		indent();
		ExpressionVisitor.super.visit(gtNode);
		unindent();
	}

	@Override
	public void visit(LEq leqNode) {
		printNode(leqNode, true);
		
		indent();
		ExpressionVisitor.super.visit(leqNode);
		unindent();
	}

	@Override
	public void visit(LT ltNode) {
		printNode(ltNode, true);
		
		indent();
		ExpressionVisitor.super.visit(ltNode);
		unindent();
	}

	@Override
	public void visit(NEq neqNode) {
		printNode(neqNode, true);
		
		indent();
		ExpressionVisitor.super.visit(neqNode);
		unindent();
	}

	@Override
	public void visit(Or orNode) {
		printNode(orNode, true);
		
		indent();
		ExpressionVisitor.super.visit(orNode);
		unindent();
	}

	@Override
	public void visit(Neg negNode) {
		printNode(negNode, true);
		
		indent();
		ExpressionVisitor.super.visit(negNode);
		unindent();
	}

	@Override
	public void visit(Not notNode) {
		printNode(notNode, true);
		
		indent();
		ExpressionVisitor.super.visit(notNode);
		unindent();
	}

	@Override
	public void visit(Pos posNode) {
		printNode(posNode, true);
		
		indent();
		ExpressionVisitor.super.visit(posNode);
		unindent();
	}
}
