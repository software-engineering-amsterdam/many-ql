package org.fugazi.qls.ast.stylesheet.stylesheet_data;


import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.QuestionsVisitor;

import java.util.List;

public class QLSStyleSheetDataStorage {
    private final StyleSheet sheet;
    private final QuestionsVisitor questionsVisitor;

    public QLSStyleSheetDataStorage(StyleSheet _sheet) {
        this.sheet = _sheet;

        this.questionsVisitor = new QuestionsVisitor(_sheet);
    }

    /**
     * =====================
     * Public exposed getters
     * =====================
     */

    public List<QLSQuestion> getQuestions() {
        return this.questionsVisitor.getQuestions();
    }

    public List<Page> getPages() {
        return this.sheet.getPages();
    }
}
