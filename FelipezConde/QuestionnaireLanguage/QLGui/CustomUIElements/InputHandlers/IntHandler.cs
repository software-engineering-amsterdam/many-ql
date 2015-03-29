using Evaluation.Values;
using System.Text.RegularExpressions;
using System.Windows.Input;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class IntHandler : InputHandler
    {
        public override void CheckValidCharacter(object sender, TextCompositionEventArgs e)
        {
            if (!Regex.IsMatch(e.Text, @"^\d$"))
            {
                e.Handled = true;
            }
        }

        public override Value CreateValue(CustomTextBox sender)
        {
            return new Int(int.Parse(sender.Text));
        }
    }
}
