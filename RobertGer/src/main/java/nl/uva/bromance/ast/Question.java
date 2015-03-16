package nl.uva.bromance.ast;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import nl.uva.bromance.ast.conditionals.CustomResult;
import nl.uva.bromance.ast.conditionals.HasIdentifier;
import nl.uva.bromance.ast.conditionals.StringResult;
import nl.uva.bromance.ast.questiontypes.*;
import nl.uva.bromance.ast.range.Range;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckingException;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question extends Node implements HasIdentifier {
    private List<StringResult> multipleChoiceOptions = new ArrayList<>();
    private static final QuestionType[] questionTypes = {new IntegerType(), new StringType(), new BooleanType(), new CustomType()};

    private Identifier identifier;
    private String questionString;
    private QuestionType questionType;
    private Range questionRange;
    private boolean isVisible = true;

    public Question(int lineNumber, Identifier identifier) {
        super(lineNumber, Question.class);
        this.identifier = identifier;
    }

    public Optional<Identifier> getIdentifier() {
        return Optional.ofNullable(identifier);
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
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Question] { Name : " + this.identifier + " , QuestionString: " + this.questionString + " , Type: " + this.questionType + " , range: " + this.questionRange + " }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent) {
        if (isVisible) {
            Label l = new Label(questionString);
            l.getStyleClass().add("prettyLabel");
            parent.getChildren().add(l);
            // Add the actual input field
            questionType.addQuestionToPane(parent, multipleChoiceOptions);
        }
        return Optional.empty();
    }

    @Override
    public void isVisible(boolean visible) {
        this.isVisible = visible;
    }

    //TODO: Think of something to maybe fix this god awful mess of if's
    @Override
    public void typeCheck() throws TypeCheckingException {
        if (getQuestionString() == null) {
            throw new TypeCheckingException("Question Error: No question asked");
        }
        if ((isQuestionTypeBoolean() || isQuestionTypeString()) && getQuestionRange().isPresent()) {
            throw new TypeCheckingException.QuestionRangeTypeCheckingException("TypeChecker Error @ line " + getLineNumber() + ": Question " + getIdentifier() + ", no range allowed for types boolean and string.");
        }
    }

    @Override
    public void addReference(ReferenceMap referenceMap) throws TypeCheckingException {
        if (getIdentifier().isPresent()) {
            if (referenceMap.get(getIdentifier().get().getId()) != null) {
                throw new TypeCheckingException.AlreadyDefinedTypeCheckingException(this, getIdentifier().get().getId());
            } else {
                referenceMap.put(getIdentifier().get().getId(), this);
            }
        } else {
            throw new TypeCheckingException.NoIdentifierDefinedTypeCheckingException(getLineNumber());
        }
    }

    //TODO: Not digging the use of instanceof, already better then the strings however.
    public boolean isQuestionTypeBoolean() {
        return questionType instanceof BooleanType;
    }

    public boolean isQuestionTypeString() {
        return questionType instanceof StringType;
    }

    public boolean isQuestionTypeInteger() {
        return questionType instanceof IntegerType;
    }

    public boolean isQuestionTypeCustom() {
        return questionType instanceof CustomType;
    }

    public void setMultipleChoiceOptions(List<TerminalNode> options) {
        for (TerminalNode option : options) {
            String customOption = option.getText();
            multipleChoiceOptions.add(new StringResult(customOption)); // Remove double quotes around string.
        }
        CustomResult result = new CustomResult(multipleChoiceOptions);
        this.identifier.setResult(result);
        this.identifier.getId();
    }

}

