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

public class VariableExctractor implements ExpressionVisitor<Set<Identifier>> {

    private VariableExctractor() {
    }

    public static Set<Identifier> extractFrom(final Expression expression) {
        return expression.accept(new VariableExctractor());
    }

    @Override
    public Set<Identifier> visit(Addition expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Division expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Multiplication expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Subtraction expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Equal expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(GreaterOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(GreaterThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(LowerOrEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(LowerThan expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(NotEqual expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(And expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Or expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Not expr) {
        return extractVariablesFrom(expr);
    }

    @Override
    public Set<Identifier> visit(Identifier questionId) {
        return new HashSet<>(Arrays.asList(questionId));
    }

    @Override
    public Set<Identifier> visit(BooleanLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<Identifier> visit(IntegerLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<Identifier> visit(StringLiteral expr) {
        return new HashSet<>();
    }

    @Override
    public Set<Identifier> visit(DecimalLiteral expr) {
        return new HashSet<>();
    }

    private Set<Identifier> extractVariablesFrom(final BinaryExpression expr) {
        Set<Identifier> variablesInExpression = expr.getLeftExpression().accept(this);
        Set<Identifier> variablesInOtherExpression = expr.getRightExpression().accept(this);
        variablesInExpression.addAll(variablesInOtherExpression);

        return variablesInExpression;
    }

    private Set<Identifier> extractVariablesFrom(final UnaryExpression expr) {
        return expr.getExpression().accept(this);
    }
}
