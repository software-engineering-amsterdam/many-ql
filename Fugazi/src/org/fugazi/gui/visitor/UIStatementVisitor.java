package org.fugazi.gui.visitor;

import org.fugazi.ast.statement.ComputedQuestion;
import org.fugazi.ast.statement.IStatementVisitor;
import org.fugazi.ast.statement.IfStatement;
import org.fugazi.ast.statement.Question;
import org.fugazi.gui.ui_elements.UIElement;
import org.fugazi.gui.ui_elements.UIComputedQuestion;

public class UIStatementVisitor implements IStatementVisitor <UIElement> {

    public UIElement visitQuestion(Question _question) {
        UITypeVisitor typeVisitor = new UITypeVisitor(_question);
        return _question.getType().accept(typeVisitor);
    }
    
    public UIElement visitIfStatement(IfStatement _ifStatement) {
        return null;
    }
    
    public UIElement visitComputedQuestion(ComputedQuestion _assignQuest) {
        return new UIComputedQuestion(_assignQuest);
    }
}
