using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class RadioWidgetStyle : WidgetStyle
    {
        public string TrueLabel
        {
            get;
            private set;
        }

        public string FalseLabel
        {
            get;
            private set;
        }

        public static RadioWidgetStyle Default
        {
            get
            {
                return new RadioWidgetStyle("Yes", "No");
            }
        }

        public RadioWidgetStyle(string trueLabel, string falseLabel)
        {
            TrueLabel = trueLabel;
            FalseLabel = falseLabel;
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateRadioWidget(TrueLabel, FalseLabel);
        }
    }
}
