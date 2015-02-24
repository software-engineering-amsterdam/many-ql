using QL.Model.Terminals;

namespace QL.Model
{
    public class StatementUnit : UnitBase
    {
        public Expression Expression
        {
            get {
            return (Expression)Children[0];
            }
            set{
            Children.Clear();
            Children.Add(value);
            }
        }
        public StatementUnit() { }
        public StatementUnit(Identifier identifier, ITerminalType dataType, string displayText, params string[] parameters)
        {
            Identifier = identifier;
            DataType = dataType;
            DisplayText = displayText;
            Parameters = parameters;
        }

    }
}
