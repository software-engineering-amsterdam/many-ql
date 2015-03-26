package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.List;

public class StyledGUIBuilder extends GUIBuilder {
    private final QLFormDataStorage qlData;
    private final QLSStyleSheetDataStorage qlsData;

    private final QLSUIFormManager uiFormManager;

    public StyledGUIBuilder(Form _form, QLFormDataStorage _qlData, QLSStyleSheetDataStorage _qlsData, WidgetsFactory _widgetFactory) {
        super(_form, _widgetFactory);
        this.qlsData = _qlsData;
        this.qlData = _qlData;

        this.uiFormManager = new QLSUIFormManager(_form.getName(), new QLSUIPanel());

        this.prepareForm();
    }

    private void prepareForm() {
        for (Page page : this.qlsData.getPages()) {

            UIPage UIPage = new UIPage(page.getName());
            this.uiFormManager.addPage(UIPage);

            List<Section> sections = page.getSections();
            for (Section section : sections) {
                this.uiFormManager.addSection(new UISection(UIPage, section.getName()));

                List<QLSQuestion> questions = section.getQuestions();
                for (QLSQuestion question : questions) {
                    Question qlQuestion = this.qlData.getQuestionById(question.getIdName());
                    UIQuestion uiQuestion = this.createUiQuestion(qlQuestion);
                    this.uiFormManager.addQuestion(uiQuestion);
                    System.out.println(uiQuestion);
                }
            }
        }
    }

    public void render() {
        this.uiFormManager.render();
    }

    protected UIQuestion createUiQuestion(Question _question) {
        return _question.accept(this.uiQuestionBuilder);
    }
}