package org.fugazi.qls.ast.stylesheet.stylesheet_data;


import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;
import org.fugazi.qls.ast.stylesheet.StyleSheet;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.DefaultDeclarationsVisitor;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.visitor.QuestionsVisitor;

import java.util.List;

public class QLSStyleSheetDataStorage {
    private final StyleSheet sheet;
    private final QuestionsVisitor questionsVisitor;
    private final DefaultDeclarationsVisitor declarationsVisitor;

    public QLSStyleSheetDataStorage(StyleSheet _sheet) {
        this.sheet = _sheet;

        this.questionsVisitor = new QuestionsVisitor(_sheet);
        this.declarationsVisitor = new DefaultDeclarationsVisitor(_sheet);
    }

    /**
     * =====================
     * Public exposed getters
     * =====================
     */

    public List<QLSQuestion> getQuestions() {
        return this.questionsVisitor.getQuestions();
    }

    public List<DefaultStyleDeclaration> getDefaultStyleDeclarations() {
        return this.declarationsVisitor.getDefaultStyleDeclarations();
    }

    public List<Page> getPages() {
        return this.sheet.getPages();
    }
}
