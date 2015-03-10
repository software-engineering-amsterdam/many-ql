using QuestionnaireLanguage.GUI.CustomUIElements.CustomControls;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using Values = AST.Nodes.Values;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class IntegerTextBoxWidget : TextBoxWidget
    {
        public IntegerTextBoxWidget(){}

        public override UIElement CreateUIControl()
        {
            return new CustomTextBox(true) { Name = Id };
        }

        public IntegerTextBoxWidget(string id, Values.Int node)
        {
            Id = id;
        }
    }
}
