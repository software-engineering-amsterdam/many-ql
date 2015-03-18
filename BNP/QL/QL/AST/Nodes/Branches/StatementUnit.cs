using QL.Model.Terminals;
using System;

namespace QL.Model
{
    public class StatementUnit : UnitBase
    {
        public Expression Expression;

        public StatementUnit()
        { }

        public StatementUnit(Identifier identifier, IResolvableTerminalType dataType, string displayText)
        {
            Identifier = identifier;
            DataType = dataType;
            DisplayText = displayText;
        }

    }
}
