using System;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Windows.Data;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public partial class YesNoWidget
    {
        private readonly YesnoWrapper _terminalWrapper;

        public YesNoWidget(UnitBase unit, YesnoWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            _terminalWrapper = terminalWrapper;
            InitializeComponent();
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
