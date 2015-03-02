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

        Iterator<Block> iter = blocksStack.iterator();
        boolean isAdded = false;
        while (iter.hasNext()) {
            Block block = iter.next();
            if (ifStatements.containsKey(block.getName())) {
                isAdded = true;
            }
        }

        // add an ifstatements array for the block.
        if (!isAdded) {
            ifStatements.put(currentBlock.getName(), new ArrayList<IfStatement>());
        }

        // add the if statement in the block.
        if (!isAdded && !ifStatements.get(currentBlock.getName()).contains(_ifStatement)) {
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

    private boolean isBlockExists(String _blockName) {
        Iterator<Block> iter = blocksStack.iterator();

        while (iter.hasNext()) {
            Block block = iter.next();
            if (block.getName().equals(_blockName)) {
                return true;
            }
        }
        return false;
    }

    private UIQuestion getExistingQuestion(String _questId) {
        UIQuestion question = null;

        Iterator<Block> iter = blocksStack.iterator();
        while (iter.hasNext()) {
            Block block = iter.next();
            if (block.getBody().containsKey(_questId)) {
                question = block.getBody().get(_questId);
            }
        }
        return question;
    }

    private void removeBlockFromForm(String _blockId) {
        Iterator<Block> iter = blocksStack.iterator();

        while (iter.hasNext()) {
            Block block = iter.next();
            if (block.getName().equals(_blockId)) {
                block.getBody().values().forEach(quest -> this.removeQuestionFromTheForm(quest));
                block.clearBlock();
                this.previousBlock();
            }
        }
    }

    private void addQuestionToBlock(UIQuestion _quest) {
        if (!isQuestionExists(_quest.getId())) {
            currentBlock.add(_quest);
            addQuestionToTheForm(_quest);
        }
    }

    private boolean isQuestionExists(String _id) {
        Iterator<Block> iter = blocksStack.iterator();
        boolean isExists = false;
        while (iter.hasNext()) {
            Block block = iter.next();
            if (block.getBody().containsKey(_id)) {
                isExists = true;
            }
        }
        return isExists;
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
        currentBlock = blocksStack.getFirst();
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
        if (!isQuestionExists(_question.getIdName())) {
            UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
            UIQuestion uiQuestion = _question.getType().accept(typeVisitor);
            this.addQuestionToBlock(uiQuestion);
        }
        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        this.addIfStatement(_ifStatement);

        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);

        if (isConditionTrue) {
            if (!isBlockExists(_ifStatement.getCondition().toString())) {
                IfStatementBlock ifBlock = new IfStatementBlock(_ifStatement.getCondition().toString());
                this.addBlock(ifBlock);
            }
            _ifStatement.getBody().forEach(statement -> statement.accept(this));
        } else {
            // The current block
            if (isBlockExists(_ifStatement.getCondition().toString())) {
                this.removeBlockFromForm(currentBlock.getName());
                this.removeBlockFromForm(_ifStatement.getCondition().toString());
            }
        }

        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        ExpressionValue result = evaluateComputedExpression(_computedQuest);

        if (!isQuestionExists(_computedQuest.getIdName())) {
            this.addComputedQuestion(_computedQuest);
            UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, result);
            this.addQuestionToBlock(uiComputedQuestion);
        } else {
            UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) getExistingQuestion(_computedQuest.getIdName());
            if (uiComputedQuestion != null)
                uiComputedQuestion.setComputedValue(result);
        }

        return null;
    }
}