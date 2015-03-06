package edu.parser.nodes;


import edu.parser.nodes.styles.Style;

import java.util.List;

/**
 * Created by Steven Kok on 03/03/2015.
 */
public class Question {//todo: evaluator should create this type of question not a AbstractNode
    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private final boolean enabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)
    private final List<Style> styles;

    public Question(Identifier identifier, QuestionType questionType, Label label, boolean enabled, List<Style> styles) {
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.enabled = enabled;
        this.styles = styles;
    }

    public List<Style> getStyles() {
        return styles;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public Label getLabel() {
        return label;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return "Question, identifier: " + identifier;
    }
}
