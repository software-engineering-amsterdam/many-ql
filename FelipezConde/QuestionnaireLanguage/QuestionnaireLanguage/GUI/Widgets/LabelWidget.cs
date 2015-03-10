using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using AST.Nodes.Labels;
using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class LabelWidget : Widget
    {
        private Label node;
        public LabelWidget(Label node)
        {
            this.node = node;
        }
        public override UIElement CreateUIControl()
        {
            return new CustomLabel() { Content = node.Value };
        }
    }
}
