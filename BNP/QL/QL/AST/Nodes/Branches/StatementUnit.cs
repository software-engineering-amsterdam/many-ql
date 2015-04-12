using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class StatementUnit : UnitBase
    {
        private object _value;

        /// <summary>
        /// The expression holds the evaluatable expression tree of this unit's value
        /// </summary>
        public Expression Expression;
        public override object Value
        {
            get { return _value; }
            set
            {
                if (Equals(value, _value)) return;
                _value = value;
                OnPropertyChanged();
            }
        }

        public StatementUnit(Identifier identifier, Expression expression, string unitText, IStaticReturnType dataType, SourceLocation sourceLocation)
            : base(identifier, dataType, unitText, sourceLocation)
        {
            Expression = expression;
        }
    }
}
