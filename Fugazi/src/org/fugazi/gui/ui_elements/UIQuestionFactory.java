package org.fugazi.gui.ui_elements;

import org.fugazi.ast.statement.Question;

public class UIQuestionFactory {

    public UIQuestion getUIQuestion(Question _question) {
        
        if (_question.getType().toString() == "Bool") {
            return new UIBoolQuestion(_question);

        } else if (_question.getType().toString() == "Int") {
            return new UINumQuestion(_question);

        } else if (_question.getType().toString() == "String") {
            return new UITextQuestion(_question);
        }

        return new UINullQuestion();
    }
}
