using System;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public abstract class Value
    {
        public abstract DataType DataType { get; }

        public virtual bool IsUndefined
        {
            get
            {
                return false;
            }
        }

        public virtual Value Plus(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Add, this, value));
        }

        internal virtual Value PlusInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Add, value, this));
        }

        internal virtual Value PlusString(StringValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Add, value, this));
        }

        public virtual Value Minus(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Substract, this, value));
        }

        internal virtual Value MinusInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Substract, value, this));
        }

        public virtual Value MultipliedBy(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Multiply, this, value));
        }

        internal virtual Value MultipliedByInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Multiply, value, this));
        }

        public virtual Value DividedBy(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Divide, this, value));
        }

        internal virtual Value DividedByInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.Divide, value, this));
        }

        public virtual Value IsEqualTo(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.EqualTo, this, value));
        }

        internal virtual Value IsEqualToInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.EqualTo, value, this));
        }

        internal virtual Value IsEqualToString(StringValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.EqualTo, value, this));
        }

        internal virtual Value IsEqualToBool(BooleanValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.EqualTo, value, this));
        }

        internal virtual Value IsEqualToDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.EqualTo, value, this));
        }

        public virtual Value IsNotEqualTo(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.NotEqualTo, this, value));
        }

        internal virtual Value IsNotEqualToInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.NotEqualTo, value, this));
        }

        internal virtual Value IsNotEqualToString(StringValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.NotEqualTo, value, this));
        }

        internal virtual Value IsNotEqualToBool(BooleanValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.NotEqualTo, value, this));
        }

        internal virtual Value IsNotEqualToDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.NotEqualTo, value, this));
        }

        public virtual Value IsLessThan(Value value)
        {
            throw new InvalidOperationException();
        }

        internal virtual Value IsLessThanInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.LessThan, value, this));
        }

        internal virtual Value IsLessThanDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.LessThan, value, this));
        }

        public virtual Value IsLessThanOrEqualTo(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.LessThanOrEqualTo, this, value));
        }

        internal virtual Value IsLessThanOrEqualToInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.LessThanOrEqualTo, value, this));
        }

        internal virtual Value IsLessThanOrEqualToDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.LessThanOrEqualTo, value, this));
        }

        public virtual Value IsGreaterThan(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThan, this, value));
        }

        internal virtual Value IsGreaterThanInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThan, value, this));
        }

        internal virtual Value IsGreaterThanDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThan, value, this));
        }

        public virtual Value IsGreaterThanOrEqualTo(Value value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThanOrEqualTo, this, value));
        }

        internal virtual Value IsGreaterThanOrEqualToInt(IntegerValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThanOrEqualTo, value, this));
        }

        internal virtual Value IsGreaterThanOrEqualToDate(DateValue value)
        {
            throw new InvalidOperationException(CreateMessage(Operation.GreaterThanOrEqualTo, value, this));
        }

        public virtual Value And(Value value)
        {
            throw new InvalidOperationException();
        }

        internal virtual Value AndBool(BooleanValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Value Or(Value value)
        {
            throw new InvalidOperationException();
        }

        internal virtual Value OrBool(BooleanValue value)
        {
            throw new InvalidOperationException();
        }

        public virtual Value Negate()
        {
            throw new InvalidOperationException(CreateMessage(Operation.Negation, this));
        }

        private string CreateMessage(Operation operation, Value operand)
        {
            return String.Format("Operator '{0}' can not be applied to operand of type '{1}'.",
                StringEnum.GetStringValue(operation), StringEnum.GetStringValue(operand.DataType));
        }

        private string CreateMessage(Operation operation, Value left, Value right)
        {
            return String.Format("Operator '{0}' can not be applied to operands of types '{1}' and '{2}'.",
                StringEnum.GetStringValue(operation), StringEnum.GetStringValue(left.DataType), StringEnum.GetStringValue(right.DataType));
        }
    }

    public abstract class Value<T> : Value
    {
        public T Val
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
