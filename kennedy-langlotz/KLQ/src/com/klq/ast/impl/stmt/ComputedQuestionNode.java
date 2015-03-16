package com.klq.ast.impl.stmt;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.Location;
import com.klq.ast.impl.expr.AExpression;

/**
 * Created by juriaan on 17-2-15.
 */
public class ComputedQuestionNode extends QuestionNode {
    private AExpression computedAnswer;

    public ComputedQuestionNode(String questionID, String questionType, String text, AExpression computedAnswer, Location location) {
        super(questionID, questionType, text, location);
        this.computedAnswer = computedAnswer;
    }

    public ComputedQuestionNode(String questionID, String questionType, String text, AExpression computedAnswer) {
        super(questionID, questionType, text);
        this.computedAnswer = computedAnswer;
    }

    public AExpression getComputedAnswer() {
        return computedAnswer;
    }

    @Override
    public void printSelf() {
        super.printSelf();
        System.out.printf("Child class: %s", computedAnswer.getClass());
        System.out.println();
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }

}
