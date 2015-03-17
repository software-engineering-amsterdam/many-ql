package nl.uva.bromance.ast;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckingException;
import nl.uva.bromance.visualization.Visualizer;

import java.util.*;

public class Form extends QLNode implements CanContainConditionals {
    private String identifier;

    private IfStatement ifStatement;
    private List<ElseIfStatement> elseIfStatements = new ArrayList<>();
    private ElseStatement elseStatement;

    public Form(int lineNumber, String id) {
        super(lineNumber, Form.class);
        if (id != null) {
            // Remove double quotes around the identifier
            this.identifier = id.substring(1, id.length() - 1);
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
        for (QLNode n : getChildren()) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent, Map<String, Result> answerMap, Visualizer visualizer) {

        Optional<? extends Pane> newParent = Optional.of(new VBox());
        Label label = new Label(this.identifier);
        label.getStyleClass().add("formHeader");
        newParent.get().getChildren().add(label);
        // Commented out for future usage when generating CSS
        //newParent.get().setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        newParent.get().getStyleClass().add("form");
        parent.getChildren().add(newParent.get());

        return newParent;
    }

    public Optional<String> getIdentifier() {
        return Optional.of(identifier);
    }

    //TODO: Create Identifier class.
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
    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }

}
