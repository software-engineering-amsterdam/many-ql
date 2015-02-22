package org.fugazi.gui;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IStatementVisitor;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.gui.ui_elements.IUIElement;
import org.fugazi.gui.ui_elements.UIIfContainer;
import org.fugazi.gui.ui_elements.UIComputedQuestion;

public class UIStatementVisitor implements IStatementVisitor <IUIElement> {

    public IUIElement visitQuestion(Question _question) {
        UIQuestionFactory questionFactory = new UIQuestionFactory();
        return questionFactory.getUIQuestion(_question);
    }
    
    public IUIElement visitIfStatement(IfStatement _ifStatement) {
        return new UIIfContainer();
    }
    
    public IUIElement visitComputedQuestion(ComputedQuestion _assignQuest) {
        return new UIComputedQuestion(_assignQuest);
    }
}
