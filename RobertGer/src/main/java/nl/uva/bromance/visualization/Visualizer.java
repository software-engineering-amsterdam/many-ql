package nl.uva.bromance.visualization;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.visitors.*;
import nl.uva.bromance.typechecking.TypeChecker;
import nl.uva.bromance.typechecking.TypeCheckingException;

import java.util.*;

public class Visualizer implements QLSNodeVisitor, QLNodeVisitor {

    private QLSPage currentPage;
    private Map<String, Result> answerMap = new HashMap<>();
    private Node focusedNode;
    private UUID focusUuid;
    private Optional<QLSNode> qlsNode = Optional.empty();
    private QLNode qlNode;
    private VBox pages;
    private VBox questions;
    private boolean init = true;


    public void setFocusedNode(Node node) {
        this.focusedNode = node;
    }

    public UUID getFocusUuid() {
        return focusUuid;
    }

    public QLSPage getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(QLSPage page) {
        currentPage = page;
    }

    public void render(AST<QLNode> qlAst, VBox pages, VBox questions) {
        this.qlNode = qlAst.getRoot();
        this.pages = pages;
        this.questions = questions;
        this.answerMap = new QLInitializer(qlNode).getAnswerMap();
        // Nothing focused as of now
        visualize(UUID.randomUUID());
    }


    public void visualize(UUID focusId) {
        this.focusUuid = focusId;

        refresh();
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

    private void processQl() {
        if (evaluateQLNode()) {
            questions.getChildren().clear();
            qlNode.accept(this);
        }
    }

    private void processQls() {
        if (evaluateQLNode()) {
            questions.getChildren().clear();
            questions.getChildren().clear();
            qlsNode.get().accept(this);
        }
    }

    private boolean evaluateQLNode() {
        new ExpressionEvaluator(answerMap).evaluate(qlNode);
        List<TypeCheckingException> typeCheckingExceptions = new TypeChecker().run(qlNode);
        if (!typeCheckingExceptions.isEmpty()) {
            Stage stage = new Stage();
            VBox root = new VBox();
            stage.setScene(new Scene(root));
            for (TypeCheckingException e : typeCheckingExceptions) {
                root.getChildren().add(new javafx.scene.control.Label(e.getMessage()));
            }
            stage.show();
            return false;
        }
        // Calculations depend on expressions and expressions can also depend on calculations, that is why the expressions are evaluated twice

        new CalculationRetrievalVisitor(answerMap).handle(qlNode);
        new ExpressionEvaluator(answerMap).evaluate(qlNode);
        new ConditionalHandler().handle(qlNode);
        return true;
    }

    public void setQlsAst(AST<QLSNode> qlsAst) {
        this.qlsNode = Optional.ofNullable(qlsAst.getRoot());
    }

    @Override
    public void visit(QLSPage page) {
        if (init) {
            page.addPageToPane(pages, this);
        } else {
            page.refresh(this);
        }
    }

    @Override
    public void visit(QLSQuestion question) {
        processQuestion(question.getQuestionNode());
    }

    @Override
    public void visit(QLSSection section) {
        if (init) {
            Optional<? extends Pane> newParent = Optional.of(new VBox());
            javafx.scene.control.Label label = new javafx.scene.control.Label(section.getIdentifier());
            label.getStyleClass().add("formHeader");
            newParent.get().getChildren().add(label);
            newParent.get().getStyleClass().add("form");
            questions.getChildren().add(newParent.get());
        }
    }

    @Override
    public void visit(QLSStylesheet stylesheet) {

    }

    @Override
    public void visit(QLSLabel label) {
        label.getLabelNode().accept(this);
    }

    @Override
    public void visit(Calculation calculation) {

    }

    @Override
    public void visit(Form form) {
        javafx.scene.control.Label label = new javafx.scene.control.Label(form.getIdentifier());
        label.getStyleClass().add("formHeader");
        questions.getChildren().add(label);
    }

    @Override
    public void visit(Label label) {

    }

    @Override
    public void visit(LabelText labelText) {
        labelText.addToPane(questions, answerMap, this);
    }

    @Override
    public void visit(Question question) {
        processQuestion(question);
    }

    private void processQuestion(Question question) {
        question.getQuestionType().addQuestionToPane(questions, answerMap, this);
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

    public void refresh(UUID focusId) {
        this.focusUuid = focusId;
        refresh();
    }

    public void refresh() {
        if (qlsNode.isPresent()) {
            processQls();
        } else {
            processQl();
        }
    }

    @Override
    public void visit(Expression expression) {

    }

    @Override
    public void visit(Terminal terminal) {

    }


}

