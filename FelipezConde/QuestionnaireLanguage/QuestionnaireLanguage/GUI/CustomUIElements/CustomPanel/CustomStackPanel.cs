using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel
{
    public class CustomStackPanel : StackPanel
    {
        public CustomStackPanel()
        {
        }

        

        public void Visible(bool visible)
        {
            if (visible)
            {
                this.Visibility = System.Windows.Visibility.Visible;
            }
            else
            {
                this.Visibility = System.Windows.Visibility.Hidden;
            }
        }
    }
}
