package org.fugazi.qls.gui.widget;

import org.fugazi.ql.ast.statement.Question;
import org.fugazi.ql.evaluator.expression_value.ExpressionValue;
import org.fugazi.ql.gui.widgets.IWidget;
import org.fugazi.ql.gui.widgets.WidgetsFactory;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.stylesheet.stylesheet_data.QLSStyleSheetDataStorage;
import org.fugazi.qls.ast.widget.AbstractQLSWidget;

import java.util.List;

public class QLSWidgetsFactory extends WidgetsFactory {
    
    private final QLSStyleSheetDataStorage styleSheetDataStorage;
    
    public QLSWidgetsFactory(QLSStyleSheetDataStorage _styleSheetDataStorage) {
        this.styleSheetDataStorage = _styleSheetDataStorage;
    }
    
    @Override
    public IWidget getWidgetForQuestion(Question _question) {
        String label = _question.getLabel();
        AbstractQLSWidget widget = (AbstractQLSWidget) getQlsWidget(_question.getIdName());
        widget.setLabel(label);

        return widget;
    }

    @Override
    public IWidget getWidgetForQuestion(Question _question, ExpressionValue _value) {
        String label = _question.getLabel();
        AbstractQLSWidget widget = (AbstractQLSWidget) getQlsWidget(_question.getIdName());
        widget.setLabel(label);
        widget.setWidgetValue(_value);
        widget.setReadOnly(true);

        return widget;
    }

    private IWidget getQlsWidget(String _qlQuestionId) {
        List<QLSQuestion> qlsQuestions = styleSheetDataStorage.getQuestions();
        for (QLSQuestion qlsQuestion : qlsQuestions) {
            if (qlsQuestion.getIdName().equals(_qlQuestionId)) {
                return qlsQuestion.getWidget();
            }
        }
        return null;
    }
}