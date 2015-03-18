using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using QL.Model;
using QL.Model.Terminals.Wrappers;
using QL.UI.ControlWrappers;

namespace QL.UI.Controls
{
    public partial class NumberWidget
    {
        public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(object), typeof(NumberWidget));
        public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(object), typeof(NumberWidget));
        
        public readonly BooleanToVisibilityConverter VisibilityConverter = new BooleanToVisibilityConverter();

        public override object Value
        {
            get { return GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public override object Text
        {
            get { return GetValue(TextProperty); }
            protected set { SetValue(TextProperty, value); }
        }

        public NumberWidget(UnitBase unit, NumberWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
            DataContext = this;

            Text = unit.DisplayText;
            Value = terminalWrapper.Value;
        }
    }
}
