package ql.ast.visitor.prettyprinter;

import ql.ast.Expression;
import ql.ast.QLNode;
import ql.ast.QLType;
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
import ql.ast.expression.literal.MoneyLiteral;
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
import ql.ast.type.QLMoney;
import ql.ast.type.QLNumeric;
import ql.ast.type.QLString;
import ql.ast.visitor.ExpressionVisitor;
import ql.ast.visitor.StatementVisitor;
import ql.ast.visitor.TypeVisitor;

public class PrettyPrinter extends StatementVisitor<String> implements ExpressionVisitor<String>, TypeVisitor<String> {
	public static final String DEFAULT_PREFIX = "└── ";
	
	private String prefix = "";
	private final String prefixSymbol;
	
	private PrettyPrinter(String prefixSymbol) {
		super.setExpressionVisitor(this);
		super.setTypeVisitor(this);
		
		this.prefixSymbol = prefixSymbol;
	}
	
	/* 
	 * Expression with custom prefix 
	 */
	public static void print(Expression expression, PrintWriter printWriter, String prefixSymbol) {
		PrettyPrinter printer = new PrettyPrinter(prefixSymbol);
		printWriter.printString(expression.accept(printer));
	}
	
	/* 
	 * Statement with custom prefix 
	 */
	public static void print(Statement statement, PrintWriter printWriter, String prefixSymbol) {
		PrettyPrinter printer = new PrettyPrinter(prefixSymbol);
		printWriter.printString(statement.accept(printer));
	}
	
	/* 
	 * Statement with custom prefix 
	 */
	public static void print(QLType type, PrintWriter printWriter, String prefixSymbol) {
		PrettyPrinter printer = new PrettyPrinter(prefixSymbol);
		printWriter.printString(type.accept(printer));
	}
	
	/**
	 * Indent the prefix to indicate that a printable block
	 * of nodes has been entered.
	 */
	private void indent() {
		prefix += "   ";
	}
	
	/**
	 * Unindent the prefix. This happens when a block of
	 * printable nodes has been printed and the function
	 * exits. 
	 */
	private void unindent() {
		prefix = prefix.substring(0, this.prefix.length() - 3);
	}
	
	/**
	 * Print a node in the console. The node its toString
	 * method will be printed first, followed the the type
	 * of the node, separated by a colon.
	 * 
	 * @param node - The node to print.
	 */
	private String printNode(QLNode node) {
		String type = node.getClass().getSimpleName();
		// Strip the string until only the name of the node is left.
		String nodeString = node.toString().split("\\(")[0];
		
		return prefix + prefixSymbol + nodeString + " : " + type + "\n";
	}
	
	/**
	 * Binary nodes need to printed in the same way. This
	 * function centralises the logic for printing such a
	 * node. 
	 * 
	 * @param binaryNode - The binary node to print.
	 */
	private String printBinaryNode(Binary binaryNode) {
		StringBuilder binaryString = new StringBuilder(printNode(binaryNode));
		
		indent();
		binaryString.append(binaryNode.getLeft().accept(this));
		binaryString.append(binaryNode.getRight().accept(this));
		unindent();
		
		return binaryString.toString();
	}
	
	/**
	 * Unary nodes need to be printed in the same way. 
	 * This function centralises the logic for printing
	 * such a node.
	 * 
	 * @param unaryNode - The unary node to print.
	 */
	private String printUnaryNode(Unary unaryNode) {
		StringBuilder unaryString = new StringBuilder(printNode(unaryNode));
		
		indent();
		unaryString.append(unaryNode.getExpression().accept(this));
		unindent();
		
		return unaryString.toString();
	}

	/*********************
	 == IDENTIFIER NODE ==
	 *********************/
	@Override
	public String visit(Identifier identNode) {
		return printNode(identNode);
	}

	/****************
	 == TYPE NODES ==
	 ****************/
	@Override
	public String visit(QLBoolean booleanNode) {
		return printNode(booleanNode);
	}

	@Override
	public String visit(QLFloat floatNode) {
		return printNode(floatNode);
	}
	
	@Override
	public String visit(QLMoney moneyNode) {
		return printNode(moneyNode);
	}
	
	@Override
	public String visit(QLForm formNode) {
		return printNode(formNode);
	}

	@Override
	public String visit(QLInteger intNode) {
		return printNode(intNode);
	}

	@Override
	public String visit(QLNumeric numericNode) {
		return printNode(numericNode);	
	}

	@Override
	public String visit(QLString stringNode) {
		return printNode(stringNode);
	}
	
