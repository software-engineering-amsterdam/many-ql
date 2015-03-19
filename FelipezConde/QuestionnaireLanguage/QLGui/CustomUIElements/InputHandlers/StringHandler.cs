using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;
using System.Windows.Input;
using Values = Evaluation.Values;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class StringHandler : InputHandler
    {
        public override Values.Value UpdateValue(object sender)
        {
            return new Values.String(((CustomTextBox)sender).Text);
        }
    }
}
