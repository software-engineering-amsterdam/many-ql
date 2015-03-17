using QuestionnaireLanguage.Events;
using QuestionnaireLanguage.Presenter;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class CustomTextBox : TextBox
    {
        private ObjectHandler inputHandler;
        public EventUpdateValue EventUpdateValue { get; set; }

        #region Constructors
        public CustomTextBox(ObjectHandler inputValidation)
        {
            this.inputHandler = inputValidation;
            AddEvents();
        }

        #endregion

        #region Private Methods
        private void AddEvents()
        {
            this.PreviewTextInput += new TextCompositionEventHandler(inputHandler.CheckValidCharacter);
            this.LostKeyboardFocus += Lost_Focus;
        }
        #endregion

        #region Events
        private void Lost_Focus(object sender, KeyboardFocusChangedEventArgs e)
        {
            if (inputHandler.IsValid((sender as CustomTextBox).Text))
            {
                EventUpdateValue(((CustomTextBox)sender).Name, inputHandler.UpdateValue(sender));

                this.BorderBrush = Brushes.Black;
            }
            else
            {
                this.BorderBrush = Brushes.Red;
            }
        }

        #endregion
    }
}
