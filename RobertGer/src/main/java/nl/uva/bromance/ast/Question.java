package nl.uva.bromance.ast;

import nl.uva.bromance.ast.conditionals.CustomResult;
import nl.uva.bromance.ast.conditionals.HasIdentifier;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.ast.questiontypes.*;
import nl.uva.bromance.ast.range.Range;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question extends QLNode implements HasIdentifier {
    private List<StringResult> multipleChoiceOptions = new ArrayList<>();
    private final QuestionType[] questionTypes = {new IntegerType(this), new StringType(this), new BooleanType(this), new CustomType(this)};

    private Identifier identifier;
    private String questionString;
    private QuestionType questionType;
    private Range questionRange;
    private boolean isVisible = true;

    //TODO: Harmonize identifier use and answermap.
    public Question(int lineNumber, Identifier identifier) {
        super(lineNumber);
        this.identifier = identifier;
    }

    public Identifier getIdentifier() {
        return identifier;
    }

    public String getQuestionString() {
        return questionString;
    }

    public Optional<Range> getQuestionRange() {
        return Optional.ofNullable(questionRange);
    }

    public void setQuestionString(String qs) {
        this.questionString = qs.substring(1, qs.length() - 1); // Remove double quotes around the question.
    }

    public void setQuestionType(String qt) {
        qt = qt.toLowerCase();
        for (QuestionType type : questionTypes) {
            if (qt.equals(type.getTypeString())) {
                this.questionType = type;
                this.identifier.setResult(type.getCorrespondingResultType());
                break;
            }
        }
        if (questionType == null) {
            System.err.println("Question Error: Invalid Question type " + qt + ", valid types are :" + Arrays.toString(questionTypes));
        }
    }

    public void setQuestionRange(Range r) {
        this.questionRange = r;
    }

    @Override
    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    //TODO: Not digging the use of instanceof, already better then the strings however.
    public boolean isQuestionTypeBoolean() {
        return questionType instanceof BooleanType;
    }

    public boolean isQuestionTypeString() {
        return questionType instanceof StringType;
    }

    public void setMultipleChoiceOptions(List<TerminalNode> options) {
        for (TerminalNode option : options) {
            String customOption = option.getText();
            customOption = customOption.substring(1, customOption.length() - 1); // Remove double quotes around the question.
            multipleChoiceOptions.add(new StringResult(customOption));
        }
        CustomResult result = new CustomResult(multipleChoiceOptions);
        this.identifier.setResult(result);
        this.identifier.getId();
    }

    //Duplication in all Nodes
    @Override
    public void accept(QLNodeVisitor visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public boolean isVisible() {
        return isVisible;
    }

    public QuestionType getQuestionType() {
        return questionType;
    }

    public List<StringResult> getMultipleChoicesOptions() {
        return multipleChoiceOptions;
    }
}

