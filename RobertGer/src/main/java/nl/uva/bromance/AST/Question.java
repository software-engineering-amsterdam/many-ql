package nl.uva.bromance.AST;

import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import nl.uva.bromance.AST.Conditionals.ElseIfStatement;
import nl.uva.bromance.AST.Conditionals.ElseStatement;
import nl.uva.bromance.AST.Conditionals.IfStatement;
import nl.uva.bromance.AST.Range.Range;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckingException;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Question extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(Form.class, IfStatement.class, ElseStatement.class, ElseIfStatement.class));
    private List<String> customQuestionOptions = new ArrayList<>();
    private static final String[] questionTypes = {"integer", "string", "boolean", "custom"};

    private String identifier;
    private String questionString;
    private String questionType;
    private Range questionRange;

    public Question(int lineNumber, String id) {
        super(lineNumber, Question.class);
        this.setAcceptedParents(parentsAllowed);
        this.identifier = id.substring(1, id.length() - 1);
    }

    public Optional<String> getIdentifier() {
        return Optional.ofNullable(identifier);
    }

    public String getQuestionString() {
        return questionString;
    }

    public Optional<Range> getQuestionRange() {
        return Optional.ofNullable(questionRange);
    }

    public void setQuestionString(String qs) {
        this.questionString = qs;
    }

    public void setQuestionType(String qt) {
        qt = qt.toLowerCase();
        boolean valid = false;
        for (String type : questionTypes) {
            if (type.equals(qt)) {
                valid = true;
                break;
            }
        }
        if (valid) {
            this.questionType = qt;
        } else {
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
        System.out.print("[Question] { Name : " + this.identifier + " , QuestionString: " + this.questionString + " , Type: " + this.questionType + " , Range: " + this.questionRange + " }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent) {
        parent.getChildren().add(new Label(questionString));
        if (isQuestionTypeInteger()) {
            parent.getChildren().add(new TextField());
        } else if (isQuestionTypeString()) {
            parent.getChildren().add(new TextField());
        } else if (isQuestionTypeBoolean()) {
            parent.getChildren().add(new CheckBox());
        } else if (isQuestionTypeCustom()) {
            ToggleGroup group = new ToggleGroup();
            for (String option : customQuestionOptions) {
                RadioButton radioButton = new RadioButton(option);
                radioButton.setToggleGroup(group);
                parent.getChildren().add(radioButton);
            }
        }
        return Optional.empty();
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
            if (referenceMap.get(getIdentifier().get()) != null) {
                throw new TypeCheckingException.AlreadyDefinedTypeCheckingException(this, getIdentifier().get());
            } else {
                referenceMap.put(getIdentifier().get(), this);
            }
        } else {
            throw new TypeCheckingException.NoIdentifierDefinedTypeCheckingException(getLineNumber());
        }
    }

    //TODO: Not digging the string checks for types. Need to sort this out at one point.
    public boolean isQuestionTypeBoolean() {
        return "boolean".equals(questionType) || "Boolean".equals(questionType);
    }

    public boolean isQuestionTypeString() {
        return "string".equals(questionType) || "String".equals(questionType);
    }

    public boolean isQuestionTypeInteger() {
        return "integer".equals(questionType) || "Integer".equals(questionType);
    }


    public boolean isQuestionTypeCustom() {
        return "custom".equals(questionType) || "Custom".equals(questionType);
    }

    public void setCustomQuestionOptions(List<TerminalNode> options) {
        for (TerminalNode option : options) {
            customQuestionOptions.add(option.getText());
        }

    }

}

