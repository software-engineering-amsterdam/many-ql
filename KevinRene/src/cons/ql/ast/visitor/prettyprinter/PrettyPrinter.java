package cons.ql.ast.visitor.prettyprinter;

import cons.ql.ast.ASTNode;
import cons.ql.ast.expression.*;
import cons.ql.ast.expression.arithmetic.*;
import cons.ql.ast.expression.literal.*;
import cons.ql.ast.expression.relational.*;
import cons.ql.ast.expression.type.*;
import cons.ql.ast.statement.*;
import cons.ql.ast.visitor.ExpressionVisitor;
import cons.ql.ast.visitor.StatementVisitor;

public class PrettyPrinter implements StatementVisitor<Void>, ExpressionVisitor<Void> {
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
	public Void visit(Identifier identNode) {
		printNode(identNode);
		
		return null;
	}

	/****************
	 == TYPE NODES ==
	 ****************/
	@Override
	public Void visit(QLBoolean booleanNode) {
		printNode(booleanNode);
		return null;
	}

	@Override
	public Void visit(QLFloat floatNode) {
		printNode(floatNode);
		return null;
	}
	
	@Override
	public Void visit(QLForm formNode) {
		printNode(formNode);
		return null;
	}

	@Override
	public Void visit(QLInteger intNode) {
		printNode(intNode);
		return null;
	}

	@Override
	public Void visit(QLNumeric numericNode) {
		printNode(numericNode);	
		return null;
	}

	@Override
	public Void visit(QLString stringNode) {
		printNode(stringNode);
		return null;
	}
	
	@Override
	public Void visit(QLError qlError) {	
		printNode(qlError);
		return null;
	}

	/*******************
	 == LITERAL NODES ==
	 *******************/
	@Override
	public Void visit(BooleanLiteral booleanNode) {
		printNode(booleanNode);
		
		return null;
	}

	@Override
	public Void visit(FloatLiteral floatNode) {
		printNode(floatNode);
		
		return null;
	}

	@Override
	public Void visit(IntegerLiteral intNode) {
		printNode(intNode);
		return null;
	}

	@Override
	public Void visit(StringLiteral stringNode) {
		printNode(stringNode);	
		return null;
	}

	/******************
	 == BINARY NODES ==
	 ******************/
	@Override
	public Void visit(Add addNode) {
		printBinaryNode(addNode);	
		return null;
	}

	@Override
	public Void visit(Div divNode) {
		printBinaryNode(divNode);	
		return null;
	}

	@Override
	public Void visit(Mul mulNode) {
		printBinaryNode(mulNode);
		return null;
	}

	@Override
	public Void visit(Sub subNode) {
		printBinaryNode(subNode);
		return null;
	}
	
	@Override
	public Void visit(And andNode) {
		printBinaryNode(andNode);
		return null;
	}

	@Override
	public Void visit(Eq eqNode) {
		printBinaryNode(eqNode);
		return null;
	}

	@Override
	public Void visit(GEq geqNode) {
		printBinaryNode(geqNode);
		return null;
	}

	@Override
	public Void visit(GT gtNode) {
		printBinaryNode(gtNode);
		return null;
	}

	@Override
	public Void visit(LEq leqNode) {
		printBinaryNode(leqNode);
		return null;
	}

	@Override
	public Void visit(LT ltNode) {
		printBinaryNode(ltNode);
		return null;
	}

	@Override
	public Void visit(NEq neqNode) {
		printBinaryNode(neqNode);
		return null;
	}

	@Override
	public Void visit(Or orNode) {
		printBinaryNode(orNode);
		return null;
	}

	/*****************
	 == UNARY NODES ==
	 *****************/
	@Override
	public Void visit(Neg negNode) {
		printUnaryNode(negNode);
		return null;
	}

	@Override
	public Void visit(Not notNode) {
		printUnaryNode(notNode);
		return null;
	}

	@Override
	public Void visit(Pos posNode) {
		printUnaryNode(posNode);
		return null;
	}
	
	/*********************
	 == STATEMENT NODES ==
	 *********************/
	@Override
	public Void visit(Block blockNode) {
		printNode(blockNode);
		
		indent();
		StatementVisitor.super.visit(blockNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		printNode(compQuestionNode);
		
		indent();
		StatementVisitor.super.visit(compQuestionNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Form formNode) {
		printNode(formNode);
		
		indent();		
		StatementVisitor.super.visit(formNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(If ifNode) {
		printNode(ifNode);
		
		indent();		
		StatementVisitor.super.visit(ifNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		printNode(questionNode);
		
		indent();		
		StatementVisitor.super.visit(questionNode);
		unindent();
		
		return null;
	}
}
