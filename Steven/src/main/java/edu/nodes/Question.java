package edu.nodes;


/**
 * Created by Steven Kok on 03/03/2015.
 */
public class Question {
    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private final boolean enabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)

    public Question(Identifier identifier, QuestionType questionType, Label label, boolean enabled) {
        this.identifier = identifier;
        this.questionType = questionType;
        this.label = label;
        this.enabled = enabled;
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
