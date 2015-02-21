package org.fugazi.gui;

import org.fugazi.ast.statement.Question;
import org.fugazi.gui.ui_elements.*;

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
