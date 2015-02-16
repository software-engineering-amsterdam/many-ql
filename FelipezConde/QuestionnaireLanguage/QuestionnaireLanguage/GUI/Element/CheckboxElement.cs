using QuestionnaireLanguage.GUI.Elements;
using QuestionnaireLanguage.GUI.Interfaces.Element;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Element
{
    class CheckboxElement : ElementBase, ICheckBoxElement
    {
        public Control GetControl()
        {
            return null;
        }

        public Control SetProperties(Dictionary<string,string> keyValue)
        {
            return null;
        }
    }
}
