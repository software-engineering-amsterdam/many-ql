using Evaluation.Values;
using QLGui.CustomUIElements.InputHandlers;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.CustomUIElements
{
    public class CustomCheckBox : CheckBox
    {
        public EventUpdateValue EventUpdateValue { get; set; }

        #region Constructors
        public CustomCheckBox()
        {
            this.Click += CustomCheckBox_Click;
        }
        #endregion

        #region Events
        void CustomCheckBox_Click(object sender, RoutedEventArgs e)
        {
            CustomCheckBox UIElement = (CustomCheckBox)sender;

            EventUpdateValue(UIElement.Name, new Bool(UIElement.IsChecked.Value));
        }

        #endregion


        
    }
}
