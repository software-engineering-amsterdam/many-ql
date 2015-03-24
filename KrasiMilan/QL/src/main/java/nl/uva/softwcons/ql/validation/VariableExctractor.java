package nl.uva.softwcons.ql.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import nl.uva.softwcons.ql.ast.expression.Expression;
import nl.uva.softwcons.ql.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ql.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ql.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.Equal;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.GreaterThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerOrEqual;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.LowerThan;
import nl.uva.softwcons.ql.ast.expression.binary.comparison.NotEqual;
import nl.uva.softwcons.ql.ast.expression.binary.logical.And;
import nl.uva.softwcons.ql.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ql.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.NumberLiteral;
import nl.uva.softwcons.ql.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ql.ast.expression.unary.logical.Not;

public final class VariableExctractor implements ExpressionVisitor<Set<Identifier>> {

    private VariableExctractor() {
    }

    public static Set<Identifier> extractFrom(final Expression expression) {
        return expression.accept(new VariableExctractor());
    }

    @Override
    public Set<Identifier> visit(final Addition expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Division expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Multiplication expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Subtraction expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Equal expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final GreaterOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final GreaterThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final LowerOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final LowerThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final NotEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final And expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Or expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(final Not expr) {
        return visitUnaryOperand(expr);
    }

    @Override
    public Set<Identifier> visit(final Identifier questionId) {
        return new HashSet<>(Arrays.asList(questionId));
    }

    @Override
    public Set<Identifier> visit(final BooleanLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<Identifier> visit(final StringLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<Identifier> visit(final NumberLiteral expr) {
        return new HashSet<>();
    }

    private Set<Identifier> extractVariablesFrom(final BinaryExpression expr) {
        final Set<Identifier> variables = visitLeftOperand(expr);
        variables.addAll(visitRightOperand(expr));

        return variables;
    }

}
