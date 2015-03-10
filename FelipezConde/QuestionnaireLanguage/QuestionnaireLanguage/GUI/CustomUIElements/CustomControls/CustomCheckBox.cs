using AST.Nodes.Values;
using QuestionnaireLanguage.GUI.Interfaces.CustomControl;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class CustomCheckBox : CheckBox, ICustomControl
    {
        private IList<string> listConditionalId;
        public IList<string> ListConditionalId
        {
            get { return this.listConditionalId; }
            private set { this.listConditionalId = value; }

        }

        #region Constructors
        public CustomCheckBox()
        {
            AddEvents();
        }
        #endregion

        #region ICustomControl
        public void AddConditionalPanelId(string id)
        {
            ListConditionalId.Add(id);
        }
        #endregion

        #region Private Methods
        private void AddEvents()
        {
            this.Click += CustomCheckBox_Click;
        }
        #endregion

        #region Conditional Events
        void CustomCheckBox_Click(object sender, RoutedEventArgs e)
        {
            //TODO: Implement event
        }

        #endregion


        
    }
}
