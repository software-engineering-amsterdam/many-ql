using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.QLS;
using UvA.SoftCon.Questionnaire.WinForms.Controls;

namespace UvA.SoftCon.Questionnaire.WinForms.UIBuilding
{
    public class WidgetFactory : IWidgetFactory
    {
        private Question _question;

        public WidgetFactory(Question question)
        {
            _question = question;
        }


        public object CreateCalendarWidget()
        {
            return new CalendarWidget(_question);
        }

        public object CreateCheckBoxWidget()
        {
            return new CheckBoxWidget(_question);
        }

        public object CreateDropDownWidget(string trueLabel, string falseLabel)
        {
            return new DropDownWidget(_question, trueLabel, falseLabel);
        }

        public object CreateRadioWidget(string trueLabel, string falseLabel)
        {
            return new RadioWidget(_question, trueLabel, falseLabel);
        }

        public object CreateSpinBoxWidget()
        {
            return new SpinBoxWidget(_question);
        }

        public object CreateTextBoxWidget()
        {
            return new TextBoxWidget(_question);
        }
    }
}
