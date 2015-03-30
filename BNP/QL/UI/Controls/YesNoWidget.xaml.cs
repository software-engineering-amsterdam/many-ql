using System;
using System.Globalization;
using System.Linq;
using System.Text;
using System.Windows;
using System.Windows.Data;
using QL.AST.Nodes.Branches;

namespace QL.UI.Controls
{
    public partial class YesNoWidget
    {
        public YesNoWidget(UnitBase unit) : base(unit)
        {
            InitializeComponent();
        }
    }

    public class BooleanYesNoConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value == null || parameter == null || value.ToString() == string.Empty) return false;

            bool desiredOutcome = bool.Parse(parameter.ToString());

            if (value.ToString().ToLowerInvariant() == "yes") return desiredOutcome == true;
            if (value.ToString().ToLowerInvariant() == "no") return desiredOutcome == false;

            return bool.Parse(value.ToString()) == desiredOutcome;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            return Convert(value, targetType, parameter, culture);
        }
    }
}
