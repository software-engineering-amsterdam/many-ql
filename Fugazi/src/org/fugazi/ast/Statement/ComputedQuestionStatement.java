package org.fugazi.ast.Statement;

import com.sun.org.apache.xpath.internal.Expression;
import org.fugazi.ast.Literals.ID;
import org.fugazi.ast.Type.Type;

/**
 * The ComputedQuestionStatement class.
 * It is a Node of the AST, and a statement.
 */
public class ComputedQuestionStatement extends QuestionStatement {

    // The computed Expression.
    private Expression computedExpression;

    /**
     * Constructor
     * @param _type the question type
     * @param _label the question display label
     * @param _identifier the question identifier
     * @param _computedExpression the computed Expression.
     */
    public ComputedQuestionStatement(Type _type, String _label, ID _identifier, Expression _computedExpression) {
        super(_type, _label, _identifier);
        this.computedExpression = _computedExpression;
    }

    /**
     * Get the computed Expression.
     * @return value
     */
    public Expression getComputedExpression() {
        return this.computedExpression;
    }

    @Override
    public String toString() {
        return this.type.toString() + this.identifier.toString() + " " + "('" + this.label + "') = " + this.computedExpression;
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof ComputedQuestionStatement;
    }
}
