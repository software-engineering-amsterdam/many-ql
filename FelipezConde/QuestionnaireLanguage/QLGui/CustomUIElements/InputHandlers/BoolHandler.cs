using Evaluation.Values;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class BoolHandler
    {
        public Bool GetValue(object sender)
        {
            return new Bool((sender as CustomCheckBox).IsChecked.Value);
        }
    }
}
