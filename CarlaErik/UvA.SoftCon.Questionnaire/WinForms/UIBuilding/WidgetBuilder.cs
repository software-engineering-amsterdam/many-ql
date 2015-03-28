using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    internal class WidgetBuilder
    {
        internal QuestionWidget CreateQuestionWidget(Question question, QLS.AST.Model.StyleAttributes.Widgets.Widget widget)
        {
            throw new InvalidOperationException("Invalid combination of question type and widget.");
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, QLS.AST.Model.StyleAttributes.Widgets.CheckBox widget)
        {
            return new CheckBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, QLS.AST.Model.StyleAttributes.Widgets.DropDown widget)
        {
            return new DropDownWidget(question, widget.TrueLabel, widget.FalseLabel);
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, QLS.AST.Model.StyleAttributes.Widgets.RadioButtons widget)
        {
            return new RadioWidget(question, widget.TrueLabel, widget.FalseLabel);
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, QLS.AST.Model.StyleAttributes.Widgets.RadioButtons widget)
        {
            return new RadioWidget(question, widget.TrueLabel, widget.FalseLabel);
        }

        internal QuestionWidget CreateQuestionWidget(DateQuestion question, QLS.AST.Model.StyleAttributes.Widgets.Calendar widget)
        {
            return new CalendarWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(IntegerQuestion question, QLS.AST.Model.StyleAttributes.Widgets.TextBox widget)
        {
            return new TextBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(IntegerQuestion question, QLS.AST.Model.StyleAttributes.Widgets.SpinBox widget)
        {
            return new SpinBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(StringQuestion question, QLS.AST.Model.StyleAttributes.Widgets.TextBox widget)
        {
            return new TextBoxWidget(question);
        }
    }
}
