package uva.sc.ql.typeChecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uva.sc.core.INode;
import uva.sc.core.errors.Arithmetic;
import uva.sc.core.errors.CyclicDependency;
import uva.sc.core.errors.DuplicatedID;
import uva.sc.core.errors.IError;
import uva.sc.core.errors.TypeMissmatch;
import uva.sc.core.errors.UndefinedID;
import uva.sc.core.types.Boolean;
import uva.sc.core.types.Number;
import uva.sc.core.types.Type;
import uva.sc.core.types.Undefined;
import uva.sc.core.warnings.DuplicatedLabel;
import uva.sc.core.warnings.IWarning;
import uva.sc.ql.ast.IQLExpressionNodeVisitor;
import uva.sc.ql.ast.IQLFormNodeVisitor;
import uva.sc.ql.ast.IQLStatementNodeVisitor;
import uva.sc.ql.atom.BooleanAtom;
import uva.sc.ql.atom.ID;
import uva.sc.ql.atom.NumberAtom;
import uva.sc.ql.atom.StringAtom;
import uva.sc.ql.expression.Expression;
import uva.sc.ql.expression.binaryExpressions.Addition;
import uva.sc.ql.expression.binaryExpressions.And;
import uva.sc.ql.expression.binaryExpressions.BinaryExpression;
import uva.sc.ql.expression.binaryExpressions.Division;
import uva.sc.ql.expression.binaryExpressions.Equals;
import uva.sc.ql.expression.binaryExpressions.GreaterThan;
import uva.sc.ql.expression.binaryExpressions.GreaterThanEquals;
import uva.sc.ql.expression.binaryExpressions.LesserThan;
import uva.sc.ql.expression.binaryExpressions.LesserThanEquals;
import uva.sc.ql.expression.binaryExpressions.Modulus;
import uva.sc.ql.expression.binaryExpressions.Multiplication;
import uva.sc.ql.expression.binaryExpressions.NotEquals;
import uva.sc.ql.expression.binaryExpressions.Or;
import uva.sc.ql.expression.binaryExpressions.Substraction;
import uva.sc.ql.expression.unaryExpressions.Minus;
import uva.sc.ql.expression.unaryExpressions.Not;
import uva.sc.ql.form.Form;
import uva.sc.ql.statements.IfStatement;
import uva.sc.ql.statements.Question;
import uva.sc.ql.statements.Statement;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TypeCheckerVisitor implements IQLFormNodeVisitor<INode>,
	IQLStatementNodeVisitor<INode>, IQLExpressionNodeVisitor<INode> {

    List<IError> errors;
    List<IWarning> warnings;
    List<String> questionLabels;
    ID currentQuestion;

    Map<ID, Type> symbolTable = new HashMap<ID, Type>();

    // getters
    public List<IError> getErrors() {
	return errors;
    }

    public List<IWarning> getWarnings() {
	return warnings;
    }

    public Map<ID, Type> getSymbolTable() {
	return symbolTable;
    }

    // constructor
    public TypeCheckerVisitor() {
	questionLabels = new ArrayList<String>();
	errors = new ArrayList<IError>();
	warnings = new ArrayList<IWarning>();
    }

    // visit methods
    public Form visit(Form questionnaire) {
	ID id = questionnaire.getId();
	symbolTable.put(id, null);

	List<Statement> statements = questionnaire.getStatements();
	for (Statement statement : statements) {
	    statement.accept(this);
	}
	return null;
    }

    public Question visit(Question question) {
	currentQuestion = question.getId();
	String questionLabel = question.getStr();
	Type type = question.getType();
	if (!this.symbolTable.containsKey(currentQuestion)) {
	    symbolTable.put(currentQuestion, type);
	} else {
	    errors.add(new DuplicatedID(currentQuestion));
	}

	if (questionLabels.contains(questionLabel)) {
	    warnings.add(new DuplicatedLabel(questionLabel));
	} else {
	    questionLabels.add(questionLabel);
	}

	Expression expr = question.getExpr();
	if (expr != null) {
	    expr.accept(this);
	}

	currentQuestion = null;
	return null;
    }

    public Type visit(ID id) {
	Type result = new Undefined();
	if (!symbolTable.containsKey(id)) {
	    errors.add(new UndefinedID(id));
	} else {
	    result = symbolTable.get(id);
	    if (id.equals(currentQuestion)) {
		errors.add(new CyclicDependency(id));
	    }
	}
	return result;
    }

    public IfStatement visit(IfStatement ifStatement) {
	Expression expr = ifStatement.getExpr();
	Type t = (Type) expr.accept(this);
	if (!t.equals(new Boolean())) {
	    errors.add(new TypeMissmatch(t, new Boolean()));
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
	    errors.add(new Arithmetic());
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
	    errors.add(new TypeMissmatch(secondOperandType, firstOperandType));
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
	if (!((new Boolean().equals(firstOperandType)) && (new Boolean().equals(secondOperandType)))) {
	    errors.add(new uva.sc.core.errors.Boolean());
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
	    errors.add(new TypeMissmatch(typeOperand, new Number()));
	}
	return typeOperand;
    }

    public Type visit(Not not) {
	Expression expr = (Expression) not.getOperand();
	Type typeOperand = (Type) expr.accept(this);
	if (typeOperand.equals(new Boolean())) {
	    errors.add(new TypeMissmatch(typeOperand, new Boolean()));
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
