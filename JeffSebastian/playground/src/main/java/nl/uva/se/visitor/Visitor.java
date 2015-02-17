package nl.uva.se.visitor;

import nl.uva.se.ast.Node;
import nl.uva.se.ast.expression.LogicalOperators.And;
import nl.uva.se.ast.expression.LogicalOperators.Equal;
import nl.uva.se.ast.expression.LogicalOperators.GreaterOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.GreaterThen;
import nl.uva.se.ast.expression.LogicalOperators.LessOrEqual;
import nl.uva.se.ast.expression.LogicalOperators.LessThen;
import nl.uva.se.ast.expression.LogicalOperators.Not;
import nl.uva.se.ast.expression.LogicalOperators.NotEqual;
import nl.uva.se.ast.expression.LogicalOperators.Or;
import nl.uva.se.ast.expression.MathematicalOperators.Addition;
import nl.uva.se.ast.expression.MathematicalOperators.Divide;
import nl.uva.se.ast.expression.MathematicalOperators.Modulo;
import nl.uva.se.ast.expression.MathematicalOperators.Multiply;
import nl.uva.se.ast.expression.MathematicalOperators.Power;
import nl.uva.se.ast.expression.MathematicalOperators.Substraction;
import nl.uva.se.ast.form.Form;
import nl.uva.se.ast.literal.BooleanLiteral;
import nl.uva.se.ast.literal.DecimalLiteral;
import nl.uva.se.ast.literal.IntegerLiteral;
import nl.uva.se.ast.literal.StringLiteral;
import nl.uva.se.ast.statement.CalculatedQuestion;
import nl.uva.se.ast.statement.Condition;
import nl.uva.se.ast.statement.Question;

public interface Visitor {
	
	public void visit(Form form);
	public void visit(Question question);
	public void visit(CalculatedQuestion calculatedQuestion);
	public void visit(Condition condition);
	public void visit(Not not);
	public void visit(NotEqual notEqual);
	public void visit(Or or);
	public void visit(Addition plus);
	public void visit(Power power);
	public void visit(Multiply multiply);
	public void visit(Modulo modulo);
	public void visit(Substraction minus);
	public void visit(LessThen lessThen);
	public void visit(LessOrEqual lessOrEqual);
	public void visit(GreaterThen greaterThen);
	public void visit(GreaterOrEqual greaterOrEqual);
	public void visit(Equal equal);
	public void visit(Divide divide);
	public void visit(And and);
	public void visit(BooleanLiteral booleanLiteral);
	public void visit(DecimalLiteral decimalLiteral);
	public void visit(IntegerLiteral integerLiteral);
	public void visit(StringLiteral stringLiteral);
}
