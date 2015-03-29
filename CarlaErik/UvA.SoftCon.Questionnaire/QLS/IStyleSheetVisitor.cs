using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.QLS
{
    public interface IStyleSheetVisitor<T>
    {
        T VisitStyleSheet(StyleSheet styleSheet);

        T VisitPage(Page page);

        T VisitSection(Section section);

        T VisitQuestionReference(QuestionReference questionRef);

        T VisitIdentifier(Identifier identifier);

        T VisitDefaultStyle(DefaultStyle defaultStyle);

        T VisitFontColor(FontColor fontColor);

        T VisitFontName(FontName fontName);

        T VisitFontSize(FontSize fontSize);

        T VisitCalendar(Calendar calendar);

        T VisitCheckBox(CheckBox checkBox);

        T VisitDropDown(DropDown dropDown);

        T VisitRadioButtons(RadioButtons radioButtons);

        T VisitSpinBox(SpinBox spinBox);

        T VisitTextBox(TextBox textBox);
    }
}
