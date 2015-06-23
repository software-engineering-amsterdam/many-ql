using Evaluation;
using Values = Evaluation.Values;
using System;
using System.Windows;
using System.Windows.Controls;

namespace QLGui.ValueVisitors
{
    public class ValueToStackPanel : IValueVisitor<StackPanel>
    {

        public StackPanel Visit(Values.Bool value) // set stackpanel visibility based on boolean value.
        {
            return new StackPanel(){ Visibility = value.GetValue() ? Visibility.Visible : Visibility.Collapsed };
        }

        public StackPanel Visit(Values.String value)
        {
            throw new ArgumentException("StackPanel cannot be created using Evaluation.Values.String");
        }

        public StackPanel Visit(Values.Int value)
        {
            throw new ArgumentException("StackPanel cannot be created using Evaluation.Values.Int");
        }
    }
}
