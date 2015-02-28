package edu.parser.QL.nodes.question;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.parser.AbstractNode;
import edu.parser.QL.Visitor;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public enum QuestionType implements AbstractNode<Visitor> {
    STRING("STRING"), INTEGER("INTEGER"), BOOLEAN("BOOLEAN"), DATE("DATE"), MONEY("MONEY"), DECIMAL("DECIMAL");

    private final String type;

    QuestionType(String type) {
        this.type = type;
    }

    @Override
    public AbstractNode accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public static QuestionType getType(String type) throws InvalidArgumentException {
        for (QuestionType questionType : values()) {
            if (questionType.type.equals(type)) {
                return questionType;
            }
        }
        throw new InvalidArgumentException(new String[]{"Cannot find type for input: " + type});
    }
}
