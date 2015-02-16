package org.fugazi.ast.statement;

import org.fugazi.ast.IASTVisitor;
import org.fugazi.ast.expression.Expression;

import java.util.List;

public class IfStatement extends Statement {

    private final Expression condition;
    
    private final List<Statement> body;

    public IfStatement(Expression _condition, List<Statement> _body) {
        this.condition = _condition;
        this.body = _body;
    }

    public Expression getCondition() {
        return this.condition;
    }

    public List<Statement> getBody() {
        return this.body;
    }

    @Override
    public String toString() {
        String string = "\n if (" + this.condition.toString() + ") {\n";

        for (Statement statement : this.body)
            string += statement.toString();
        string += "\n}";
        
        return string;
    }

    @Override
    public <T> T accept(IASTVisitor<T> visitor) {
        return visitor.visitIfStatement(this);
    }
}