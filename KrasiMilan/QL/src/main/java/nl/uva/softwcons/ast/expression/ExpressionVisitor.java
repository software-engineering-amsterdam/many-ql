package nl.uva.softwcons.ast.expression;

import nl.uva.softwcons.ast.expression.binary.arithmetic.AdditionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.DivisionExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.MultiplicationExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.SubstractionExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.EqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerOrEqualExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerThanExpression;
import nl.uva.softwcons.ast.expression.binary.comparison.NotEqualExpression;
import nl.uva.softwcons.ast.expression.binary.logical.AndExpression;
import nl.uva.softwcons.ast.expression.binary.logical.OrExpression;
import nl.uva.softwcons.ast.expression.identifier.IdentifierExpression;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.arithmetic.NegationExpression;
import nl.uva.softwcons.ast.expression.unary.logical.NotExpression;

public interface ExpressionVisitor<T> {

    /* Binary arithmetic expressions */
    T visit(AdditionExpression expr);

    T visit(DivisionExpression expr);

    T visit(MultiplicationExpression expr);

    T visit(SubstractionExpression expr);

    /* Binary comparison expressions */
    T visit(EqualExpression expr);

    T visit(GreaterOrEqualExpression expr);

    T visit(GreaterThanExpression expr);

    T visit(LowerOrEqualExpression expr);

    T visit(LowerThanExpression expr);

    T visit(NotEqualExpression expr);

    /* Binary logical expressions */
    T visit(AndExpression expr);

    T visit(OrExpression expr);

    /* Unary arithmetic expressions */
    T visit(NegationExpression expr);

    /* Unary logical expressions */
    T visit(NotExpression expr);

    /* Literal and identifier expressions */
    T visit(IdentifierExpression expr);

    T visit(BooleanLiteral expr);

    T visit(IntegerLiteral expr);

    T visit(StringLiteral expr);

    T visit(DecimalLiteral expr);

}
