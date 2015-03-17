using System.Windows.Controls;
using QL.Model;
using QL.Model.Terminals.Wrappers;
using QL.UI.Controls;
using QL.Visitors;

namespace QL.UI.ControlWrappers
{
    public class TextWidgetWrapper : WidgetWrapperBase
    {
        private readonly TextWrapper _terminalWrapper;

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
            get { return _terminalWrapper.Value; }
            set { _terminalWrapper.Value = (string)value; }
        }

        public TextWidgetWrapper(UnitBase unit, TextWrapper terminalWrapper) : base(unit)
        {
            _terminalWrapper = terminalWrapper;
        }

        public override UserControl GetWidget()
        {
            return new TextWidget(this);
        }
    }
}
