using System;
using System.Globalization;
using System.Windows.Data;

namespace QL.UI.ValueConversion
{
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