package edu.parser.nodes;

import com.sun.javaws.exceptions.InvalidArgumentException;
import edu.Widgets;
import edu.parser.AbstractNode;

/**
 * Created by Steven Kok on 21/02/2015.
 */
public enum QuestionType implements AbstractNode<edu.parser.Visitor> {
    STRING("STRING", Widgets.TEXT),
    INTEGER("INTEGER", Widgets.SPINBOX, Widgets.TEXT, Widgets.SLIDER),
    BOOLEAN("BOOLEAN", Widgets.YESNO_DROPDOWN, Widgets.YESNO_RADIOS, Widgets.CHECKBOX),
    DATE("DATE", Widgets.TEXT),
    MONEY("MONEY", Widgets.SLIDER, Widgets.TEXT, Widgets.SPINBOX),
    DECIMAL("DECIMAL", Widgets.SPINBOX, Widgets.TEXT, Widgets.SLIDER);

    private final String type;
    private final Widgets[] widgets;

    QuestionType(String type, Widgets... widgets) {
        this.type = type;
        this.widgets = widgets;
    }

    public static QuestionType getType(String type) throws InvalidArgumentException {
        for (QuestionType questionType : values()) {
            if (questionType.type.equals(type)) {
                return questionType;
            }
        }
        throw new InvalidArgumentException(new String[]{"Cannot find type for input: " + type});
    }

    @Override
    public AbstractNode accept(edu.parser.Visitor visitor) {
        return visitor.visit(this);
    }
}
