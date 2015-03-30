using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.AST.Nodes.Branches
{
    public class StatementUnit : UnitBase
    {
        public Expression Expression;

        public StatementUnit(Identifier identifier, Expression expression, string unitText, IStaticReturnType dataType, SourceLocation sourceLocation)
            : base(identifier, dataType, unitText, sourceLocation)
        {
            Expression = expression;
        }

        public override ITerminalWrapper Value
        {
            get;
            set;
        }
    }
}
