using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Input;
using Values = Evaluation.Values;

namespace QuestionnaireLanguage.GUI.CustomUIElements.CustomControls
{
    public class StringHandler : ObjectHandler
    {
        public override Values.Value UpdateValue(object sender)
        {
            return new Values.String(((CustomTextBox)sender).Text);
        }
    }
}
