using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
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

        public abstract DataType GetType(IDictionary<string, DataType> symbolTable);

        public override string ToString()
        {
            return Value.ToString();
        }
    }
}
