using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    public abstract class Literal : QLNode, IExpression
    {
        public string Value
        {
            get;
            private set;
        }

        public abstract bool IsValid { get; }

        protected Literal(string value, TextPosition position)
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

    public abstract class Literal<T> : Literal
    {
        protected Literal(string value, TextPosition position)
            : base(value, position) { }

        public abstract T GetValue();
    }
}
