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
        private static IList<string> listConditionalId;

        public IList<string> ListConditionalId
        {
            get { return listConditionalId; }
            private set { listConditionalId = value; }
        }

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

        #region ICustomControl
        public void AddConditionalPanelId(string id)
        {
            ListConditionalId.Add(id);
        }
        #endregion

        #region Events
        void CustomDatePicker_SelectedDateChanged(object sender, SelectionChangedEventArgs e)
        {
            throw new NotImplementedException();
        }
        #endregion
    }
}
