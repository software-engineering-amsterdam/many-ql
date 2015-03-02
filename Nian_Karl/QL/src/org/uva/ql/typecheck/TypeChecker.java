package org.uva.ql.typecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.expression.association.Parenthese;
import org.uva.ql.ast.expression.binary.And;
import org.uva.ql.ast.expression.binary.Binary;
import org.uva.ql.ast.expression.binary.Divide;
import org.uva.ql.ast.expression.binary.Equal;
import org.uva.ql.ast.expression.binary.Greater;
import org.uva.ql.ast.expression.binary.GreaterEqual;
import org.uva.ql.ast.expression.binary.Less;
import org.uva.ql.ast.expression.binary.LessEqual;
import org.uva.ql.ast.expression.binary.Minus;
import org.uva.ql.ast.expression.binary.Multiply;
import org.uva.ql.ast.expression.binary.NotEqual;
import org.uva.ql.ast.expression.binary.Or;
import org.uva.ql.ast.expression.binary.Plus;
import org.uva.ql.ast.expression.literal.BoolLiteral;
import org.uva.ql.ast.expression.literal.Identifier;
import org.uva.ql.ast.expression.literal.IntLiteral;
import org.uva.ql.ast.expression.literal.StrLiteral;
import org.uva.ql.ast.expression.unary.Negative;
import org.uva.ql.ast.expression.unary.Not;
import org.uva.ql.ast.expression.unary.Positive;
import org.uva.ql.ast.expression.unary.Unary;
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.message.Error;
import org.uva.ql.typecheck.message.Warning;
import org.uva.ql.visitor.ExpressionVisitor;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;

public class TypeChecker implements StatementVisitor<Boolean>,ExpressionVisitor<Boolean>,QuestionnaireVisitor<Boolean> {

	private final Map<Identifier, Type> types;
	private final ArrayList<String> labels;
	private final MessageManager messageManager;
	
	public TypeChecker() {
		types = new HashMap<Identifier, Type>();
		labels = new ArrayList<String>();
		messageManager = new MessageManager();
	}

// Identifier-Type table	
	public void addType(Identifier identifier, Type type) {
		types.put(identifier, type);
	}
	
	public Type getType(Identifier identifier) {
		return types.get(identifier);
	}

	public boolean isDeclared(Identifier identifier) {
		return types.containsKey(identifier);
	}
	
// Label list
	public void addLabel(String label) {
		labels.add(label);
	}
	
	public boolean hasLabel(String label) {
		return labels.contains(label);
	}
	
// Message Management	
	public void addError(Error error) {
		messageManager.addError(error);
	}
	
	public void addWarning(Warning warning) {
		messageManager.addWarning(warning);
	}
	
	public int countErrors() {
		return messageManager.countErrors();
	}
	
	public int countWarnings() {
		return messageManager.countWarnings();
	}
	
	public void printMessages() {
		System.out.println("[ERRORS]");
		messageManager.printErrors();
		System.out.println();
		System.out.println("[WARNINGS]");
		messageManager.printWarnings();
	}
	
	
// Checkers
	public void checkLabel(QuestionNormal question) {
		String label = question.getLabel().getValue();
		if (hasLabel(label)) {
			Warning warning = new Warning(Warning.Type.DUPLICATE, question.getPosition().getStartLine(), label);
			messageManager.addWarning(warning);
		} else {
			addLabel(label);
		}
	}
	
	public void checkReference(Identifier identifier) {
		if (!isDeclared(identifier)) {
			Error error = new Error(Error.Type.REFERENCE, identifier.getPosition().getStartLine(), identifier.toString());
			messageManager.addError(error);
		}
	}

