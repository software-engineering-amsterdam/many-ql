using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using QL.AST.Nodes.Branches;
using QL.AST.ValueWrappers;
using QL.UI.ControlWrappers;

namespace QL.UI.Controls
{
    public partial class TextWidget
    {
        public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(object), typeof(TextWidget));
        public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(object), typeof(TextWidget));

        public override object Value
        {
            get { return (string)GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public override object Text
        {
            get { return (string)GetValue(TextProperty); }
            protected set { SetValue(TextProperty, value); }
        }

        public TextWidget(UnitBase unit, TextWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
            DataContext = this;

            Text = unit.DisplayText;
            Value = terminalWrapper.Value;
        }
    }
}
