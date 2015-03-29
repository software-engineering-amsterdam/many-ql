using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    public abstract class Literal : Expression
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
