using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class BaseWidget<T>
    {
        public abstract Widget CreateUIControl();
    }
}
