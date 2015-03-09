package org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor;

import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.widget.Widget;

import java.util.ArrayList;
import java.util.List;

public class QuestionsVisitor extends FullQLSFormVisitor {
    private StyleSheet sheet;
    private List<Question> questions;

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
    public Void visitQuestion(org.fugazi.qls.ast.question.Question question){
        Widget widget = question.getWidget();
        widget.accept(this);

        this.saveQuestion(question);

        return null;
    }

    /**
     * =======================
     * Private data handling functions
     * =======================
     */

    private void saveQuestion(Question question) {
        this.questions.add(question);
    }

    /**
     * =======================
     * Exposed methods
     * =======================
     */

    public List<Question> getQuestions() {
        if (this.questions == null) {
            this.questions = new ArrayList<>();

            this.visitStyleSheet(this.sheet);
        }

        return this.questions;
    }
}
