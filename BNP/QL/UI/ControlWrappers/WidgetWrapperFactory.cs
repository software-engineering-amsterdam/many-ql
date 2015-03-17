using QL.Model;
using QL.Model.Terminals;
using QL.Model.Terminals.Wrappers;
using QL.Visitors;

namespace QL.UI.ControlWrappers
{
    public sealed class WidgetWrapperFactory
    {
        public WidgetWrapperBase GetWidgetWrapper(QuestionUnit unit)
        {
            return GetWidgetWrapper(unit, unit.DataType as dynamic);
        }

        public WidgetWrapperBase GetWidgetWrapper(StatementUnit unit)
        {
            return new StatementWidgetWrapper(unit, GetTypeWrapper(unit.DataType as dynamic));
        }

        #region Widget-wrapper creation methods
        private WidgetWrapperBase GetWidgetWrapper(UnitBase unit, Yesno type)
        {
            return new YesNoWidgetWrapper(unit, GetTypeWrapper(type) as YesnoWrapper);
        }

        private WidgetWrapperBase GetWidgetWrapper(UnitBase unit, Number type)
        {
            return new NumberWidgetWrapper(unit, GetTypeWrapper(type) as NumberWrapper);
        }

        private WidgetWrapperBase GetWidgetWrapper(UnitBase unit, Text type)
        {
            return new TextWidgetWrapper(unit, GetTypeWrapper(type) as TextWrapper);
        }
        #endregion
        
        #region Terminal-wrapper creation methods
        private TerminalWrapper GetTypeWrapper(Yesno type)
        {
            return new YesnoWrapper(type);
        }

        private TerminalWrapper GetTypeWrapper(Number type)
        {
            return new NumberWrapper(type);
        }

        private TerminalWrapper GetTypeWrapper(Text type)
        {
            return new TextWrapper(type);
        }
        #endregion

    }
}
