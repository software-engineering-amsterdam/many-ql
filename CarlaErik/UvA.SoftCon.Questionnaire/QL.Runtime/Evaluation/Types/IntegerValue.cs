using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types
{
    public class IntegerValue : Value<int>
    {
        public override DataType DataType
        {
            get
            {
                return DataType.Integer;
            }
        }

        public IntegerValue(int value)
            : base(value) { }

        public override Value Plus(Value value)
        {
            return value.PlusInt(this);
        }

        internal override Value PlusInt(IntegerValue value)
        {
            return new IntegerValue(value.Val + Val);
        }

        public override Value Minus(Value value)
        {
            return value.MinusInt(this);
        }

        internal override Value MinusInt(IntegerValue value)
        {
            return new IntegerValue(value.Val - this.Val);
        }

        public override Value MultipliedBy(Value value)
        {
            return value.MultipliedByInt(this);
        }

        internal override Value MultipliedByInt(IntegerValue value)
        {
            return new IntegerValue(value.Val * this.Val);
        }

        public override Value DividedBy(Value value)
        {
            return value.DividedByInt(this);
        }

        internal override Value DividedByInt(IntegerValue value)
        {
            return new IntegerValue((int)Math.Round(value.Val / (decimal)this.Val));
        }

        public override Value IsEqualTo(Value value)
        {
            return value.IsEqualToInt(this);
        }

        internal override Value IsEqualToInt(IntegerValue value)
        {
            return new BooleanValue(value.Val == this.Val);
        }

        public override Value IsNotEqualTo(Value value)
        {
            return value.IsNotEqualToInt(this);
        }

        internal override Value IsNotEqualToInt(IntegerValue value)
        {
            return new BooleanValue(value.Val != this.Val);
        }

        public override Value IsLessThan(Value value)
        {
            return value.IsLessThanInt(this);
        }

        internal override Value IsLessThanInt(IntegerValue value)
        {
            return new BooleanValue(value.Val <= this.Val);
        }

        public override Value IsLessThanOrEqualTo(Value value)
        {
            return value.IsLessThanOrEqualToInt(this);
        }

        internal override Value IsLessThanOrEqualToInt(IntegerValue value)
        {
            return new BooleanValue(value.Val <= this.Val);
        }

        public override Value IsGreaterThan(Value value)
        {
            return value.IsGreaterThanInt(this);
        }

        internal override Value IsGreaterThanInt(IntegerValue value)
        {
            return new BooleanValue(value.Val > this.Val);
        }

        public override Value IsGreaterThanOrEqualTo(Value value)
        {
            return value.IsGreaterThanOrEqualToInt(this);
        }

        internal override Value IsGreaterThanOrEqualToInt(IntegerValue value)
        {
            return new BooleanValue(value.Val >= this.Val);
        }
    }
}
