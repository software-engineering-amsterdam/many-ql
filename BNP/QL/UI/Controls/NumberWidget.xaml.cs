using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Windows;
using System.Windows.Controls;
using QL.AST.Nodes.Branches;

namespace QL.UI.Controls
{
    public partial class NumberWidget
    {
        public NumberWidget(UnitBase unit) : base(unit)
        {
            InitializeComponent();
        }
    }
}
