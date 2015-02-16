using QuestionnaireLanguage.GUI.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Form
{
    public class FormSection
    {
        public StackPanel CreateForm()
        {
            StackPanel _stack = new StackPanel();

            return _stack;
        }

        public StackPanel AddChildren(StackPanel panel, Control control)
        {
            panel.Children.Add(control);

            return panel;
        }
    }
}
