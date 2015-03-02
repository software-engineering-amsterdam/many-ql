package org.uva.ql.typecheck;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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

	private final Map<String, Type> types;
	private final ArrayList<String> labels;
	private final MessageManager messageManager;
	
	public TypeChecker() {
		types = new HashMap<String, Type>();
		labels = new ArrayList<String>();
		messageManager = new MessageManager();
	}

// Name-Type table	
	public void addType(String name, Type type) {
		types.put(name, type);
	}
	
	public Type getType(String name) {
		return types.get(name);
	}

	public boolean isDeclared(String name) {
		return types.containsKey(name);
	}
	
	public void printAll() {
		Set keys = types.keySet();
		for (Iterator i = keys.iterator(); i.hasNext();) {
			String name = (String) i.next();
			String type = types.get(name).toString();
			System.out.println(name + " " + type);
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
	public boolean checkLabel(QuestionNormal question) {
		String label = question.getLabel().getValue();
		if (hasLabel(label)) {
			Warning warning = new Warning(Warning.Type.DUPLICATE, question.getPosition().getStartLine(), label);
			messageManager.addWarning(warning);
		} else {
			addLabel(label);
		}
		return true;
	}
	
	public boolean checkDeclaration(QuestionNormal question) {
		if (isDeclared(question.getIdentifier().toString())) {
			Type thisType = question.getType();
			Type expectType = getType(question.getIdentifier().toString());
			
			if (!thisType.isEqual(expectType)) {
				Error error = new Error(Error.Type.DECLARATION,
						question.getIdentifier().getPosition().getStartLine(),
						question.getIdentifier().toString());
				messageManager.addError(error);
				return false;
			}
		} else {
			addType(question.getIdentifier().toString(), question.getType());
		}
		return true;
	}
	
	public boolean checkReference(Identifier identifier) {
		System.out.println(identifier.toString());
		if (!isDeclared(identifier.toString())) {
			Error error = new Error(Error.Type.REFERENCE, identifier.getPosition().getStartLine(), identifier.toString());
			messageManager.addError(error);
			return false;
		}
		return true;
	}
	
	public boolean checkSameBinary(Binary binary) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		boolean result = true;
		// Makse sure both side will be checked
		boolean resultLeft = left.accept(this);
		boolean resultRight = right.accept(this);
		if (resultLeft && resultRight){
			if (!left.getType(this).isEqual(right.getType(this))) {
				Error error = new Error(Error.Type.CONDITION, right.getPosition().getStartLine(),right.toString());
				messageManager.addError(error);
				result = false;
			}
		} else {
			System.out.println("CM: Expression <" + binary.toString() + "> has type error inside it.");
			result = false;
		}
		return result;
	}

	public boolean checkBool(Expression expr) {
		boolean result = true;
		if (expr.accept(this)){
			if (!expr.getType(this).isEqual(new BoolType())) {
				Error error = new Error(Error.Type.CONDITION, expr.getPosition().getStartLine(),expr.toString());
				messageManager.addError(error);
				result = false;
			}
		} else {
			System.out.println("CB: Expression <" + expr.toString() + "> has type error inside it.");
			result = false;
		}
		return result;
	}
	
	public boolean checkBoolUnary(Unary unary) {
		Expression expr = unary.getExpression();
		return checkBool(expr);
	}
	public boolean checkBoolBinary(Binary binary) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		// Make sure both side will be checked
		boolean resultLeft = checkBool(left);
		boolean resultRight = checkBool(right);
		return resultLeft && resultRight;
	}
	
	public boolean checkInt(Expression expr) {
		boolean result = true;
		// this line make sure the reference comes before this check.
		if (expr.accept(this)){
			if (!expr.getType(this).isEqual(new IntType())) {
				Error error = new Error(Error.Type.OPERAND, expr.getPosition().getStartLine(),expr.toString());
				messageManager.addError(error);
				result = false;
			}
		} else {
			System.out.println("CI: Expression <" + expr.toString() + "> has type error inside it.");
			result = false;
		}
		return result;
	}
	
	public boolean checkIntUnary(Unary unary) {
		Expression expr = unary.getExpression();
		return checkInt(expr);
	}
	
	public boolean checkIntBinary(Binary binary) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		// Make sure both side will be checked
		boolean resultLeft = checkInt(left);
		boolean resultRight = checkInt(right);
		return resultLeft && resultRight;
	}
	

	
	
	
	
