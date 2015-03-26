package org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor;

import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

import java.util.ArrayList;
import java.util.List;

public class QuestionsVisitor extends FullQLSFormVisitor {
    private StyleSheet sheet;
    private List<QLSQuestion> questions;

    public QuestionsVisitor(StyleSheet _sheet) {
        super();
        this.sheet = _sheet;
    }

    /**
     * =======================
     * Visitor methods
     * =======================
     */

    @Override
    public Void visitQuestion(QLSQuestion _question){
        AbstractQLSWidget widget = _question.getWidget();
        widget.accept(this);
        this.saveQuestion(_question);
        
        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestion(QLSQuestion _question) {
        this.questions.add(_question);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<QLSQuestion> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();
            this.visitStyleSheet(this.sheet);
        }
        return this.questions;
    }
}
