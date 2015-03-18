using QLGui.CustomUIElements.InputHandlers;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.CustomUIElements
{
    public class CustomCheckBox : CheckBox
    {
        private BoolHandler inputHandler = new BoolHandler();
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
            EventUpdateValue(((CustomCheckBox)sender).Name, inputHandler.GetValue(sender));
        }

        #endregion


        
    }
}
