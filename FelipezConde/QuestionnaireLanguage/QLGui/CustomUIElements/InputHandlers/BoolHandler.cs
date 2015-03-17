using Evaluation;
using Evaluation.Values;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace QLGui.CustomUIElements.InputHandlers
{
    public class BoolHandler
    {
        public Bool GetValue(object sender)
        {
            return new Bool((sender as CustomCheckBox).IsChecked.Value);
        }
    }
}
