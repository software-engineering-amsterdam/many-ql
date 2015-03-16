using AST.Representation;
using Evaluator.Values;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Input;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class IntHandler : ObjectHandler
    {
        public override void CheckValidCharacter(object sender, TextCompositionEventArgs e)
        {
            if (!Regex.IsMatch(e.Text, @"^\d$"))
            {
                e.Handled = true;
            }
        }

        public override Value UpdateValue(object sender)
        {
            return new Int(int.Parse(((CustomTextBox)sender).Text));
        }
    }
}
