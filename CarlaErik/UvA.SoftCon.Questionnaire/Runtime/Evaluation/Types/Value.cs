using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public abstract class Value : IValue
    {
        public virtual bool IsUndefined
        {
            get
            {
                return false;
            }
        }

        public virtual IInteger Plus(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger PlusInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger Minus(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger MinusInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger MultipliedBy(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger MultipliedByInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger DividedBy(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger DividedByInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IInteger Increment()
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsEqualToInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsEqualToString(IString value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsEqualToBool(IBoolean value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsNotEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsNotEqualToInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsNotEqualToString(IString value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsNotEqualToBool(IBoolean value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsLessThan(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsLessThanInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsLessThanOrEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsLessThanOrEqualToInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsGreaterThan(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsGreaterThanInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsGreaterThanOrEqualTo(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean IsGreaterThanOrEqualToInt(IInteger value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean And(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean AndBool(IBoolean value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean Or(IValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean OrBool(IBoolean value)
        {
            throw new InvalidOperationException();
        }

        public virtual IBoolean Negate()
        {
            throw new InvalidOperationException();
        }
    }

    public abstract class Value<T> : Value, IValue<T>
    {
        public new T Val
        {
            get;
            private set;
        }

        public Value(T value)
        {
            Val = value;
        }
    }
}
