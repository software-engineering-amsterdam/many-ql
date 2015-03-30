using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.UI.Controls;

namespace QL.UI.ControlWrappers
{
    public sealed class WidgetFactory
    {
        public WidgetBase GetWidget(StatementUnit unit)
        {
            return new StatementWidget(unit);
        }

        public WidgetBase GetWidget(QuestionUnit unit)
        {
            return GetWidget(unit, unit.DataType as dynamic);
        }

        public WidgetBase GetWidget(QuestionUnit unit, ITerminalWrapper typeWrapper)
        {
            return GetWidget(unit, typeWrapper as dynamic);
        }

        public WidgetBase GetWidget(QuestionUnit unit, YesnoWrapper typeWrapper)
        {
            unit.InitialiseValue(typeWrapper);
            return new YesNoWidget(unit);
        }

        public WidgetBase GetWidget(QuestionUnit unit, NumberWrapper typeWrapper)
        {
            unit.InitialiseValue(typeWrapper);
            return new NumberWidget(unit);
        }

        public WidgetBase GetWidget(QuestionUnit unit, TextWrapper typeWrapper)
        {
            unit.InitialiseValue(typeWrapper);
            return new TextWidget(unit);
        }

        #region Widget-wrapper creation methods
        private WidgetBase GetWidget(QuestionUnit unit, Yesno type)
        {
            unit.InitialiseValue(GetTypeWrapper(type));
            return new YesNoWidget(unit);
        }

        private WidgetBase GetWidget(QuestionUnit unit, Number type)
        {
            unit.InitialiseValue(GetTypeWrapper(type));
            return new NumberWidget(unit);
        }

        private WidgetBase GetWidget(QuestionUnit unit, Text type)
        {
            unit.InitialiseValue(GetTypeWrapper(type));
            return new TextWidget(unit);
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
