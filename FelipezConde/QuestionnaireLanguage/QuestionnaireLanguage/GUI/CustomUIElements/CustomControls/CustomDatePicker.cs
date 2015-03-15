using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.Factories;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    class CustomDatePicker : DatePicker, ICustomControl
    {

        #region Constructor
        public CustomDatePicker()
        {
            AddEvents();
        }
        #endregion

        #region Private Methods
        private void AddEvents()
        {
            this.SelectedDateChanged += CustomDatePicker_SelectedDateChanged;
        }
        #endregion

        #region Events
        void CustomDatePicker_SelectedDateChanged(object sender, SelectionChangedEventArgs e)
        {
            MainController.UpdateValue(((CustomDatePicker)sender).Name,
                                  NodeValueFactory.GetNodeValue(((CustomDatePicker)sender).Text));
        }
        #endregion
    }
}
