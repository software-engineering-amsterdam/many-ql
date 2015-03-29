using System;
using System.Collections.Generic;
using System.Globalization;
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
using QL.AST.Nodes.Terminals.Wrappers;
using QL.UI.ControlWrappers;

namespace QL.UI.Controls
{
    public partial class YesNoWidget
    {
        public override object Text
        {
            get { return Unit.DisplayText; }
        }

        public override object Value
        {
            get { return (bool?)Unit.Value; }
            set { Unit.Value = value; }
        }

        public YesNoWidget(UnitBase unit, YesnoWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
            DataContext = this;

            Unit = unit;
            Value = terminalWrapper.Value;
        }
    }

    public class BooleanYesNoConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value == null || parameter == null) return false;

            return bool.Parse(value.ToString()) == bool.Parse(parameter.ToString());
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            return Convert(value, targetType, parameter, culture);
        }
    }
}
