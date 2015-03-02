package org.fugazi.gui;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.*;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.block.*;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.ui_elements.*;
import org.fugazi.gui.visitor.UITypeVisitor;

import java.util.*;

public class UIBuilder implements IMediator, IStatementVisitor<Void> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ValueStorage storage;

    private ArrayList<ComputedQuestion> computedQuestions = new ArrayList<>(); // used for their re-evaluation

    // if statements by block.
    private HashMap<String, ArrayList<IfStatement>> ifStatements = new HashMap<>(); // used for their re-evaluation

    private final BlockHandler blockHandler;

    public UIBuilder(Form _astForm) {
        this.astForm = _astForm;
        this.storage = new ValueStorage();
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());
        this.blockHandler = new BlockHandler();

        FormBlock formBlock = new FormBlock(_astForm.getName());
        blockHandler.addBlock(formBlock);
    }

    public void renderGUI() {
        this.setupFormStatements(astForm);
        this.uiForm.showForm();
    }

    private void setupFormStatements(Form _form) {
        _form.getBody().forEach(statement -> statement.accept(this));
    }

    private void addIfStatement(IfStatement _ifStatement) {
        if (!blockHandler.isBlockExists(_ifStatement.getCondition().toString())) {
            ifStatements.put(blockHandler.getCurrentBlock().getName(), new ArrayList<>());
            if (!ifStatements.get(blockHandler.getCurrentBlock().getName()).contains(_ifStatement)) {
                ifStatements.get(blockHandler.getCurrentBlock().getName()).add(_ifStatement);
            }
        }
    }

    private void addComputedQuestion(ComputedQuestion _computedQuest) {
        if (!computedQuestions.contains(_computedQuest)) {
            computedQuestions.add(_computedQuest);
        }
    }

    private void addQuestionToTheForm(UIQuestion _quest) {
        this.storage.saveValue(_quest.getId(), _quest.getState());
        this.uiForm.addQuestion(_quest);
    }

    private void removeQuestionFromTheForm(UIQuestion _quest) {
        this.uiForm.removeQuestion(_quest);
    }

    private void removeBlockFromForm(String _blockName) {
        for (Block block : blockHandler.getBlocks()) {
            if (block.getName().equals(_blockName)) {
                block.getBody().values().forEach(quest -> this.removeQuestionFromTheForm(quest));
                block.clearBlock();
                blockHandler.previousBlock();
            }
        }
    }

    private void addQuestionToBlock(UIQuestion _quest) {
        blockHandler.getCurrentBlock().add(_quest);
        addQuestionToTheForm(_quest);
    }

    /**
     * Mediator messages
     */
    public void getChangeFromColleagues(Colleague _origin) {
        // save the new value.
        this.storage.saveValue(_origin.getId(), _origin.getState());

        // re-evaluate the computed questions.
        computedQuestions.forEach(quest -> this.evaluateComputedExpression(quest));

        // re-visit the conditions of the root block.
        ArrayList<IfStatement> statements = ifStatements.get(astForm.getName());
        statements.forEach(statement -> statement.accept(this));

        blockHandler.resetCurrentBlock();
    }

    /**
     * Evaluation
     */
    private boolean evaluateIfStatement(IfStatement _ifStatement) {
        Expression condition = _ifStatement.getCondition();
        BoolValue result = (BoolValue) this.evaluator.evaluateExpression(condition);
        return result.getValue();
    }

    private ExpressionValue evaluateComputedQuestion(ComputedQuestion _computedQuest) {
        Expression expression = _computedQuest.getComputedExpression();
        return evaluator.evaluateExpression(expression);
    }

    private ExpressionValue evaluateComputedExpression(ComputedQuestion _computedQuest) {
        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        this.storage.saveValue(_computedQuest.getIdName(), result);
        return result;
    }

    /**
     * Statement Visitor
     */
    public Void visitQuestion(Question _question) {
        if (!blockHandler.isQuestionExists(_question.getIdName())) {
            UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
            UIQuestion uiQuestion = _question.getType().accept(typeVisitor);
            this.addQuestionToBlock(uiQuestion);
        }
        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);

        this.addIfStatement(_ifStatement);

        if (isConditionTrue) {
            if (!blockHandler.isBlockExists(_ifStatement.getCondition().toString())) {
                IfStatementBlock ifBlock = new IfStatementBlock(_ifStatement.getCondition().toString());
                blockHandler.addBlock(ifBlock);
            }
            _ifStatement.getBody().forEach(statement -> statement.accept(this));
        } else {
            if (blockHandler.isBlockExists(_ifStatement.getCondition().toString())) {
                this.removeBlockFromForm(blockHandler.getCurrentBlock().getName());
                this.removeBlockFromForm(_ifStatement.getCondition().toString());
            }
        }
        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        ExpressionValue result = evaluateComputedExpression(_computedQuest);

        if (!blockHandler.isQuestionExists(_computedQuest.getIdName())) {
            this.addComputedQuestion(_computedQuest);

            UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, result);
            this.addQuestionToBlock(uiComputedQuestion);

        } else {
            UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) blockHandler.getExistingQuestion(_computedQuest.getIdName());
            if (uiComputedQuestion != null)
                uiComputedQuestion.setComputedValue(result);
        }
        return null;
    }
}