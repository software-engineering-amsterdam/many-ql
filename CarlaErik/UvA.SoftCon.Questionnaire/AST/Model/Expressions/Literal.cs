using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
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

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
