package nl.uva.bromance.AST;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.Map;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Form extends Node {
    private static final String[] parentsAllowed = {"Questionnaire"};
    private String identifier;

    public Form(int lineNumber, String id) {
        super(lineNumber, "Form");
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Form Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Form] { Name : " + this.identifier + " }\n");
        for (Node n : children) {
            n.printDebug(i + 1);
        }

    }

    @Override
    public Pane visualize(Pane parent) {

        VBox newParent = new VBox();
        Label label = new Label("Form: " + this.identifier);
        label.setStyle("-fx-font-weight: bold;");
        newParent.getChildren().add(label);
        newParent.setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        parent.getChildren().add(newParent);

        return newParent;
    }

    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void typeCheck(Map<String, Node> references, Node node) {
        Form f = (Form) node;
        if (references.get(f.getIdentifier()) == null) {
            references.put(f.getIdentifier(), f);
        } else {
            System.err.println("TypeChecker Error @ line " + f.getLineNumber() + ": Form " + f.getIdentifier() + " was already defined.");
        }
    }
}
