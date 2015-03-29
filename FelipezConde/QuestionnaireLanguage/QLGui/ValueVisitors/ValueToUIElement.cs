using Evaluation;
using Evaluation.Values;
using QLGui.CustomUIElements;
using QLGui.CustomUIElements.InputHandlers;
using System.Windows;

namespace QLGui.ValueVisitors
{
    public class ValueToUIElement : IValueVisitor<UIElement>
    {
        private readonly string uiElementId;
        private readonly bool isReadOnly;
        public EventUpdateValue EventUpdateValue { get; set; }

        public ValueToUIElement(string uiElementId, bool isReadOnly)
        {
            this.uiElementId = uiElementId;
            this.isReadOnly = isReadOnly;
        }

        public UIElement Visit(Evaluation.Values.String value)
        {
            CustomTextBox customTextBox = new CustomTextBox(new StringHandler()) { Name = uiElementId, Text = value.GetValue(), IsReadOnly = isReadOnly };
            customTextBox.EventUpdateValue += UpdateValue;

            return customTextBox;
        }

        public UIElement Visit(Evaluation.Values.Int value)
        {
            CustomTextBox customTextBox = new CustomTextBox(new IntHandler()) { Name = uiElementId, Text = value.GetValue().ToString(), IsReadOnly = isReadOnly };
            customTextBox.EventUpdateValue += UpdateValue;

            return customTextBox;
        }

        public UIElement Visit(Evaluation.Values.Bool value)
        {
            CustomCheckBox customCheckBox = new CustomCheckBox() { Name = uiElementId, IsChecked = value.GetValue(), IsEnabled = !isReadOnly };
            customCheckBox.EventUpdateValue += UpdateValue;

            return customCheckBox;
        }

        private void UpdateValue(string id, Value value)
        {
            EventUpdateValue(id, value);
        }
    }
}
