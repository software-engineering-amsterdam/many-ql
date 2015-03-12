using AST.Nodes.Values;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class CheckboxWidget : Widget
    {
        public CheckboxWidget(string id)
        {
            Id = id;
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomCheckBox() { Name = Id, IsChecked = value };
        }
    }
}
