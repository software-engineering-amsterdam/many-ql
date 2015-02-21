package parser.ast.nodes.question;

import parser.ast.nodes.AbstractNode;
import parser.ast.nodes.expression.Expression;

import java.util.Optional;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public class Question implements AbstractNode {

    private final String identifier;
    private final QuestionType questionType;
    private final String label;
    private final Optional<Expression> expression;

    public Question(String identifier, QuestionType questionType, String label, Optional<Expression> expression) {
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.expression = expression;
    }
}
