package org.uva.ql.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.uva.ql.ast.CodePosition;
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
import org.uva.ql.ast.questionnaire.Form;
import org.uva.ql.ast.questionnaire.Questionnaire;
import org.uva.ql.ast.statement.Block;
import org.uva.ql.ast.statement.IfElseStatement;
import org.uva.ql.ast.statement.IfStatement;
import org.uva.ql.ast.statement.QuestionComputed;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.statement.Statement;
import org.uva.ql.ast.type.BoolType;
import org.uva.ql.ast.type.IntType;
import org.uva.ql.ast.type.StrType;
import org.uva.ql.ast.type.Type;
import org.uva.ql.visitor.ExpressionVisitor;
import org.uva.ql.visitor.QuestionnaireVisitor;
import org.uva.ql.visitor.StatementVisitor;
import org.uva.util.message.Error;
import org.uva.util.message.MessageManager;
import org.uva.util.message.Warning;

public class TypeChecker implements StatementVisitor<Boolean>, ExpressionVisitor<Boolean>,
		QuestionnaireVisitor<Boolean> {

	private final Map<Identifier, Type> types;
	private final List<Identifier> questionComputes;
	private final List<String> labels;
	private final MessageManager messageManager;
	private final CyclicChecker cyclicChecker;
	private boolean isCheckingCyclicDependency;

	public TypeChecker() {
		types = new HashMap<Identifier, Type>();
		labels = new ArrayList<String>();
		messageManager = new MessageManager();
		cyclicChecker = new CyclicChecker();
		isCheckingCyclicDependency = false;
		questionComputes = new ArrayList<Identifier>();
	}

	// Name-Type table
	private void addType(Identifier id, Type type) {
		types.put(id, type);
	}

	private boolean isDeclared(Identifier id) {
		return types.containsKey(id);
	}
	
	public Type getType(Identifier id) {
		return types.get(id);
	}


	public void printAll() {
		Set<Identifier> keys = types.keySet();
		for (Iterator<Identifier> i = keys.iterator(); i.hasNext();) {
			String name = (String) i.next().toString();
			String type = types.get(i.next()).toString();
			System.out.println(name + " " + type);
		}
	}

	// Label list
	private void addLabel(String label) {
		labels.add(label);
	}

	private boolean hasLabel(String label) {
		return labels.contains(label);
	}

	// Message Management
	private void addError(Error.Type type, Expression expr) {
		Error error = new Error(type, expr.getPosition().getStartLine(), expr.toString());
		messageManager.addError(error);
	}

	private void addError(Error.Type type, Expression expr, String expectType) {
		Error error = new Error(type, expr.getPosition().getStartLine(), expr.toString(), expectType);
		messageManager.addError(error);
	}

	private void addWarning(Warning warning) {
		messageManager.addWarning(warning);
	}

	private int countErrors() {
		return messageManager.countErrors();
	}

	private int countWarnings() {
		return messageManager.countWarnings();
	}

	public void printMessages() {
		System.out.println("[ERRORS] (" + countErrors() + " items)");
		messageManager.printErrors();
		System.out.println();
		System.out.println("[WARNINGS] (" + countWarnings() + " items)");
		messageManager.printWarnings();
	}

	// Checkers
	private boolean checkLabel(QuestionNormal question) {
		String label = question.getLabel().toString();
		if (hasLabel(label)) {
			Warning warning = new Warning(Warning.Type.DUPLICATE, question.getPosition().getStartLine(), label);
			messageManager.addWarning(warning);
		} else {
			addLabel(label);
		}
		return true;
	}

	private boolean checkDeclaration(QuestionNormal question) {
		if (isDeclared(question.getIdentifier())) {
			Type thisType = question.getType();
			Type expectType = getType(question.getIdentifier());

			if (!thisType.isEqual(expectType)) {
				addError(Error.Type.DECLARATION, question.getIdentifier());
				return false;
			}
		} else {
			addType(question.getIdentifier(), question.getType());
		}
		return true;
	}

	private boolean checkReference(Identifier identifier) {
		if (!isDeclared(identifier)) {
			addError(Error.Type.REFERENCE, identifier);
			return false;
		}
		return true;
	}

	private boolean checkMatch(Expression expr, Type expectType) {
		if (expr.accept(this)) {
			if (!expr.getType(this).isEqual(expectType)) {
				addError(Error.Type.MISMATCH, expr, expectType.toString());
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	private boolean checkMatchThisLevel(Expression expr, Type expectType) {
		boolean result = true;
		if (!expr.getType(this).isEqual(expectType)) {
			addError(Error.Type.MISMATCH, expr, expectType.toString());
			result = false;
		}
		return result;
	}

	private boolean checkBinaryMatch(Binary binary, Type expectType) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		boolean resultLeft = checkMatch(left, expectType);
		boolean resultRight = checkMatch(right, expectType);
		return resultLeft && resultRight;
	}

	private boolean checkSame(Binary binary) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		// Check inner levels then do the comparison
		boolean resultL = left.accept(this);
		boolean resultR = right.accept(this);
		if (resultL && resultR) {
			return checkMatch(right, left.getType(this));
		} else {
			return false;
		}
	}

	// Visits

	@Override
	public Boolean visit(Questionnaire questionnaire) {
		boolean result = true;
		for (Form form : questionnaire.getForms()) {
			if (!form.accept(this)) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public Boolean visit(Form form) {
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
		boolean result1 = checkDeclaration(question);
		boolean result2 = checkLabel(question);
		return result1 && result2;
	}

	@Override
	public Boolean visit(QuestionComputed question) {
		questionComputes.add(question.getIdentifier());
		boolean result1 = checkDeclaration(question);
		boolean result2 = checkLabel(question);
		isCheckingCyclicDependency = true;
		boolean result3 = question.getExpression().accept(this);
		isCheckingCyclicDependency = false;
		return result1 && result2 && result3;
	}

	@Override
	public Boolean visit(IfStatement ifStatement) {
		boolean result1 = ifStatement.getExpr().accept(this);
		boolean result2 = ifStatement.getIfBlock().accept(this);
		return result1 && result2;
	}

	@Override
	public Boolean visit(IfElseStatement ifElseStatement) {
		boolean result1 = ifElseStatement.getExpr().accept(this);
		boolean result2 = ifElseStatement.getIfBlock().accept(this);
		boolean result3 = ifElseStatement.getElseBLock().accept(this);
		return result1 && result2 && result3;
	}

	@Override
	public Boolean visit(Parenthese node) {
		return node.getExpression().accept(this);
	}

	@Override
	public Boolean visit(Not unary) {
		return checkMatch(unary.getExpression(), new BoolType(unary.getPosition()));
	}

	@Override
	public Boolean visit(Positive unary) {
		return checkMatch(unary.getExpression(), new IntType(unary.getPosition()));
	}

	@Override
	public Boolean visit(Negative unary) {
		return checkMatch(unary.getExpression(), new IntType(unary.getPosition()));
	}

	@Override
	public Boolean visit(Plus binary) {
		Expression left = binary.getLeftExpression();
		Expression right = binary.getRightExpression();
		boolean resultL = left.accept(this);
		boolean resultR = right.accept(this);
		boolean result = true;
		CodePosition pos = binary.getPosition();
		if (resultL && resultR) {
			if (left.getType(this).isEqual(new IntType(pos)) || left.getType(this).isEqual(new StrType(pos))) {
				result = checkMatchThisLevel(right, left.getType(this));
			} else {
				if (right.getType(this).isEqual(new BoolType(pos))) {
					Error errorLeft = new Error(Error.Type.MISMATCH, left.getPosition().getStartLine(),
							left.toString(), "Int|Str");
					messageManager.addError(errorLeft);
					Error errorRight = new Error(Error.Type.MISMATCH, right.getPosition().getStartLine(),
							right.toString(), "Int|Str");
					messageManager.addError(errorRight);
				} else {
					result = checkMatchThisLevel(left, right.getType(this));
				}
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	@Override
	public Boolean visit(Minus binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Multiply binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Divide binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Greater binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(GreaterEqual binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Less binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(LessEqual binary) {
		return checkBinaryMatch(binary, new IntType(binary.getPosition()));
	}

	@Override
	public Boolean visit(And binary) {
		return checkBinaryMatch(binary, new BoolType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Or binary) {
		return checkBinaryMatch(binary, new BoolType(binary.getPosition()));
	}

	@Override
	public Boolean visit(Equal binary) {
		return checkSame(binary);
	}

	@Override
	public Boolean visit(NotEqual binary) {
		return checkSame(binary);
	}

	@Override
	public Boolean visit(Identifier node) {
		if (isCheckingCyclicDependency) {
			cyclicChecker.add(node, questionComputes.get(questionComputes.size() - 1));
		}
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

	public boolean check(Questionnaire q) {
		boolean result1 = q.accept(this);
		boolean result2 = cyclicChecker.check(messageManager);
		return result1 && result2;
	}

	public CyclicChecker getCC() {
		return cyclicChecker;
	}
}