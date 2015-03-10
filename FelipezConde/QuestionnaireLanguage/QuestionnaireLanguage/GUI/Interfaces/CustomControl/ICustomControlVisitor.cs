using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Interfaces.CustomControl
{
    public interface ICustomControlVisitor
    {
        void AddConditionalEvent(Control customControl);
    }
}
