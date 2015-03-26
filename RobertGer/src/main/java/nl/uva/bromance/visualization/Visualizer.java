package nl.uva.bromance.visualization;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.visitors.ConditionalHandler;
import nl.uva.bromance.ast.visitors.QlNodeVisitor;
import nl.uva.bromance.ast.visitors.QlsNodeVisitor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Visualizer implements QlsNodeVisitor, QlNodeVisitor {

    private QLSPage currentPage;
    private Map<String, Result> answerMap = new HashMap<>();
    private Node focusedNode;
    private int focusId;
    private Optional<QLSNode> qlsNode = Optional.empty();
    private QLNode qlNode;
    private VBox pages;
    private VBox questions;
    private boolean init = true;


    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }

    public int getFocusId() {
        return focusId;
    }

    public void render(AST<QLNode> qlAst, VBox pages, VBox questions) {
        this.qlNode = qlAst.getRoot();
        this.pages = pages;
        this.questions = questions;
        visualize(0);
    }


    public void visualize(int focusId) {
        this.focusId = focusId;

        if (qlsNode.isPresent()) {
            processQls();
        } else {
            processQl();
        }
        if (focusedNode != null) {
            focusedNode.requestFocus();
            // Fix for the position caret in textfields, had to use instanceof sorry Tijs!
            if (focusedNode instanceof TextField) {
                TextField tf = (TextField) focusedNode;
                tf.positionCaret(tf.getLength());
            }
        }
        init = false;
    }

    private void processQls() {
        qlsNode.get().accept(this);
    }

    private void processQl() {
        new ExpressionEvaluator(answerMap).evaluate(qlNode);
        new ConditionalHandler().handle(qlNode);
        qlNode.accept(this);
    }

    public void setQlsAst(AST<QLSNode> qlsAst) {
        this.qlsNode = Optional.ofNullable(qlsAst.getRoot());
    }

    @Override
    public void visit(QLSPage page) {
        if (currentPage == null) {
            currentPage = page;
        }

        String identifier = page.getIdentifier();
        javafx.scene.control.Label label = new javafx.scene.control.Label(identifier);
        label.setOnMouseClicked((event) -> {
            currentPage = page;
            visualize(0);
        });
        if (currentPage == page) {
            label.getStyleClass().add("active");
            for (QLSNode child : currentPage.getChildren()) {
                child.visualize(questions, answerMap, this);
            }
        }
        label.getStyleClass().add("pageLabel");
        pages.getChildren().add(label);
    }

    @Override
    public void visit(QLSQuestion question) {

    }

    @Override
    public void visit(QLSSection section) {

    }

    @Override
    public void visit(QLSStylesheet stylesheet) {

    }

    @Override
    public void visit(Calculation calculation) {

    }

    @Override
    public void visit(Form form) {
        if (init) {
            javafx.scene.control.Label label = new javafx.scene.control.Label(form.getIdentifier());
            label.getStyleClass().add("formHeader");
            questions.getChildren().add(label);
        }
    }

    @Override
    public void visit(Input input) {

    }

    @Override
    public void visit(Label label) {

    }

    @Override
    public void visit(LabelText labelText) {

    }

    @Override
    public void visit(Question question) {
        if (init) {
            question.getQuestionType().addQuestionToPane(questions, answerMap, this);
        } else {
            question.getQuestionType().refresh();
        }
    }


    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(ElseIfStatement elseIfStatement) {

    }

    @Override
    public void visit(ElseStatement elseStatement) {

    }

    public void refresh(Question q) {
        focusId = q.hashCode();
        processQl();
    }

    @Override
    public void visit(Expression expression) {

    }

    @Override
    public void visit(Terminal terminal) {

    }


}

