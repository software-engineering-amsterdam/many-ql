using System.Windows.Controls;
using QL.Model;
using QL.Model.Terminals.Wrappers;
using QL.UI.Controls;
using QL.Visitors;

namespace QL.UI.ControlWrappers
{
    public class StatementWidgetWrapper : WidgetWrapperBase
    {
        private readonly ITerminalWrapper _terminalWrapper;

        public override string Identifier
        {
            get { return Unit.Identifier.Value; }
        }

        public override object Text
        {
            get { return Unit.DisplayText; }
        }

        public override object Value
        {
            get
            {
                // Call ToString as the value can be of any type.
                // Each terminal wrapper has overridden the ToString() to ensure proper display in a statement.
                return _terminalWrapper.ToString();
            }
            set { return;  }
        }

        public StatementWidgetWrapper(UnitBase unit, ITerminalWrapper terminalWrapper) : base(unit)
        {
            _terminalWrapper = terminalWrapper;
        }

        public override UserControl GetWidget()
        {
            return new StatementWidget(this);
        }
    }
}
