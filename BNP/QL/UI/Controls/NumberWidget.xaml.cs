using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public partial class NumberWidget
    {
        public NumberWidget(UnitBase unit, NumberWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
        }
    }
}
