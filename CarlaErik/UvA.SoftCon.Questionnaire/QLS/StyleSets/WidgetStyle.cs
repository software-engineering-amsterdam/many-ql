using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public abstract class WidgetStyle
    {
        public abstract object CreateWidgetControl(IWidgetFactory factory);
    }
}
