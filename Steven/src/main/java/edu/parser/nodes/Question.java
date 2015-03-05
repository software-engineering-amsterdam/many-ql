package edu.parser.nodes;


/**
 * Created by Steven Kok on 03/03/2015.
 */
public class Question {//todo: evaluator should create this type of question not a AbstractNode
    private final Identifier identifier;
    private final QuestionType questionType;
    private final Label label;
    private boolean enabled; //todo should receive enum State (enabled/disables/unselected/non-boolean)

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
}
