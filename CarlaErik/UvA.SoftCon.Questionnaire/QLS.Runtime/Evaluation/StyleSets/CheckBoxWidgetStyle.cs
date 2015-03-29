using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets
{
    public class CheckBoxWidgetStyle : WidgetStyle
    {
        public static CheckBoxWidgetStyle Default
        {
            get
            {
                return new CheckBoxWidgetStyle();
            }
        }
    }
}
