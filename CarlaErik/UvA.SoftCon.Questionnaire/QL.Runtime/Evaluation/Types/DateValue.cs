using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types
{
    public class DateValue : Value<DateTime>
    {
        public override DataType DataType
        {
            get
            {
                return DataType.Date;
            }
        }

        public DateValue(DateTime value)
            : base(value.Date) { }


        public override Value IsEqualTo(Value value)
        {
            return value.IsEqualToDate(this);
        }

        internal override Value IsEqualToDate(DateValue value)
        {
            return new BooleanValue(value.Val == Val);
        }

        public override Value IsGreaterThan(Value value)
        {
            return value.IsGreaterThanDate(this);
        }

        internal override Value IsGreaterThanDate(DateValue value)
        {
            return new BooleanValue(value.Val > Val);
        }

        public override Value IsGreaterThanOrEqualTo(Value value)
        {
            return value.IsGreaterThanOrEqualToDate(this);
        }

        internal override Value IsGreaterThanOrEqualToDate(DateValue value)
        {
            return new BooleanValue(value.Val >= Val);
        }

        public override Value IsLessThan(Value value)
        {
            return value.IsLessThanDate(this);
        }

        internal override Value IsLessThanDate(DateValue value)
        {
            return new BooleanValue(value.Val < Val);
        }

        public override Value IsLessThanOrEqualTo(Value value)
        {
            return value.IsLessThanOrEqualToDate(this);
        }

        internal override Value IsLessThanOrEqualToDate(DateValue value)
        {
            return new BooleanValue(value.Val <= Val);
        }

        public override Value IsNotEqualTo(Value value)
        {
            return value.IsNotEqualToDate(this);
        }

        internal override Value IsNotEqualToDate(DateValue value)
        {
            return new BooleanValue(value.Val != Val);
        }
    }
}
