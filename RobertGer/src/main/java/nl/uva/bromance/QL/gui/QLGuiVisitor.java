package nl.uva.bromance.QL.gui;

import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;

class QLGuiVisitor implements QLNodeVisitorInterface {

    VBox questionArea = null;

    public QLGuiVisitor(VBox questionArea){
        this.questionArea = questionArea;
    }

    @Override
    public void visit(QLNode qlNode) {

    }

    @Override
    public void visit(Form form) {
        javafx.scene.control.Label label = new javafx.scene.control.Label(form.getIdentifier());
        label.getStyleClass().add("formHeader");
        questionArea.getChildren().add(label);
    }

    @Override
    public void visit(Question question) {

    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }
}