	@Override
	public String visit(QLError qlError) {	
		return printNode(qlError);
	}

	/*******************
	 == LITERAL NODES ==
	 *******************/
	@Override
	public String visit(BooleanLiteral booleanNode) {
		return printNode(booleanNode);
	}

	@Override
	public String visit(FloatLiteral floatNode) {
		return printNode(floatNode);
	}
	
	@Override
	public String visit(MoneyLiteral moneyNode) {
		return printNode(moneyNode);
	}

	@Override
	public String visit(IntegerLiteral intNode) {
		return printNode(intNode);
	}

	@Override
	public String visit(StringLiteral stringNode) {
		return printNode(stringNode);	
	}

	/******************
	 == BINARY NODES ==
	 ******************/
	@Override
	public String visit(Add addNode) {
		return printBinaryNode(addNode);	
	}

	@Override
	public String visit(Divide divNode) {
		return printBinaryNode(divNode);	
	}

	@Override
	public String visit(Multiply mulNode) {
		return printBinaryNode(mulNode);
	}

	@Override
	public String visit(Subtract subNode) {
		return printBinaryNode(subNode);
	}
	
	@Override
	public String visit(And andNode) {
		return printBinaryNode(andNode);
	}

	@Override
	public String visit(Equal eqNode) {
		return printBinaryNode(eqNode);
	}

	@Override
	public String visit(GreaterOrEqual geqNode) {
		return printBinaryNode(geqNode);
	}

	@Override
	public String visit(Greater gtNode) {
		return printBinaryNode(gtNode);
	}

	@Override
	public String visit(LowerOrEqual leqNode) {
		return printBinaryNode(leqNode);
	}

	@Override
	public String visit(Lower ltNode) {
		return printBinaryNode(ltNode);
	}

	@Override
	public String visit(NotEqual neqNode) {
		return printBinaryNode(neqNode);
	}

	@Override
	public String visit(Or orNode) {
		return printBinaryNode(orNode);
	}

	/*****************
	 == UNARY NODES ==
	 *****************/
	@Override
	public String visit(Negation negNode) {
		return printUnaryNode(negNode);
	}

	@Override
	public String visit(Not notNode) {
		return printUnaryNode(notNode);
	}

	@Override
	public String visit(Positive posNode) {
		return printUnaryNode(posNode);
	}
	
	/*********************
	 == STATEMENT NODES ==
	 *********************/
	@Override
	public String visit(Block blockNode) {
		StringBuilder blockString = new StringBuilder(printNode(blockNode));
		
		indent();
		for(Statement statement : blockNode.getStatements()) {
			blockString.append(statement.accept(this));
		}
		unindent();
		
		return blockString.toString();
	}

	@Override
	public String visit(ComputedQuestion compQuestionNode) {
		StringBuilder compQuestionString = new StringBuilder(printNode(compQuestionNode));
		
		indent();
		compQuestionString.append(compQuestionNode.getIdentifier().accept(this));
		compQuestionString.append(compQuestionNode.getType().accept(this));
		compQuestionString.append(compQuestionNode.getText().accept(this));
		compQuestionString.append(compQuestionNode.getExpression().accept(this));
		unindent();
		
		return compQuestionString.toString();
	}

	@Override
	public String visit(Form formNode) {
		StringBuilder formString = new StringBuilder(printNode(formNode));
		
		indent();
		formString.append(formNode.getIdentifier().accept(this));
		formString.append(formNode.getBlock().accept(this));
		unindent();
		
		return formString.toString();
	}

	@Override
	public String visit(If ifNode) {
		StringBuilder ifString = new StringBuilder(printNode(ifNode));
		
		indent();
		ifString.append(ifNode.getExpression().accept(this));
		ifString.append(ifNode.getBlock().accept(this));
		unindent();
		
		return ifString.toString();
	}
	
	@Override
	public String visit(IfElse ifElseNode) {
		StringBuilder ifElseString = new StringBuilder(printNode(ifElseNode));
		
		indent();
		ifElseString.append(ifElseNode.getExpression().accept(this));
		ifElseString.append(ifElseNode.getIfBranch().accept(this));
		ifElseString.append(ifElseNode.getElseBranch().accept(this));
		unindent();
		
		return ifElseString.toString();
	}

	@Override
	public String visit(Question questionNode) {
		StringBuilder questionString = new StringBuilder(printNode(questionNode));
		
		indent();
		questionString.append(questionNode.getIdentifier().accept(this));
		questionString.append(questionNode.getType().accept(this));
		questionString.append(questionNode.getText().accept(this));
		unindent();
		
		return questionString.toString();
	}
}
