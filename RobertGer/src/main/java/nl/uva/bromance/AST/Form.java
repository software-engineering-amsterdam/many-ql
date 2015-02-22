package nl.uva.bromance.AST;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.uva.bromance.AST.Conditionals.CanContainConditionals;
import nl.uva.bromance.AST.Conditionals.ElseIfStatement;
import nl.uva.bromance.AST.Conditionals.ElseStatement;
import nl.uva.bromance.AST.Conditionals.IfStatement;
import nl.uva.bromance.typechecking.TypeCheckingException;

import java.util.*;

public class Form extends Node implements CanContainConditionals {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Questionnaire.class));
    private String identifier;

    private IfStatement ifStatement;
    private List<ElseIfStatement> elseIfStatements = new ArrayList<>();
    private ElseStatement elseStatement;

    public Form(int lineNumber, String id) {
        super(lineNumber, Form.class);
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            //TODO: Consider putting this in the type checker.
            System.err.println("Form Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Form] { Name : " + this.identifier + " }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent) {

        Optional<? extends Pane> newParent = Optional.of(new VBox());
        Label label = new Label("Form: " + this.identifier);
        label.setStyle("-fx-font-weight: bold;");
        newParent.get().getChildren().add(label);
        newParent.get().setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        parent.getChildren().add(newParent.get());

        return newParent;
    }

    public Optional<String> getIdentifier() {
        return Optional.of(identifier);
    }

    @Override
    public void typeCheck(Map<String, Node> references) throws TypeCheckingException {
        if (getIdentifier().isPresent()) {
            if (references.get(getIdentifier().get()) != null) {
                throw new TypeCheckingException.AlreadyDefinedTypeCheckingException(this, getIdentifier().get());
            } else {
                references.put(getIdentifier().get(), this);
            }
        } else
            throw new TypeCheckingException.NoIdentifierDefinedTypeCheckingException(getLineNumber());
    }


    @Override
    public Optional<IfStatement> getIfsStatement() {
        return Optional.of(ifStatement);
    }

    public void setIfStatement(IfStatement ifStatement) {
        this.ifStatement = ifStatement;
    }

    @Override
    public Optional<List<ElseIfStatement>> getElseIfStatement() {
        return Optional.of(elseIfStatements);
    }

    @Override
    public void setElseIfStatement(ElseIfStatement eifs) {
        elseIfStatements.addAll(Arrays.asList(eifs));
    }

    @Override
    public Optional<ElseStatement> getElseStatement() {
        return Optional.of(elseStatement);
    }

    @Override
    public void setElseStatement(ElseStatement es) {
        elseStatement = es;
    }
}
