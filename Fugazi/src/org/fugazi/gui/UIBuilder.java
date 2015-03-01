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

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;

public class UIBuilder implements IMediator, IStatementVisitor<Void> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ValueStorage storage;

    private ArrayList<ComputedQuestion> computedQuestions = new ArrayList<>(); // used for their re-evaluation

    // if statements by block.
    private HashMap<String, ArrayList<IfStatement>> ifStatements = new HashMap<>(); // used for their re-evaluation

    private Deque<Block> blocksStack = new ArrayDeque<>();
    private Block currentBlock = null;

    public UIBuilder(Form _astForm) {
        this.astForm = _astForm;
        this.storage = new ValueStorage();
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());

        FormBlock formBlock = new FormBlock(_astForm.getName());
        this.addBlock(formBlock);
    }

    public void renderGUI() {
        this.setup(astForm);
        this.uiForm.showForm();
    }

    private void setup(Form _form) {
        _form.getBody().forEach(statement -> statement.accept(this));
    }

    private void addIfStatement(IfStatement _ifStatement) {

        if (!ifStatements.containsKey(currentBlock.getName())) {
            ifStatements.put(currentBlock.getName(), new ArrayList<IfStatement>());
        }

        if (!ifStatements.get(currentBlock.getName()).contains(_ifStatement)) {
            ifStatements.get(currentBlock.getName()).add(_ifStatement);
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

    /**
     * Block management
     */
    private void addBlock(Block _block) {
        blocksStack.push(_block);
        currentBlock = _block;
    }

    private void previousBlock() {
        blocksStack.pop();
        currentBlock = blocksStack.getLast();
    }

    private void removeBlockFromForm() {
        currentBlock.getBody().values().forEach(quest -> this.removeQuestionFromTheForm(quest));
        currentBlock.clearBlock();
        this.previousBlock();
    }

    private void addQuestionToBlock(UIQuestion _quest) {
        if (!isQuestionExistsInBlock(_quest.getId())) {
            currentBlock.add(_quest);
            addQuestionToTheForm(_quest);
        }
    }

    private boolean isQuestionExistsInBlock(String _id) {
        return currentBlock.getBody().containsKey(_id);
    }

    /**
     * Mediator messages
     */
    public void getChangeFromColleagues(Colleague _origin) {
        // save the new value.
        this.storage.saveValue(_origin.getId(), _origin.getState());

        // re-evaluate the computed questions.
        computedQuestions.forEach(quest -> this.evaluateComputedExpression(quest));

        // re-visit the conditions of the previous block.
        ArrayList<IfStatement> statements = ifStatements.get(blocksStack.getLast().getName());
        if (statements != null) {
            statements.forEach(statement -> statement.accept(this));
        }
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
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);
        this.addQuestionToBlock(uiQuestion);

        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        this.addIfStatement(_ifStatement);

        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);

        if (isConditionTrue) {
            if (!currentBlock.getName().equals(_ifStatement.getCondition().toString())) {
                IfStatementBlock ifBlock = new IfStatementBlock(_ifStatement.getCondition().toString());
                this.addBlock(ifBlock);
            }
            _ifStatement.getBody().forEach(statement -> statement.accept(this));
        } else {
            if (currentBlock.getName().equals(_ifStatement.getCondition().toString()))
                this.removeBlockFromForm();
        }

        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        this.addComputedQuestion(_computedQuest);

        ExpressionValue result = evaluateComputedExpression(_computedQuest);

        if (!isQuestionExistsInBlock(_computedQuest.getIdName())) {
            UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, result);
            this.addQuestionToBlock(uiComputedQuestion);
        } else {
            UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) currentBlock.getBody().get(_computedQuest.getIdName());
            uiComputedQuestion.setComputedValue(result);
        }

        return null;
    }
}