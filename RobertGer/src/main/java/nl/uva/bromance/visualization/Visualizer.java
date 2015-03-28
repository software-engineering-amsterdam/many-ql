package nl.uva.bromance.visualization;

import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.*;
import nl.uva.bromance.ast.visitors.ConditionalHandler;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;
import nl.uva.bromance.ast.visitors.QLsNodeVisitor;
import nl.uva.bromance.typechecking.TypeChecker;
import nl.uva.bromance.typechecking.TypeCheckingException;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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

    public void render(AST<QLNode> qlAst, VBox pages, VBox questions) {
        this.qlNode = qlAst.getRoot();
        this.pages = pages;
        this.questions = questions;
        // Nothing focused as of now
        visualize(UUID.randomUUID());
    }


    public void visualize(UUID focusId) {
        this.focusUuid = focusId;

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
        if (evaluateQLNode()) {
            qlsNode.get().accept(this);
        }
    }

    private boolean evaluateQLNode() {
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
        new ExpressionEvaluator(answerMap).evaluate(qlNode);
        new ConditionalHandler().handle(qlNode);
        return true;
    }

    private void processQl() {
        if (evaluateQLNode()) {
            qlNode.accept(this);
        }
    }

    public void setQlsAst(AST<QLSNode> qlsAst) {
        this.qlsNode = Optional.ofNullable(qlsAst.getRoot());
    }

    @Override
    public void visit(QLSPage page) {
        if (init) {
            if (currentPage == null) {
                currentPage = page;
            }

            String identifier = page.getIdentifier();
            javafx.scene.control.Label label = new javafx.scene.control.Label(identifier);
            label.setOnMouseClicked((event) -> {
                currentPage = page;
                refresh(UUID.randomUUID());
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
        processQuestion(question);
    }

    private void processQuestion(Question question) {
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

    public void refresh(UUID focusId) {
        this.focusUuid = focusId;
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

