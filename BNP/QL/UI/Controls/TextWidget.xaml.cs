using System;
using System.Collections.Generic;
using System.Windows;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public partial class TextWidget
    {
        public TextWidget(UnitBase unit, TextWrapper terminalWrapper) : base(unit, terminalWrapper)
        {
            InitializeComponent();
        }
    }
}
