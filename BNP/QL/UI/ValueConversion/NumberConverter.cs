using System;
using System.Globalization;
using System.Windows.Data;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.ValueConversion
{
    public class NumberConverter : IValueConverter
    {
        public object Convert(object value, Type targetType, object parameter, CultureInfo culture)
        {
            if (value is NumberWrapper)
            {    
                return (value as NumberWrapper).Value;
            }

            return value;
        }

        public object ConvertBack(object value, Type targetType, object parameter, CultureInfo culture)
        {
            return Convert(value, targetType, parameter, culture);
        }
    }
}