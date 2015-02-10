package org.fugazi.ast.Statement;

import org.fugazi.ast.Expression.LogicalExpression;
import java.util.ArrayList;

/**
 * The If Statement class.
 * It is a Node of the AST, and a statement.
 */
public class IfStatement extends Statement {

    // The condition to be checked.
    private LogicalExpression condition;
    
    // The list of the statements that would be executed in case the condition if true.
    private ArrayList<Statement> statements;

    /**
     * Constructor
     * @param _condition The condition to be checked.
     * @param _statements The list of the statements
     */
    public IfStatement(LogicalExpression _condition, ArrayList<Statement> _statements) {
        this.condition = _condition;
        this.statements = _statements;
    }

    /**
     * Get the condition
     * @return condition
     */
    public LogicalExpression getCondition() {
        return this.condition;
    }

    /**
     * Get the list of statements.
     * @return statements
     */
    public ArrayList<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public String toString() {
        return "if (" + this.condition.toString() + ") {\n" + this.statements + "}";
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}