package org.fugazi.ast.Statement;

import org.fugazi.ast.Expression.LogicalExpression;

import java.util.List;

public class IfStatement extends Statement{

    private LogicalExpression condition;
    private List<IfStatement> nestedIfStatements;
    private List<QuestionStatement> questions;

    public IfStatement(LogicalExpression condition,
                       List<IfStatement> nestedIfStatements, List<QuestionStatement> questions) {
        this.condition = condition;
        this.nestedIfStatements = nestedIfStatements;
        this.questions = questions;
    }

    public LogicalExpression getCondition() {
        return this.condition;
    }

    public List<IfStatement> getNestedIfStatements() {
        return this.nestedIfStatements;
    }

    public List<QuestionStatement> getQuestions() {
        return this.questions;
    }
}