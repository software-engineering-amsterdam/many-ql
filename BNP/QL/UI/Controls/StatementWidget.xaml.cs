using System;
using System.Linq;
using System.Text;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    /// <summary>
    /// Interaction logic for TextWidget.xaml
    /// </summary>
    public partial class StatementWidget
    {
        private readonly ITerminalWrapper _terminalWrapper;

        public StatementWidget(UnitBase unit, ITerminalWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            _terminalWrapper = terminalWrapper;
            InitializeComponent();
        }
    }
}
