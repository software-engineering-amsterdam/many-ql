package nl.uva.softwcons.validation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;
import nl.uva.softwcons.ast.expression.binary.BinaryExpression;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Addition;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Division;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Multiplication;
import nl.uva.softwcons.ast.expression.binary.arithmetic.Subtraction;
import nl.uva.softwcons.ast.expression.binary.comparison.Equal;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterOrEqual;
import nl.uva.softwcons.ast.expression.binary.comparison.GreaterThan;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerOrEqual;
import nl.uva.softwcons.ast.expression.binary.comparison.LowerThan;
import nl.uva.softwcons.ast.expression.binary.comparison.NotEqual;
import nl.uva.softwcons.ast.expression.binary.logical.And;
import nl.uva.softwcons.ast.expression.binary.logical.Or;
import nl.uva.softwcons.ast.expression.identifier.Identifier;
import nl.uva.softwcons.ast.expression.literal.BooleanLiteral;
import nl.uva.softwcons.ast.expression.literal.DecimalLiteral;
import nl.uva.softwcons.ast.expression.literal.IntegerLiteral;
import nl.uva.softwcons.ast.expression.literal.StringLiteral;
import nl.uva.softwcons.ast.expression.unary.UnaryExpression;
import nl.uva.softwcons.ast.expression.unary.logical.Not;

public class VariableExctractor implements ExpressionVisitor<Set<String>> {

    private VariableExctractor() {
    }

    public static Set<String> extractFrom(final Expression expression) {
        return expression.accept(new VariableExctractor());
    }

    @Override
    public Set<String> visit(Addition expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Division expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Multiplication expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Subtraction expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Equal expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(GreaterOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(GreaterThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(LowerOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(LowerThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(NotEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(And expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Or expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Not expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<String> visit(Identifier expr) {
        final String variable = expr.getName();

        return new HashSet<>(Arrays.asList(variable));
    }

    @Override
    public Set<String> visit(BooleanLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(IntegerLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(StringLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<String> visit(DecimalLiteral expr) {
        return new HashSet<>();
    }

    private Set<String> extractVariablesFrom(final BinaryExpression expr) {
        Set<String> variablesInExpression = expr.getLeftExpression().accept(this);
        Set<String> variablesInOtherExpression = expr.getRightExpression().accept(this);
        variablesInExpression.addAll(variablesInOtherExpression);

        return variablesInExpression;
    }

    private Set<String> extractVariablesFrom(final UnaryExpression expr) {
        return expr.getExpression().accept(this);
    }
}
