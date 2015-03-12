using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.Factory;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Media;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class CustomTextBox : TextBox, ICustomControl
    {
        private bool isNumeric;
        private static IList<string> listConditionalId;

        public IList<string> ListConditionalId
        {
            get { return listConditionalId; }
            private set { listConditionalId = value; }

        }

        #region Constructors
        public CustomTextBox(bool isNumeric)
        {
            this.isNumeric = isNumeric;
            AddEvents();
        }

        #endregion

        #region Private Methods
        private void AddEvents()
        {
            if (isNumeric)
            {
                this.PreviewTextInput += new TextCompositionEventHandler(Validate_Numeric);
            }

            this.LostKeyboardFocus += Lost_Focus;
        }

        #endregion

        #region Events
        private void Validate_Numeric(object sender, TextCompositionEventArgs e)
        {
            int result;
            if (!int.TryParse(e.Text, out result))
            {
                e.Handled = true;
            }
        }
        private void Lost_Focus(object sender, KeyboardFocusChangedEventArgs e)
        {
            if (isNumeric)
            {
                int outValue = 0;
                int.TryParse(((CustomTextBox)sender).Text, out outValue);

                Processor.UpdateValue(((CustomTextBox)sender).Name,
                                   NodeValueFactory.GetNodeValue(outValue));
            }
            else
            {
                Processor.UpdateValue(((CustomTextBox)sender).Name,
                                   NodeValueFactory.GetNodeValue(((CustomTextBox)sender).Text));
            }
        }

        #endregion
    }
}
