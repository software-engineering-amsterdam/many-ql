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

        public override UIElement CreateUIControl(dynamic value)
        {
            return new CustomTextBox(true) { Name = Id, Text = GetControlValue(value) };
        }

        private string GetControlValue(dynamic value)
        {
            string result = string.Empty;

            int outParse;
            if (int.TryParse(value.ToString(), out outParse))
            {
                if (outParse != int.MinValue)
                {
                    result = value.ToString();
                }
            }

            return result;
        }

        public IntegerTextBoxWidget(string id)
        {
            Id = id;
        }
    }
}
