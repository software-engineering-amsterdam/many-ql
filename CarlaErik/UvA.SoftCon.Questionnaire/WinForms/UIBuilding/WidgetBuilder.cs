using System;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    internal class WidgetBuilder
    {
        internal QuestionWidget CreateQuestionWidget(Question question, WidgetStyle widgetType)
        {
            string message = String.Format("Widget {0} can not be assigned to question '{1}' of type '{2}'.", widgetType.ToString(), question.Name, StringEnum.GetStringValue(question.DataType));
            throw new InvalidOperationException("Invalid combination of question type and widget.");
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, CheckBoxWidgetStyle widget)
        {
            return new CheckBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, DropDownWidgetStyle widget)
        {
            return new DropDownWidget(question, widget.TrueLabel, widget.FalseLabel);
        }

        internal QuestionWidget CreateQuestionWidget(BooleanQuestion question, RadioWidgetStyle widget)
        {
            return new RadioWidget(question, widget.TrueLabel, widget.FalseLabel);
        }


        internal QuestionWidget CreateQuestionWidget(DateQuestion question, CalendarWidgetStyle widget)
        {
            return new CalendarWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(IntegerQuestion question, TextBoxWidgetStyle widget)
        {
            return new TextBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(IntegerQuestion question, SpinBoxWidgetStyle widget)
        {
            return new SpinBoxWidget(question);
        }

        internal QuestionWidget CreateQuestionWidget(StringQuestion question, TextBoxWidgetStyle widget)
        {
            return new TextBoxWidget(question);
        }
    }
}