	public void checkDeclaration(QuestionNormal question) {
		if (isDeclared(question.getIdentifier())) {
			Type thisType = question.getType();
			Type expectType = getType(question.getIdentifier());
			
			if (thisType.isEqual(expectType) == false) {
				Error error = new Error(Error.Type.DECLARATION,
			                            question.getIdentifier().getPosition().getStartLine(),
			                            question.getIdentifier().toString());
				messageManager.addError(error);
			}
		} else {
			System.out.println(question.getIdentifier().toString());
			addType(question.getIdentifier(), question.getType());
		}
	}
	
	public void checkCondition(Expression expr) {
		if (!expr.getType(this).isEqual(new BoolType())) {
			Error error = new Error(Error.Type.CONDITION, expr.getPosition().getStartLine(),expr.toString());
			messageManager.addError(error);
		}
		
		expr.accept(this);
	}
	
	public void checkUnaryCondition(Unary unary) {
		checkCondition(unary.getExpression());
	}
	
	public void checkBinaryCondition(Binary binary) {
		checkCondition(binary.getLeftExpression());
		checkCondition(binary.getRightExpression());
	}
	
	public void checkOperand(Expression expr) {
		if (!expr.getType(this).isEqual(new IntType())) {
			Error error = new Error(Error.Type.OPERAND, expr.getPosition().getStartLine(),expr.toString());
			messageManager.addError(error);
		}
		
		expr.accept(this);
	}
	
	public void checkUnaryOperand(Unary unary) {
		checkOperand(unary.getExpression());
	}
	
	public void checkBinaryOperand(Binary binary) {
		checkOperand(binary.getLeftExpression());
		checkOperand(binary.getRightExpression());
	}
	
// Visits
	
	@Override
	public Boolean visit(Questionnaire questionnaire) {
		System.out.println("Questionnaire");
		for (Form form : questionnaire.getForms()) {
			form.accept(this);
		}
		return null;
	}
	
	@Override
	public Boolean visit(Form form) {
		System.out.println("Form");
		form.getBlock().accept(this);
		return null;
	}

	@Override
	public Boolean visit(Block block) {
		for (Statement statement : block.getStatements()) {
			statement.accept(this);
		}
		return null;
	}
	
	@Override
	public Boolean visit(QuestionNormal question) {
		System.out.println("Question Normal");
		checkDeclaration(question);
		checkLabel(question);
		return null;
	}
	
	@Override
	public Boolean visit(QuestionCompute question) {
		System.out.println("Question Compute");
		checkDeclaration(question);
		checkLabel(question);
		return null;
	}
	
	@Override
	public Boolean visit(IfStatement ifStatement) {
		System.out.println("If Statement");
		ifStatement.getExpr().accept(this);
		ifStatement.getIfBlock().accept(this);
		return null;
	}

	@Override
	public Boolean visit(IfElseStatement ifElseStatement) {
		System.out.println("If Else Statement");
		ifElseStatement.getExpr().accept(this);
		ifElseStatement.getIfBlock().accept(this);
		ifElseStatement.getElseBLock().accept(this);
		return null;
	}
	
	@Override
	public Boolean visit(Parenthese node) {
		return node.getExpression().accept(this);
	}
	
	
	@Override
	public Boolean visit(Not node) {
		checkUnaryCondition(node);
		return null;
	}

	@Override
	public Boolean visit(Positive node) {
		checkUnaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Negative node) {
		checkUnaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Plus node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Minus node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Multiply node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Divide node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(And node) {
		checkBinaryCondition(node);
		return null;
	}

	@Override
	public Boolean visit(Or node) {
		checkBinaryCondition(node);
		return null;
	}

	@Override
	public Boolean visit(Equal node) {
		checkBinaryCondition(node);
		return null;
	}

	@Override
	public Boolean visit(NotEqual node) {
		checkBinaryCondition(node);
		return null;
	}

	@Override
	public Boolean visit(Greater node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(GreaterEqual node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Less node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(LessEqual node) {
		checkBinaryOperand(node);
		return null;
	}

	@Override
	public Boolean visit(Identifier node) {
		System.out.println("Identifier");
		checkReference(node);
		return null;
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return null;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		return null;
	}
}
