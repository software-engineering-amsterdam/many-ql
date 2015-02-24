using QL.Model.Terminals;

namespace QL.Model
{
    public class StatementUnit : UnitBase
    {
        public StatementUnit() { }
        public StatementUnit(Identifier identifier, ITerminalType dataType, string displayText, params string[] parameters)
        {
            Id = identifier;
            DataType = dataType;
            DisplayText = displayText;
            Parameters = parameters;
        }
    }
}
