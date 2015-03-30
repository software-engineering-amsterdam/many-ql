using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types
{
    public class Undefined : Value
    {
        public override DataType DataType
        {
            get
            {
                return DataType.Undefined;
            }
        }

        public override bool IsUndefined
        {
            get
            {
                return true;
            }
        }

        public override Value Plus(Value value)
        {
            return new Undefined();
        }

        internal override Value PlusInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value PlusString(StringValue value)
        {
            return new Undefined();
        }

        public override Value Minus(Value value)
        {
            return new Undefined();
        }

        internal override Value MinusInt(IntegerValue value)
        {
            return new Undefined();
        }

        public override Value MultipliedBy(Value value)
        {
            return new Undefined();
        }

        internal override Value MultipliedByInt(IntegerValue value)
        {
            return new Undefined();
        }

        public override Value DividedBy(Value value)
        {
            return new Undefined();
        }

        internal override Value DividedByInt(IntegerValue value)
        {
            return new Undefined();
        }

        public override Value IsEqualTo(Value value)
        {
            return new Undefined();
        }

        internal override Value IsEqualToInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsEqualToString(StringValue value)
        {
            return new Undefined();
        }

        internal override Value IsEqualToBool(BooleanValue value)
        {
            return new Undefined();
        }

        internal override Value IsEqualToDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value IsNotEqualTo(Value value)
        {
            return new Undefined();
        }

        internal override Value IsNotEqualToInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsNotEqualToString(StringValue value)
        {
            return new Undefined();
        }

        internal override Value IsNotEqualToBool(BooleanValue value)
        {
            return new Undefined();
        }

        internal override Value IsNotEqualToDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value IsLessThan(Value value)
        {
            return new Undefined();
        }

        internal override Value IsLessThanInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsLessThanDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value IsLessThanOrEqualTo(Value value)
        {
            return new Undefined();
        }

        internal override Value IsLessThanOrEqualToInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsLessThanOrEqualToDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value IsGreaterThan(Value value)
        {
            return new Undefined();
        }

        internal override Value IsGreaterThanInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsGreaterThanDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value IsGreaterThanOrEqualTo(Value value)
        {
            return new Undefined();
        }

        internal override Value IsGreaterThanOrEqualToInt(IntegerValue value)
        {
            return new Undefined();
        }

        internal override Value IsGreaterThanOrEqualToDate(DateValue value)
        {
            return new Undefined();
        }

        public override Value And(Value value)
        {
            return new Undefined();
        }

        internal override Value AndBool(BooleanValue value)
        {
            return new Undefined();
        }

        public override Value Or(Value value)
        {
            return new Undefined();
        }

        internal override Value OrBool(BooleanValue value)
        {
            return new Undefined();
        }

        public override Value Negate()
        {
            return new Undefined();
        }
    }
}
