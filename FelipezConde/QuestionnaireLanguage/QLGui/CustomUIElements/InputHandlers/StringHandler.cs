using Values = Evaluation.Values;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class StringHandler : InputHandler
    {
        public override Values.Value UpdateValue(object sender)
        {
            return new Values.String(((CustomTextBox)sender).Text);
        }
    }
}
