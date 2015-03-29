using System;
using System.Collections.Generic;
using System.Windows;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public partial class TextWidget
    {
        public override object Text
        {
            get { return (string)Unit.DisplayText; }
        }

        public override object Value
        {
            get { return (string)Unit.Value; }
            set { Unit.Value = value; }
        }

        public TextWidget(UnitBase unit, TextWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
            DataContext = this;

            Unit = unit;
            Value = terminalWrapper.Value;
        }
    }
}
