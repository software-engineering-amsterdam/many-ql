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
using QL.UI.Interfaces;

namespace QL.UI.Controls
{
    /// <summary>
    /// Interaction logic for TextWidget.xaml
    /// </summary>
    public partial class YesNoWidget : IWidget
    {
        public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(object), typeof(YesNoWidget));
        public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(object), typeof(YesNoWidget));

        public object Value
        {
            get { return (bool)GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public object Text
        {
            get { return (string)GetValue(TextProperty); }
            set { SetValue(TextProperty, value); }
        }

        public YesNoWidget()
        {
            InitializeComponent();
            DataContext = this;
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
