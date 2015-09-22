package nl.uva.bromance.QL.gui;

import javafx.scene.layout.VBox;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.expressions.unary.Primitive;

import java.util.Map;

class QLGuiVisitor implements QLNodeVisitorInterface {

    VBox questionArea = null;
    Map<String, Primitive> answerMap;
    QLGUI qlGui;

    public QLGuiVisitor(VBox questionArea, Map<String ,Primitive> answerMap, QLGUI qlGui){
        this.questionArea = questionArea;
        this.answerMap = answerMap;
        this.qlGui = qlGui;
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
        javafx.scene.control.Label label = new javafx.scene.control.Label(question.getText());
        label.getStyleClass().add("question");
        Primitive questionPrimitive = answerMap.get(question.getIdentifier());
        questionArea.getChildren().add(label);
        questionPrimitive.drawQuestion(questionArea, qlGui);
    }

    @Override
    public void visit(Questionnaire questionnaire) {
    }

    @Override
    public void visit(If _if) {
    }

    @Override
    public void visit(Calculation calc) {
    }
}
