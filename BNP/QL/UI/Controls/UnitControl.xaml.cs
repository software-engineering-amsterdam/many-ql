using System.Windows;
using System.Windows.Controls;
using QL.UI.Interfaces;

namespace QL.UI.Controls
{
    /// <summary>
    /// Interaction logic for QuestionUnit.xaml
    /// </summary>
    public partial class UnitControl
    {
        public static readonly DependencyProperty ValueProperty = DependencyProperty.Register("Value", typeof(object), typeof(UnitControl));

        public object Value
        {
            get { return GetValue(ValueProperty); }
            set { SetValue(ValueProperty, value); }
        }

        public UnitControl()
        {
            InitializeComponent();

            //BindChildValue(this.ContentPlaceholder.Content);
        }

        public void BindChildValue(IWidgetForType<string> element)
        {
            
        }

        public void BindChildValue(IWidgetForType<bool> element)
        {
            
        }

        public void BindChildValue(IWidgetForType<int> element)
        {
            
        }
    }
}
