package ql.ast.visitor.prettyprinter;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.Statement;
import ql.ast.expression.Binary;
import ql.ast.expression.Identifier;
import ql.ast.expression.Unary;
import ql.ast.expression.arithmetic.Add;
import ql.ast.expression.arithmetic.Divide;
import ql.ast.expression.arithmetic.Multiply;
import ql.ast.expression.arithmetic.Negation;
import ql.ast.expression.arithmetic.Positive;
import ql.ast.expression.arithmetic.Subtract;
import ql.ast.expression.booleanalgebra.And;
import ql.ast.expression.booleanalgebra.Not;
import ql.ast.expression.booleanalgebra.Or;
import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;
import ql.ast.expression.relational.Equal;
import ql.ast.expression.relational.Greater;
import ql.ast.expression.relational.GreaterOrEqual;
import ql.ast.expression.relational.Lower;
import ql.ast.expression.relational.LowerOrEqual;
import ql.ast.expression.relational.NotEqual;
import ql.ast.statement.Block;
import ql.ast.statement.ComputedQuestion;
import ql.ast.statement.Form;
import ql.ast.statement.If;
import ql.ast.statement.IfElse;
import ql.ast.statement.Question;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLError;
import ql.ast.type.QLFloat;
import ql.ast.type.QLForm;
import ql.ast.type.QLInteger;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;

public class PrettyPrinter extends StatementVisitor<Void> implements ExpressionVisitor<Void>, TypeVisitor<Void> {
	private String prefix = "";
	private final String prefixSymbol;
	private StringBuilder treeString;
	
	private PrettyPrinter() {
		super.setExpressionVisitor(this);
		
		prefixSymbol = "└── ";
		treeString = new StringBuilder();
	}
	
	private PrettyPrinter(String prefixSymbol) {
		super.setExpressionVisitor(this);
		
		this.prefixSymbol = prefixSymbol;
		treeString = new StringBuilder();
	}
	
	public String getTreeString() {
		return treeString.toString();
	}
	
	/* 
	 * Expression with default prefix 
	 */
	public static String stringify(Expression expression) {
		PrettyPrinter printer = new PrettyPrinter();
		expression.accept(printer);
		
		return printer.getTreeString();
	}
	
	public static void print(Expression expression) {
		System.out.println(stringify(expression));
	}
	
	/* 
	 * Statement with default prefix 
	 */
	public static String stringify(Statement statement) {
		PrettyPrinter printer = new PrettyPrinter();
		statement.accept(printer);
		
		return printer.getTreeString();
	}
	
	public static void print(Statement statement) {
		System.out.println(stringify(statement));
	}
	
	/* 
	 * Expression with custom prefix 
	 */
	public static String stringify(Expression expression, String prefixSymbol) {
		PrettyPrinter printer = new PrettyPrinter(prefixSymbol);
		expression.accept(printer);
		
		return printer.getTreeString();
	}
	
	public static void print(Expression expression, String prefixSymbol) {
		System.out.println(stringify(expression, prefixSymbol));
	}
	
	
	/* 
	 * Statement with custom prefix 
	 */
	public static String stringify(Statement statement, String prefixSymbol) {
		PrettyPrinter printer = new PrettyPrinter(prefixSymbol);
		statement.accept(printer);
		
		return printer.getTreeString();
	}
	
	public static void print(Statement statement, String prefixSymbol) {
		System.out.println(stringify(statement, prefixSymbol));
	}
	
	
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
	private void printNode(QLNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		treeString.append(prefix + (prefixSymbol) + nodeString + " : " + type + "\n");
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
	public Void visit(Divide divNode) {
		printBinaryNode(divNode);	
		return null;
	}

	@Override
	public Void visit(Multiply mulNode) {
		printBinaryNode(mulNode);
		return null;
	}

	@Override
	public Void visit(Subtract subNode) {
		printBinaryNode(subNode);
		return null;
	}
	
	@Override
	public Void visit(And andNode) {
		printBinaryNode(andNode);
		return null;
	}

	@Override
	public Void visit(Equal eqNode) {
		printBinaryNode(eqNode);
		return null;
	}

	@Override
	public Void visit(GreaterOrEqual geqNode) {
		printBinaryNode(geqNode);
		return null;
	}

	@Override
	public Void visit(Greater gtNode) {
		printBinaryNode(gtNode);
		return null;
	}

	@Override
	public Void visit(LowerOrEqual leqNode) {
		printBinaryNode(leqNode);
		return null;
	}

	@Override
	public Void visit(Lower ltNode) {
		printBinaryNode(ltNode);
		return null;
	}

	@Override
	public Void visit(NotEqual neqNode) {
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
	public Void visit(Negation negNode) {
		printUnaryNode(negNode);
		return null;
	}

	@Override
	public Void visit(Not notNode) {
		printUnaryNode(notNode);
		return null;
	}

	@Override
	public Void visit(Positive posNode) {
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
		super.visit(blockNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(ComputedQuestion compQuestionNode) {
		printNode(compQuestionNode);
		
		indent();
		super.visit(compQuestionNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Form formNode) {
		printNode(formNode);
		
		indent();		
		super.visit(formNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(If ifNode) {
		printNode(ifNode);
		
		indent();		
		super.visit(ifNode);
		unindent();
		
		return null;
	}
	
	@Override
	public Void visit(IfElse ifElseNode) {
		printNode(ifElseNode);
		
		indent();		
		super.visit(ifElseNode);
		unindent();
		
		return null;
	}

	@Override
	public Void visit(Question questionNode) {
		printNode(questionNode);
		
		indent();		
		super.visit(questionNode);
		unindent();
		
		return null;
	}
}
