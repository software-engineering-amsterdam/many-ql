using AST.Nodes.Literals;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanels;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class StackPanelWidget : Widget
    {
        public StackPanelWidget()
        {
        }

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomStackPanel() { Visibility = value ? Visibility.Visible : Visibility.Hidden };
        }
    }
}
