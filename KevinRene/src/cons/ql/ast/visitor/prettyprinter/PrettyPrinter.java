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
	
	/**
	 * Indent the prefix to indicate that a printable block
	 * of nodes has been entered.
	 */
	private void indent() {
		this.prefix += "   ";
	}
	
	/**
	 * Unindent the prefix. This happens when a block of
	 * printable nodes has been printed and the function
	 * exits. 
	 */
	private void unindent() {
		this.prefix = this.prefix.substring(0, this.prefix.length() - 3);
	}
	
	/**
	 * Print a node in the console. The node its toString
	 * method will be printed first, followed the the type
	 * of the node, separated by a colon.
	 * 
	 * @param node - The node to print.
	 */
	private void printNode(ASTNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		System.out.println(prefix + ("└── ") + nodeString + " : " + type);
	}
	
	/**
	 * Binary nodes need to printed in the same way. This
	 * function centralises the logic for printing such a
	 * node. 
	 * 
	 * @param binaryNode - The binary node to print.
	 */
	private void printBinaryNode(Binary binaryNode) {
		printNode(binaryNode);
		
		indent();
		ExpressionVisitor.super.visit(binaryNode);
		unindent();
	}
	
	/**
	 * Unary nodes need to be printed in the same way. 
	 * This function centralises the logic for printing
	 * such a node.
	 * 
	 * @param unaryNode - The unary node to print.
	 */
	private void printUnaryNode(Unary unaryNode) {
		printNode(unaryNode);
		
		indent();
		ExpressionVisitor.super.visit(unaryNode);
		unindent();
	}

	/*********************
	 == IDENTIFIER NODE ==
	 *********************/
	@Override
	public void visit(Identifier identNode) {
		printNode(identNode);
	}

	/****************
	 == TYPE NODES ==
	 ****************/
	@Override
	public void visit(QLBoolean booleanNode) {
		printNode(booleanNode);
	}

	@Override
	public void visit(QLFloat floatNode) {
		printNode(floatNode);
	}

	@Override
	public void visit(QLInteger intNode) {
		printNode(intNode);
	}

	@Override
	public void visit(QLNumeric numericNode) {
		printNode(numericNode);
	}

	@Override
	public void visit(QLString stringNode) {
		printNode(stringNode);
	}

	/*******************
	 == LITERAL NODES ==
	 *******************/
	@Override
	public void visit(BooleanLiteral booleanNode) {
		printNode(booleanNode);
	}

	@Override
	public void visit(FloatLiteral floatNode) {
		printNode(floatNode);
	}

	@Override
	public void visit(IntegerLiteral intNode) {
		printNode(intNode);
	}

	@Override
	public void visit(StringLiteral stringNode) {
		printNode(stringNode);
	}

	/******************
	 == BINARY NODES ==
	 ******************/
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

	/*****************
	 == UNARY NODES ==
	 *****************/
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
	
	/*********************
	 == STATEMENT NODES ==
	 *********************/
	@Override
	public void visit(Block blockNode) {
		printNode(blockNode);
		
		indent();
		StatementVisitor.super.visit(blockNode);
		unindent();
	}

	@Override
	public void visit(ComputedQuestion compQuestionNode) {
		printNode(compQuestionNode);
		
		indent();
		StatementVisitor.super.visit(compQuestionNode);
		unindent();
	}

	@Override
	public void visit(Form formNode) {
		printNode(formNode);
		
		indent();		
		StatementVisitor.super.visit(formNode);
		unindent();
	}

	@Override
	public void visit(If ifNode) {
		printNode(ifNode);
		
		indent();		
		StatementVisitor.super.visit(ifNode);
		unindent();
	}

	@Override
	public void visit(Question questionNode) {
		printNode(questionNode);
		
		indent();		
		StatementVisitor.super.visit(questionNode);
		unindent();
	}
}
