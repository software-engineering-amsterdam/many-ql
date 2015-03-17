using System.Windows.Controls;
using QL.Model;
using QL.Model.Terminals.Wrappers;
using QL.UI.Controls;
using QL.Visitors;

namespace QL.UI.ControlWrappers
{
    public class YesNoWidgetWrapper : WidgetWrapperBase
    {
        private readonly YesnoWrapper _terminalWrapper;

        public override string Identifier
        {
            get { return Unit.Identifier.Value; }
        }

        public override object Text {
            get { return Unit.DisplayText; }
        }

        public override object Value
        {
            get { return _terminalWrapper.Value; }
            set { _terminalWrapper.Value = (bool?)value; }
        }

        public YesNoWidgetWrapper(UnitBase unit, YesnoWrapper terminalWrapper) : base(unit)
        {
            _terminalWrapper = terminalWrapper;
        }

        public override UserControl GetWidget()
        {
            return new YesNoWidget(this);
        }
    }
}
