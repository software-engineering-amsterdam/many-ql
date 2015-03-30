using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.UI.Controls;

namespace QL.UI.ControlWrappers
{
    public sealed class WidgetFactory
    {
        public WidgetBase GetWidget(QuestionUnit unit)
        {
            return GetWidget(unit, unit.DataType as dynamic);
        }

        public WidgetBase GetWidget(StatementUnit unit)
        {
            return new StatementWidget(unit, GetTypeWrapper(unit.DataType as dynamic));
        }

        #region Widget-wrapper creation methods
        private WidgetBase GetWidget(UnitBase unit, Yesno type)
        {
            return new YesNoWidget(unit, GetTypeWrapper(type) as YesnoWrapper);
        }

        private WidgetBase GetWidget(UnitBase unit, Number type)
        {
            return new NumberWidget(unit, GetTypeWrapper(type) as NumberWrapper);
        }

        private WidgetBase GetWidget(UnitBase unit, Text type)
        {
            return new TextWidget(unit, GetTypeWrapper(type) as TextWrapper);
        }
        #endregion
        
        #region Terminal-wrapper creation methods
        private ITerminalWrapper GetTypeWrapper(Yesno type)
        {
            return new YesnoWrapper(type);
        }

        private ITerminalWrapper GetTypeWrapper(Number type)
        {
            return new NumberWrapper(type);
        }

        private ITerminalWrapper GetTypeWrapper(Text type)
        {
            return new TextWrapper(type);
        }
        #endregion

    }
}
