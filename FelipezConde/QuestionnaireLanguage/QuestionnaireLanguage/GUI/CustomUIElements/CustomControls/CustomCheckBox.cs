using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.Presenter;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class CustomCheckBox : CheckBox
    {
        private BoolHandler inputHandler = new BoolHandler();
        public EventUpdateValue eventUpdateValue;

        #region Constructors
        public CustomCheckBox()
        {
            this.Click += CustomCheckBox_Click;
        }
        #endregion

        #region Events
        void CustomCheckBox_Click(object sender, RoutedEventArgs e)
        {
            eventUpdateValue(((CustomCheckBox)sender).Name, inputHandler.GetValue(sender));
        }

        #endregion


        
    }
}
