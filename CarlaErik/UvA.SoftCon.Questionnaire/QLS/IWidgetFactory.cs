using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS
{
    public interface IWidgetFactory
    {
        object CreateCalendarWidget();
        object CreateCheckBoxWidget();
        object CreateDropDownWidget(string trueLabel, string falseLabel);
        object CreateRadioWidget(string trueLabel, string falseLabel);
        object CreateSpinBoxWidget();
        object CreateTextBoxWidget();
    }
}
