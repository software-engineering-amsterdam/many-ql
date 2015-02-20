using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public class Literal<T> : Node, IExpression
    {
        public T Value
        {
            get;
            private set;
        }

        public Literal(T value)
        {
            Value = value;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit<T>(this);
        }
    }
}