// Visits
	
	@Override
	public Boolean visit(Questionnaire questionnaire) {
		System.out.println("Questionnaire");
		boolean result = true;
		for (Form form : questionnaire.getForms()) {
			if(!form.accept(this)) {
				result = false;
			}
		}
		return result;
	}
	
	@Override
	public Boolean visit(Form form) {
		System.out.println("Form");
		//form.getBlock().accept(this);
		return form.getBlock().accept(this);
	}

	@Override
	public Boolean visit(Block block) {
		boolean result = true;
		for (Statement statement : block.getStatements()) {
			if (!statement.accept(this)) {
				result = false;
			}
		}
		return result;
	}
	
	@Override
	public Boolean visit(QuestionNormal question) {
		System.out.println("Question Normal");
		return checkDeclaration(question) && checkLabel(question);
	}
	
	@Override
	public Boolean visit(QuestionCompute question) {
		System.out.println("Question Compute");
		//checkDeclaration(question);
		//checkLabel(question);
		question.getExpression().accept(this);
		
		return checkDeclaration(question) && checkLabel(question);
		//return null;
	}
	
	@Override
	public Boolean visit(IfStatement ifStatement) {
		System.out.println("If Statement");
		//ifStatement.getExpr().accept(this);
		//ifStatement.getIfBlock().accept(this);
		return ifStatement.getExpr().accept(this) && ifStatement.getIfBlock().accept(this);
	}

	@Override
	public Boolean visit(IfElseStatement ifElseStatement) {
		System.out.println("If Else Statement");
		//ifElseStatement.getExpr().accept(this);
		//ifElseStatement.getIfBlock().accept(this);
		//ifElseStatement.getElseBLock().accept(this);
		return ifElseStatement.getExpr().accept(this) 
				&& ifElseStatement.getIfBlock().accept(this) 
				&& ifElseStatement.getElseBLock().accept(this);
	}
	
	@Override
	public Boolean visit(Parenthese node) {
		return node.getExpression().accept(this);
	}
	
	
	@Override
	public Boolean visit(Not node) {
		//checkUnaryCondition(node);
		return checkBoolUnary(node);
	}

	@Override
	public Boolean visit(Positive node) {
		//checkUnaryOperand(node);
		return checkIntUnary(node);
	}

	@Override
	public Boolean visit(Negative node) {
		//checkUnaryOperand(node);
		return checkIntUnary(node);
	}

	@Override
	public Boolean visit(Plus node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(Minus node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(Multiply node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(Divide node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(And node) {
		//checkBinaryCondition(node);
		return checkBoolBinary(node);
	}

	@Override
	public Boolean visit(Or node) {
		//checkBinaryCondition(node);
		return checkBoolBinary(node);
	}

	@Override
	public Boolean visit(Equal node) {
		//checkBinaryCondition(node);
		return checkSameBinary(node);
	}

	@Override
	public Boolean visit(NotEqual node) {
		//checkBinaryCondition(node);
		return checkSameBinary(node);
	}

	@Override
	public Boolean visit(Greater node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(GreaterEqual node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(Less node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(LessEqual node) {
		//checkBinaryOperand(node);
		return checkIntBinary(node);
	}

	@Override
	public Boolean visit(Identifier node) {
		System.out.println("Identifier");
		return checkReference(node);
	}

	@Override
	public Boolean visit(IntLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(BoolLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StrLiteral node) {
		return true;
	}
}
