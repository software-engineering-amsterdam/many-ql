using QL.AST.Nodes.Terminals;

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

        public override object Value
        {
            get { return Expression.Child; }
            set { }
        }
    }
}
