using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals
{
    public abstract class Literal<T> : Node, IExpression
    {
        public T Value
        {
            get;
            private set;
        }

        protected Literal(T value, TextPosition position)
            : base(position)
        {
            Value = value;
        }

        public abstract DataType? GetType(IDictionary<string, DataType> symbolTable);

        public abstract IValue Evaluate(IDictionary<string, IValue> environment);

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
