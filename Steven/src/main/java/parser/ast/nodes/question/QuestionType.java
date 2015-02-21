package parser.ast.nodes.question;

import exceptions.NoSuchType;
import parser.ast.nodes.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public enum QuestionType implements AbstractNode {
    STRING("STRING"), INTEGER("INTEGER"), BOOLEAN("BOOLEAN"), DATE("DATE"), MONEY("MONEY"), DECIMAL("DECIMAL");

    private final String type;

    QuestionType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static QuestionType getQuestionType(String type) throws NoSuchType {
        for (QuestionType questionType : QuestionType.values()) {
            if (questionType.getType().equals(type)) {
                return questionType;
            }
        }
        throw new NoSuchType("Question has no type for: " + type);
    }
}
