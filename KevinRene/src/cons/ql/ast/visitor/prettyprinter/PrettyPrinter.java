package cons.ql.ast.visitor.prettyprinter;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.expression.unary.*;
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
	
	private void printBinaryNode(Binary binaryNode) {
		printNode(binaryNode, true);
		
		indent();
		ExpressionVisitor.super.visit(binaryNode);
		unindent();
	}
	
	private void printUnaryNode(Unary unaryNode) {
		printNode(unaryNode, true);
		
		indent();
		ExpressionVisitor.super.visit(unaryNode);
		unindent();
	}
	
	private void indent() {
		this.prefix += "   ";
	}
	
	private void unindent() {
		this.prefix = this.prefix.substring(0, this.prefix.length() - 3);
	}

	/**
	 * Identifier node
	 */
	@Override
	public void visit(Identifier identNode) {
		printNode(identNode, true);
	}

	/**
	 * Type nodes
	 */
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

	/**
	 * Literal nodes
	 */
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

	/**
	 * Binary nodes
	 */
	@Override
	public void visit(Add addNode) {
		printBinaryNode(addNode);
	}

	@Override
	public void visit(Div divNode) {
		printBinaryNode(divNode);
	}

	@Override
	public void visit(Mul mulNode) {
		printBinaryNode(mulNode);
	}

	@Override
	public void visit(Sub subNode) {
		printBinaryNode(subNode);
	}
	
	@Override
	public void visit(And andNode) {
		printBinaryNode(andNode);
	}

	@Override
	public void visit(Eq eqNode) {
		printBinaryNode(eqNode);
	}

	@Override
	public void visit(GEq geqNode) {
		printBinaryNode(geqNode);
	}

	@Override
	public void visit(GT gtNode) {
		printBinaryNode(gtNode);
	}

	@Override
	public void visit(LEq leqNode) {
		printBinaryNode(leqNode);
	}

	@Override
	public void visit(LT ltNode) {
		printBinaryNode(ltNode);
	}

	@Override
	public void visit(NEq neqNode) {
		printBinaryNode(neqNode);
	}

	@Override
	public void visit(Or orNode) {
		printBinaryNode(orNode);
	}

	/**
	 * Unary nodes
	 */
	@Override
	public void visit(Neg negNode) {
		printUnaryNode(negNode);
	}

	@Override
	public void visit(Not notNode) {
		printUnaryNode(notNode);
	}

	@Override
	public void visit(Pos posNode) {
		printUnaryNode(posNode);
	}
	
	/**
	 * Statement nodes
	 */
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
}
