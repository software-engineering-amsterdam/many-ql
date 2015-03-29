using System.Windows.Controls;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.UI.Controls
{
    public abstract class WidgetBase : UserControl
    {
        protected UnitBase Unit;
        protected ITerminalWrapper TerminalWrapper;

        /// <summary>
        /// Display text of the widget
        /// </summary>
        public abstract object Text { get; protected set; }

        /// <summary>
        /// Holds the value of the widget
        /// </summary>
        public abstract object Value { get; set; }

        protected WidgetBase(UnitBase unit, ITerminalWrapper terminalWrapper)
        {
            Unit = unit;
            TerminalWrapper = terminalWrapper;
            Name = unit.Identifier.Value;
        }
    }

}
