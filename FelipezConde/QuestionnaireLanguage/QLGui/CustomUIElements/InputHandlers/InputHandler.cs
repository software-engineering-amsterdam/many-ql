using Evaluation.Values;
using System.Windows.Input;

namespace QLGui.CustomUIElements.InputHandlers
{
    public abstract class InputHandler
    {
        public virtual void CheckValidCharacter(object sender, TextCompositionEventArgs e) {}

        public abstract Value CreateValue(CustomTextBox sender);
        public virtual bool IsValid(string text)
        {
            return true;
        }
    }
}
