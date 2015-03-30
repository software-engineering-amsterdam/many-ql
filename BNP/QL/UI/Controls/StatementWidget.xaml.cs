using System.ComponentModel;
using QL.AST.Nodes.Branches;

namespace QL.UI.Controls
{
    public partial class StatementWidget
    {
        public StatementWidget(UnitBase unit) : base(unit)
        {
            // Workaround that fixes WPF DataBinding problem where values are properly bound but not UI updated
            SubscribeDataBinding();
            
            InitializeComponent();
        }

        private void SubscribeDataBinding()
        {
            if (Unit.Value is INotifyPropertyChanged)
            {
                (Unit.Value as INotifyPropertyChanged).PropertyChanged += new PropertyChangedEventHandler(UpdateValue);
            }
        }

        private void UpdateValue(object sender, PropertyChangedEventArgs propertyChangedEventArgs)
        {
            ValueTextBlock.Text = Unit.Value.ToString();
        }
    }
}
