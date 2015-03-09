package nl.uva.bromance.ast;

import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class QLSSection extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(QLSPage.class));
	private String identifier;
    public QLSSection(int lineNumber, String id) {
        super(lineNumber, QLSSection.class);
        super.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public Optional<? extends Pane> visualize(Pane parent) {
        Optional<? extends Pane> newParent = Optional.of(new VBox());
        javafx.scene.control.Label label = new javafx.scene.control.Label(this.identifier);
        label.getStyleClass().add("formHeader");
        newParent.get().getChildren().add(label);
        for (Node child: this.getChildren()) {
            child.visualize(newParent.get());
        }
        // Commented out for future usage when generating CSS
        //newParent.get().setStyle("-fx-border-color: #000000; -fx-border-style: solid;");
        newParent.get().getStyleClass().add("form");
        parent.getChildren().add(newParent.get());
        return newParent;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Section] { Name: "+identifier+" }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}
