using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Windows.Controls;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.UI.Annotations;

namespace QL.UI.Controls
{
    /// <summary>
    /// Forms the UI Framework base class for widgets and holds the related model class from the AST.
    /// This allows us to use databinding for UI elements to these model classess (UnitBase's)
    /// </summary>
    public abstract class WidgetBase : UserControl
    {
        protected UnitBase Unit { get; set; }

        /// <summary>
        /// Display text of the widget
        /// </summary>
        public abstract object Text { get; }

        /// <summary>
        /// Holds the value of the widget
        /// </summary>
        public abstract object Value { get; set; }

        protected WidgetBase(UnitBase unit, ITerminalWrapper terminalWrapper)
        {
            Unit = unit;
            Name = unit.Identifier.Value;
        }
    }

}
