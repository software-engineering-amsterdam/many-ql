using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.Runtime.Evaluation.StyleSets
{
    public class CalendarWidgetStyle : WidgetStyle
    {
        public static CalendarWidgetStyle Default
        {
            get
            {
                return new CalendarWidgetStyle();
            }
        }
    }
}
