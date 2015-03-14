using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QLS.AST.Model;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes;
using UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets;

namespace UvA.SoftCon.Questionnaire.QLS
{
    public interface IQLSVisitor
    {
        void VisitStyleSheet(StyleSheet styleSheet);

        void VisitPage(Page page);

        void VisitSection(Section section);

        void VisitQuestionReference(QuestionReference reference);

        void VisitIdentifier(Identifier identifier);

        void VisitDefaultStyle(DefaultStyle defaultStyle);

        void VisitColorStyle(ColorStyle colorStyle);

        void VisitFontName(FontName fontName);

        void VisitFontSize(FontSize fontSize);

        void VisitWidth(Width width);

        void VisitCalendar(Calendar calendar);

        void VisitCheckBox(CheckBox checkBox);

        void VisitDropDown(DropDown dropDown);

        void VisitRadioButtons(RadioButtons radioButtons);

        void VisitSpinBox(SpinBox spinBox);

        void VisitTextBox(TextBox textBox);
    }


    public interface IQLSVisitor<T>
    {
        T VisitStyleSheet(StyleSheet styleSheet);

        T VisitPage(Page page);

        T VisitSection(Section section);

        T VisitQuestionReference(QuestionReference questionRef);

        T VisitIdentifier(Identifier identifier);

        T VisitDefaultStyle(DefaultStyle defaultStyle);

        T VisitColorStyle(ColorStyle colorStyle);

        T VisitFontName(FontName fontName);

        T VisitFontSize(FontSize fontSize);

        T VisitWidth(Width width);

        T VisitCalendar(Calendar calendar);

        T VisitCheckBox(CheckBox checkBox);

        T VisitDropDown(DropDown dropDown);

        T VisitRadioButtons(RadioButtons radioButtons);

        T VisitSpinBox(SpinBox spinBox);

        T VisitTextBox(TextBox textBox);
    }
}
