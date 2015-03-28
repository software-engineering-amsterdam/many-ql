package org.fugazi.qls.gui;

import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.form.form_data.QLFormDataStorage;
import org.fugazi.ql.ast.statement.ComputedQuestion;
import org.fugazi.ql.ast.statement.IfStatement;
import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.ValueStorage;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.GUIBuilder;
import org.fugazi.ql.gui.GUIEvaluator;
import org.fugazi.ql.gui.mediator.Colleague;
import org.fugazi.ql.gui.mediator.IMediator;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIComputedQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestion;
import org.fugazi.ql.gui.ui_elements.ui_questions.UIQuestionBuilder;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.segment.Page;
import org.fugazi.qls.ast.segment.Section;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.gui.ui_segment.UIPage;
import org.fugazi.qls.gui.ui_segment.UISection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StyledGUIBuilder extends GUIBuilder {

    private final QLSUIFormManager qlsuiFormManager;

    public StyledGUIBuilder(
            Form _form, 
            WidgetsFactory _widgetFactory,
            QLSStyleSheetDataStorage _qlsData)
    {
        super(_form, _widgetFactory);
        this.qlsuiFormManager = new QLSUIFormManager(_form.getName(), this.uiFormManager);
        this.prepareForm(_qlsData);
    }

    private void prepareForm(QLSStyleSheetDataStorage _qlsData) {
        for (Page page : _qlsData.getPages()) {

            UIPage UIPage = new UIPage(page.getName());
            this.qlsuiFormManager.addPage(UIPage);

            List<Section> sections = page.getSections();
            for (Section section : sections) {
                this.qlsuiFormManager.addSection(new UISection(UIPage, section.getName()));

                List<QLSQuestion> questions = section.getQuestions();
                for (QLSQuestion question : questions) {
                    UIQuestion uiQuestion = this.getUIQuestionById(question.getIdName(), this.questionsWithConditions);
                    this.qlsuiFormManager.addQuestion(uiQuestion);
                }
            }
        }
    }
}