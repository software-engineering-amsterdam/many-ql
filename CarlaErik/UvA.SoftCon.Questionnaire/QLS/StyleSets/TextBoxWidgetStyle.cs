using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class TextBoxWidgetStyle : WidgetStyle
    {
        public static TextBoxWidgetStyle Default
        {
            get
            {
                return new TextBoxWidgetStyle();
            }
        }
    }
}
