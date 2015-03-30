using System;
using System.Linq;
using System.Text;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public partial class StatementWidget
    {
        public StatementWidget(UnitBase unit) : base(unit)
        {
            InitializeComponent();
        }

        protected override void UpdateValue()
        {
            ValueTextBlock.Text = Unit.Value.ToString();
        }
    }
}
