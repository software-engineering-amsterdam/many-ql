package org.fugazi.ast.Statement;

import org.fugazi.ast.Expression.Expression;
import org.fugazi.ast.IASTVisitor;

import java.util.ArrayList;

public class IfStatement extends Statement {

    private Expression condition;
    
    private ArrayList<Statement> statements;

    public IfStatement(Expression _condition, ArrayList<Statement> _statements) {
        this.condition = _condition;
        this.statements = _statements;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public ArrayList<Statement> getStatements() {
        return this.statements;
    }

    @Override
    public String toString() {
        String string = "\n if (" + this.condition.toString() + ") {\n";

        for (Statement statement : this.statements)
            string += statement.toString();
        string += "\n}";
        
        return string;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitIfStatement(this);
    }
}