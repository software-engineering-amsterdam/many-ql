using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class CustomLabel : Label, ICustomControl
    {
        private IList<string> listConditionalId;
        public IList<string> ListConditionalId
        {
            get { return this.listConditionalId; }
            private set { this.listConditionalId = value; }

        }

        #region Constructor
        public CustomLabel() { }
        #endregion


        public void AddConditionalPanelId(string id)
        {
            ListConditionalId.Add(id);
        }
    }
}
