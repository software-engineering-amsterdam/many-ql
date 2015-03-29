using Values = Evaluation.Values;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class StringHandler : InputHandler
    {
        public override Values.Value CreateValue(CustomTextBox sender)
        {
            return new Values.String(sender.Text);
        }
    }
}
