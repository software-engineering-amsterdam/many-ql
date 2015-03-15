using AST.Nodes.Literals;
using QuestionnaireLanguage.Controller;
using QuestionnaireLanguage.Factories;
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
        #region Constructors
        public CustomCheckBox()
        {
            AddEvents();
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
            MainController.UpdateValue(((CustomCheckBox)sender).Name,
                                   NodeValueFactory.GetNodeValue(((CustomCheckBox)sender).IsChecked));
        }

        #endregion


        
    }
}
