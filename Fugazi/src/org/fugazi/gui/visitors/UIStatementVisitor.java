package org.fugazi.gui.visitors;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IStatementVisitor;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.gui.ui_elements.UIComputedQuestion;
import org.fugazi.gui.ui_elements.UINullQuestion;
import org.fugazi.gui.ui_elements.UIQuestion;
import org.fugazi.gui.ui_elements.UIQuestionFactory;

public class UIStatementVisitor implements IStatementVisitor <UIQuestion> {

    public UIQuestion visitQuestion(Question _question) {
        UIQuestionFactory questionFactory = new UIQuestionFactory();
        return questionFactory.getUIQuestion(_question);
    }
    
    public UIQuestion visitIfStatement(IfStatement _ifStatement) {
        return new UINullQuestion();
    }
    
    public UIQuestion visitComputedQuestion(ComputedQuestion _assignQuest) {
        return new UIComputedQuestion(_assignQuest);
    }
}
