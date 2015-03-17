using Evaluation;
using QLGui.FormObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.ValueVisitors
{
    public class ValueToStackPanel : IValueVisitor<StackPanel>
    {

        public StackPanel Visit(Evaluation.Values.Bool value)
        {
            return new StackPanel(){ Visibility = value.GetValue() ? Visibility.Visible : Visibility.Collapsed };
        }

        public StackPanel Visit(Evaluation.Values.String value)
        {
            throw new ArgumentException("StackPanel cannot be created using Evaluation.Values.String");
        }

        public StackPanel Visit(Evaluation.Values.Int value)
        {
            throw new ArgumentException("StackPanel cannot be created using Evaluation.Values.Int");
        }
    }
}
