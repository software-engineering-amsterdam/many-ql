package org.uva.ql.typecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.uva.ql.ast.expression.association.Parenthese;
import org.uva.ql.ast.expression.binary.And;
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
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.typecheck.message.Error;
import org.uva.ql.typecheck.message.Warning;
import org.uva.ql.visitor.Visitor;

public class TypeChecker implements Visitor<Void> {

	private final Map<Identifier, Type> types;
	private final ArrayList<String> labels;
	private final MessageManager messageManager;
	
	public TypeChecker() {
		types = new HashMap<Identifier, Type>();
		labels = new ArrayList<String>();
		messageManager = new MessageManager();
	}

// Type list	
	public void addType(Identifier identifier, Type type) {
		types.put(identifier, type);
	}
	
	public boolean isDeclared(Identifier identifier) {
		return types.containsKey(identifier);
	}
	
	public Type getType(Identifier identifier) {
		if (isDeclared(identifier)) {
			return types.get(identifier);
		} else {
			System.out.println("Identifier <" + identifier + "> does not exist.");
			return null;
		}
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

	
	
	
// Visits
	
	@Override
	public Void visit(Questionnaire questionnaire) {
		System.out.println("Questionnaire");
		for (Form form : questionnaire.getForms()) {
			form.accept(this);
		}
		return null;
	}
	
	@Override
	public Void visit(Form form) {
		System.out.println("Form");
		form.getBlock().accept(this);
		return null;
	}

	@Override
	public Void visit(Block block) {
		for (Statement statement : block.getStatements()) {
			statement.accept(this);
		}
		return null;
	}
	
	@Override
	public Void visit(QuestionNormal question) {
		System.out.println("Question Normal");
		addType(question.getIdentifier(), question.getType());
		checkLabel(question);
		return null;
	}
	
	@Override
	public Void visit(QuestionCompute question) {
		System.out.println("Question Compute");
		addType(question.getIdentifier(), question.getType());
		checkLabel(question);
		return null;
	}
	
	@Override
	public Void visit(IfStatement ifStatement) {
		System.out.println("If Statement");
		ifStatement.getExpr().accept(this);
		ifStatement.getIfBlock().accept(this);
		return null;
	}

	@Override
	public Void visit(IfElseStatement ifElseStatement) {
		System.out.println("If Else Statement");
		ifElseStatement.getIfBlock().accept(this);
		ifElseStatement.getElseBLock().accept(this);
		return null;
	}
	
	@Override
	public Void visit(Parenthese node) {
		return node.getExpression().accept(this);
	}
	
	
	@Override
	public Void visit(Not node) {
		return null;
	}

	@Override
	public Void visit(Positive node) {
		return null;
	}

	@Override
	public Void visit(Negative node) {
		return null;
	}

	@Override
	public Void visit(Plus node) {
		
		return null;
	}

	@Override
	public Void visit(Minus node) {
		return null;
	}

	@Override
	public Void visit(Multiply node) {
		return null;
	}

	@Override
	public Void visit(Divide node) {
		return null;
	}

	@Override
	public Void visit(And node) {
		return null;
	}

	@Override
	public Void visit(Or node) {
		return null;
	}

	@Override
	public Void visit(Equal node) {
		return null;
	}

	@Override
	public Void visit(NotEqual node) {
		return null;
	}

	@Override
	public Void visit(Greater node) {
		return null;
	}

	@Override
	public Void visit(GreaterEqual node) {
		return null;
	}

	@Override
	public Void visit(Less node) {
		
		return null;
	}

	@Override
	public Void visit(LessEqual node) {
		return null;
	}

	@Override
	public Void visit(Identifier node) {
		System.out.println("Identifier");
		checkReference(node);
		return null;
	}

	@Override
	public Void visit(IntLiteral node) {
		return null;
	}

	@Override
	public Void visit(BoolLiteral node) {
		return null;
	}

	@Override
	public Void visit(StrLiteral node) {
		return null;
	}

	@Override
	public Void visit(IntType node) {
		return null;
	}

	@Override
	public Void visit(BoolType node) {
		return null;
	}

	@Override
	public Void visit(StrType node) {
		return null;
	}

}
