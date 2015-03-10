using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class TextBoxWidget : Widget
    {
        public override abstract UIElement CreateUIControl();
    }
}
