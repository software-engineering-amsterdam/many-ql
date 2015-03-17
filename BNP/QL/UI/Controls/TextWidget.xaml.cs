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
using QL.UI.ControlWrappers;
using QL.UI.Interfaces;

namespace QL.UI.Controls
{
    /// <summary>
    /// Interaction logic for TextWidget.xaml
    /// </summary>
    public partial class TextWidget : IWidget
    {
        private readonly WidgetWrapperBase _context;
        public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(object), typeof(TextWidget));
        public static readonly DependencyProperty TextProperty = DependencyProperty.Register("Text", typeof(object), typeof(TextWidget));

        public object Value
        {
            get { return (string)GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public object Text
        {
            get { return (string)GetValue(TextProperty); }
            set { SetValue(TextProperty, value); }
        }

        public TextWidget(WidgetWrapperBase context)
        {
            _context = context;
            InitializeComponent();

            BindContext();
            DataContext = this;
        }

        public void BindContext()
        {
            Text = _context.Text;
            Value = _context.Value;
            Name = _context.Identifier;
        }
    }
}
