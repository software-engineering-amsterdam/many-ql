using System.ComponentModel;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.AST.Nodes.Branches
{
    public class StatementUnit : UnitBase
    {
        private object _value;
        public Expression Expression;

        public StatementUnit(Identifier identifier, Expression expression, string unitText, IStaticReturnType dataType, SourceLocation sourceLocation)
            : base(identifier, dataType, unitText, sourceLocation)
        {
            Expression = expression;
        }

        public override object Value
        {
            get { return _value; }
            set
            {
                _value = value;
                if (value is INotifyPropertyChanged)
                {
                    (value as INotifyPropertyChanged).PropertyChanged += (x,y) => System.Diagnostics.Debug.WriteLine(y.PropertyName);
                }
            }
        }
    }
}
