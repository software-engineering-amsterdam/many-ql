package uva.sc.ql.typeChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.sc.core.INode;
import uva.sc.core.types.Boolean;
import uva.sc.core.types.Number;
import uva.sc.core.types.Type;
import uva.sc.core.types.Undefined;
import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.expression.*;
import uva.sc.ql.expression.binaryExpressions.*;
import uva.sc.ql.expression.unaryExpressions.*;
import uva.sc.ql.form.Form;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

public class TypeCheckerVisitor implements IQLFormNodeVisitor<INode>, IQLStatementNodeVisitor<INode>, IQLExpressionNodeVisitor<INode> {

    List<String> errors;
    List<String> warnings;
    List<String> circularDependencies;
    List<String> questionLabels;
    String currentQuestion;

    Map<String, Type> symbolTable = new HashMap<String, Type>();

    // getters
    public List<String> getErrors() {
	return errors;
    }

    public List<String> getWarnings() {
	return warnings;
    }

    public Map<String, Type> getSymbolTable() {
	return symbolTable;
    }

    // constructor
    public TypeCheckerVisitor() {
	questionLabels = new ArrayList<String>();
	errors = new ArrayList<String>();
	warnings = new ArrayList<String>();
	circularDependencies = new ArrayList<String>();
    }

    // visit methods
    public Form visit(Form questionnaire) {
	String id = questionnaire.getId().getValue();
	symbolTable.put(id, null);

	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public Question visit(Question question) {
	currentQuestion = question.getId().getValue();
	String questionLabel = question.getStr();
	Type type = question.getType();
	if (!this.symbolTable.containsKey(currentQuestion)) {
	    symbolTable.put(currentQuestion, type);
	} else {
	    this.errors.add("Dupilcate variable " + currentQuestion);
	}

	if (questionLabels.contains(questionLabel)) {
	    warnings.add("Duplicate question label <" + questionLabel + ">");
	} else {
	    questionLabels.add(questionLabel);
	}

	Expression expr = question.getExpr();
	if (expr != null) {
	    expr.accept(this);
	}

	currentQuestion = "";
	return null;
    }

    public Type visit(ID id) {
	String identity = id.getValue();
	Type result = new Undefined();
	if (!symbolTable.containsKey(identity)) {
	    errors.add("The variable " + identity
		    + " is used but has not been declared.");
	} else {
	    result = symbolTable.get(identity);
	    if (currentQuestion.equals(identity)) {
		errors.add("Circular dependency has been detected in question with identifier "
			+ identity);
	    }
	}
	return result;
    }

    public IfStatement visit(IfStatement ifStatement) {
	Expression expr = ifStatement.getExpr();
	Type t = (Type) expr.accept(this);
	if (t.equals(new Boolean())) {
	    errors.add("Type missmatch cannot convert from " + t.getClass()
		    + " to " + Boolean.class);
	}
	List<Question> questions = ifStatement.getQuestions();
	for (Question question : questions)
	    question.accept(this);
	return null;
    }

    /* ---------------------- Arithmetic Type Checking ------------------------ */

    public Type arithmeticTypeCheck(BinaryExpression arithmetic) {
	Expression expr1 = (Expression) arithmetic.getFirstOperand();
	Expression expr2 = (Expression) arithmetic.getSecondOperand();
	Type firstOperandType = (Type) expr1.accept(this);
	Type secondOperandType = (Type) expr2.accept(this);
	if (!(firstOperandType.equals(new Number()) && secondOperandType
		.equals(new Number()))) {
	    errors.add("Arithmetic operations only allow operands of type "
		    + Number.class);
	}
	return new Number();
    }

    public Type visit(Addition addition) {
	return arithmeticTypeCheck(addition);
    }

    public Type visit(Substraction sub) {
	return arithmeticTypeCheck(sub);
    }

    public Type visit(Division division) {
	return arithmeticTypeCheck(division);
    }

    public Type visit(GreaterThan greaterThan) {
	return arithmeticTypeCheck(greaterThan);
    }

    public Type visit(GreaterThanEquals greaterThanEquals) {
	return arithmeticTypeCheck(greaterThanEquals);
    }

    public Type visit(LesserThan lesserThan) {
	return arithmeticTypeCheck(lesserThan);
    }

    public Type visit(LesserThanEquals lesserThanEquals) {
	return arithmeticTypeCheck(lesserThanEquals);
    }

    public Type visit(Modulus mod) {
	return arithmeticTypeCheck(mod);
    }

    public Type visit(Multiplication mult) {
	return arithmeticTypeCheck(mult);
    }

    /* ======================================================================== */

    /* ------------------------ Equality Type Checking ------------------------ */

    private Type equalityTypeCheck(BinaryExpression equals) {
	Expression expr1 = (Expression) equals.getFirstOperand();
	Expression expr2 = (Expression) equals.getSecondOperand();
	Type firstOperandType = (Type) expr1.accept(this);
	Type secondOperandType = (Type) expr2.accept(this);
	if (!firstOperandType.equals(secondOperandType)) {
	    errors.add("Type " + secondOperandType.getClass()
		    + " cannot be resolved to " + firstOperandType.getClass());
	}
	return firstOperandType;
    }

    public Type visit(Equals equals) {
	return equalityTypeCheck(equals);
    }

    public Type visit(NotEquals notEquals) {
	return equalityTypeCheck(notEquals);
    }

    /* ======================================================================== */

    /* ----------------------- Boolean Type Checking -------------------------- */

    public Type booleanTypeCheck(BinaryExpression bool) {
	Expression expr1 = bool.getFirstOperand();
	Expression expr2 = bool.getSecondOperand();
	Type firstOperandType = (Type) expr1.accept(this);
	Type secondOperandType = (Type) expr2.accept(this);
	if (!(firstOperandType.equals(new Boolean()) && secondOperandType
		.equals(new Boolean()))) {
	    errors.add("Boolean expressions only allow operands of type "
		    + Boolean.class);
	}
	return new Boolean();
    }

    public Type visit(And and) {
	return booleanTypeCheck(and);
    }

    public Type visit(Or or) {
	return booleanTypeCheck(or);
    }

    /* ======================================================================== */

    /* ---------------------- Unary Type Checking ----------------------------- */

    public Type visit(Minus minus) {
	Expression expr = (Expression) minus.getOperand();
	Type typeOperand = (Type) expr.accept(this);
	if (!typeOperand.equals(new Boolean())) {
	    errors.add("Type missmatch got " + typeOperand.getClass()
		    + " but expected " + Number.class);
	}
	return typeOperand;
    }

    public Type visit(Not not) {
	Expression expr = (Expression) not.getOperand();
	Type typeOperand = (Type) expr.accept(this);
	if (typeOperand.equals(new Boolean())) {
	    errors.add("Type missmatch got " + typeOperand.getClass()
		    + " but expected " + Boolean.class);
	}
	return typeOperand;
    }

    /* ======================================================================== */

    public Type visit(BooleanAtom bool) {
	return new Boolean();
    }

    public Type visit(NumberAtom doub) {
	return new Number();
    }

    public Type visit(StringAtom str) {
	return new uva.sc.core.types.String();
    }
}
