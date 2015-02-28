package org.fugazi.gui.widgets;

import org.fugazi.ValueStorage;
import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.*;
import org.fugazi.evaluator.Evaluator;
import org.fugazi.evaluator.expression_value.BoolValue;
import org.fugazi.evaluator.expression_value.ExpressionValue;
import org.fugazi.gui.block.*;
import org.fugazi.gui.block.block_memento.BlockCareTaker;
import org.fugazi.gui.block.block_memento.BlockOriginator;
import org.fugazi.gui.mediator.Colleague;
import org.fugazi.gui.mediator.IMediator;
import org.fugazi.gui.ui_elements.*;
import org.fugazi.gui.visitor.UITypeVisitor;

import java.util.ArrayList;
import java.util.HashMap;

public class UIBuilder implements IMediator, IStatementVisitor<Void> {

    private final Form astForm;
    private final UIForm uiForm;
    private final Evaluator evaluator;
    private final ValueStorage storage;

    private ArrayList<IfStatement> ifStatements = new ArrayList<>(); // used for their re-evaluation
    private ArrayList<ComputedQuestion> computedQuestions = new ArrayList<>(); // used for their re-evaluation

    private HashMap<String, Block> blocks = new HashMap<>(); // todo memento

    // Memento pattern to handle the states of the Blocks
    private final BlockCareTaker blockCaretaker = new BlockCareTaker();
    private final BlockOriginator blockOriginator = new BlockOriginator();
    private Block currentBlock;
    private FormBlock formBlock;

    public UIBuilder(Form _astForm) {
        this.astForm = _astForm;
        this.storage = new ValueStorage();
        this.evaluator = new Evaluator(storage);
        this.uiForm = new UIForm(astForm.getName());

        this.formBlock = new FormBlock(_astForm.getName());
        addBlock(formBlock);
        this.currentBlock = formBlock;
    }

    public void renderGUI() {
        this.setup(astForm);
        this.uiForm.showForm();
    }

    private void setup(Form _form) {
        _form.getBody().forEach(statement -> statement.accept(this));
    }

    private void addBlock(Block _bl) {
        if(!this.blocks.containsKey(_bl.getName()))
            this.blocks.put(_bl.getName(), _bl);
    }

    private void addIfStatement(IfStatement _ifStatement) {
        if (!ifStatements.contains(_ifStatement)) {
            ifStatements.add(_ifStatement);
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

    private void removeBlockFromForm(Block _bl) {

        if (this.blocks.containsKey(_bl.getName())) {
            Block block = this.blocks.get(_bl.getName());

            block.getBody().values().forEach(quest -> this.removeQuestionFromTheForm(quest));
            block.clearBlock();
        }
    }

    private void addQuestionToBlock(Block _bl, UIQuestion _quest) {
        if (this.blocks.containsKey(_bl.getName())) {
            Block block = this.blocks.get(_bl.getName());

            if (!block.getBody().containsKey(_quest.getId())) {
                block.add(_quest);
                addQuestionToTheForm(_quest);
            }
        }
    }

    /**
     * Mediator messages
     */
    public void getChangeFromColleagues(Colleague _origin) {
        // save the new value.
        this.storage.saveValue(_origin.getId(), _origin.getState());

        // re-visit the conditions.
        ifStatements.forEach(ifStatement -> ifStatement.accept(this));

        // re-visit the computed questions.
        //computedQuestions.forEach(quest -> quest.accept(this));
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

    /**
     * Statement Visitor
     */
    public Void visitQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(this, _question);
        UIQuestion uiQuestion = _question.getType().accept(typeVisitor);

        this.addQuestionToBlock(currentBlock, uiQuestion);

        return null;
    }

    public Void visitIfStatement(IfStatement _ifStatement) {
        if(!this.blocks.containsKey(_ifStatement.getCondition().toString())) {
            IfStatementBlock ifBlock = new IfStatementBlock(_ifStatement.getCondition().toString());
            addBlock(ifBlock);
            currentBlock = ifBlock;
        } else {
            currentBlock = this.blocks.get(_ifStatement.getCondition().toString());
        }

        this.addIfStatement(_ifStatement);

        boolean isConditionTrue = this.evaluateIfStatement(_ifStatement);
        if (isConditionTrue) {
            _ifStatement.getBody().forEach(statement -> statement.accept(this));
        } else {
            this.removeBlockFromForm(currentBlock);
        }

        currentBlock = formBlock; // todo memento, previous block in history

        return null;
    }

    public Void visitComputedQuestion(ComputedQuestion _computedQuest) {
        this.addComputedQuestion(_computedQuest);

        ExpressionValue result = this.evaluateComputedQuestion(_computedQuest);
        this.storage.saveValue(_computedQuest.getIdName(), result);

        if (!currentBlock.getBody().containsKey(_computedQuest.getIdName())) {
            UIComputedQuestion uiComputedQuestion = new UIComputedQuestion(this, _computedQuest, result);
            this.addQuestionToBlock(currentBlock, uiComputedQuestion);
        } else {
            UIComputedQuestion uiComputedQuestion = (UIComputedQuestion) currentBlock.getBody().get(_computedQuest.getIdName());
            uiComputedQuestion.setComputedValue(result);
        }

        return null;
    }
}
