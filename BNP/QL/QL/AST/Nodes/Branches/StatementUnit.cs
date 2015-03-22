using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class StatementUnit : UnitBase
    {
        public Expression Expression;

        public StatementUnit()
        { }

        public StatementUnit(Identifier identifier, IStaticReturnType dataType, string displayText)
        {
            Identifier = identifier;
            DataType = dataType;
            DisplayText = displayText;
        }

        public StatementUnit(Identifier identifier, Expression expression, IStaticReturnType dataType, string unitText, AST.SourceLocation sourceLocation)
        {
            
            Identifier = identifier;
            Expression = expression;
            DataType = dataType;
            DisplayText = unitText;
            SourceLocation = sourceLocation;
        }

    }
}
