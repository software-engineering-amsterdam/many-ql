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
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.UI.ControlWrappers;

namespace QL.UI.Controls
{
    /// <summary>
    /// Interaction logic for TextWidget.xaml
    /// </summary>
    public partial class StatementWidget
    {
        public override object Text
        {
            get { return (string)Unit.DisplayText; }
        }

        public override object Value
        {
            get { return (string)((StatementUnit)Unit).Expression.Child.ToString(); }
            set { }
        }

        public StatementWidget(UnitBase unit, ITerminalWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
            DataContext = this;

            StatementUnit statement = unit as StatementUnit;

            Unit = statement;
        }
    }
}
