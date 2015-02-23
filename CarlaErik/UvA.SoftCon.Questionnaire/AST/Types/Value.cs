using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Types
{
    public interface IValue
    {
        Integer Add(IValue value);
        Integer AddInt(Integer value);
        Integer Substract(IValue value);
        Integer Multiply(IValue value);
        Integer Divide(IValue value);

        Boolean EqualTo(IValue value);
        Boolean NotEqualTo(IValue value);
        Boolean LessThan(IValue value);
        Boolean LessThanOrEqualTo(IValue value);
        Boolean GreaterThan(IValue value);
        Boolean GreaterThanOrEqualTo(IValue value);
    }


    public abstract class Value<T> : IValue
    {
        public T Value { get; private set; }

        protected Value(DataType dataType, T value)
            : base(dataType)
        {
            Value = value;
        }

        public virtual Integer Add(IValue value)
        {
            throw new InvalidOperationException();
        }

        internal virtual Integer AddInteger(Integer value);

        public virtual Integer Substract(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Integer Multiply(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Integer Divide(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean EqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean NotEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean LessThan(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean LessThanOrEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean GreaterThan(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Boolean GreaterThanOrEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }
    }
}
