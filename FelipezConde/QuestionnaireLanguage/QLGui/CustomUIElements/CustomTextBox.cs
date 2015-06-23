using QLGui.CustomUIElements.InputHandlers;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;
using System;

namespace QLGui.CustomUIElements
{
    public class CustomTextBox : TextBox
    {
        private InputHandler inputHandler;
        public EventUpdateValue EventUpdateValue { get; set; }

        #region Constructors
        public CustomTextBox(InputHandler inputValidation)
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
            CustomTextBox UIElement = (CustomTextBox)sender;

            try
            {
                if (inputHandler.IsValid(UIElement.Text))
                {
                    EventUpdateValue(UIElement.Name, inputHandler.CreateValue(UIElement));
                    this.BorderBrush = Brushes.Black;
                }
                else
                {
                    this.BorderBrush = Brushes.Red;
                }
            }
            catch (Exception error) 
            {
                UIElement.Text = error.Message;
                this.BorderBrush = Brushes.Red;
            }
        }

        #endregion
    }
}
