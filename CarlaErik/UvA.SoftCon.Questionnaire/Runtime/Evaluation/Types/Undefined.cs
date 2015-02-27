using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
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
            get { return true; }
        }

        public override Value Plus(Value value)
        {
            return this;
        }

        internal override Value PlusInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value Minus(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value MinusInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value MultipliedBy(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value MultipliedByInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value DividedBy(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value DividedByInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value Increment()
        {
            throw new NotImplementedException();
        }

        public override Value IsEqualTo(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsEqualToInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsEqualToString(StringValue value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsEqualToBool(BooleanValue value)
        {
            throw new NotImplementedException();
        }

        public override Value IsNotEqualTo(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsNotEqualToInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsNotEqualToString(StringValue value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsNotEqualToBool(BooleanValue value)
        {
            throw new NotImplementedException();
        }

        public override Value IsLessThan(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsLessThanInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value IsLessThanOrEqualTo(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsLessThanOrEqualToInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value IsGreaterThan(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsGreaterThanInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value IsGreaterThanOrEqualTo(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value IsGreaterThanOrEqualToInt(IntegerValue value)
        {
            throw new NotImplementedException();
        }

        public override Value And(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value AndBool(BooleanValue value)
        {
            throw new NotImplementedException();
        }

        public override Value Or(Value value)
        {
            throw new NotImplementedException();
        }

        internal override Value OrBool(BooleanValue value)
        {
            throw new NotImplementedException();
        }

        public override Value Negate()
        {
            throw new NotImplementedException();
        }
    }
}
