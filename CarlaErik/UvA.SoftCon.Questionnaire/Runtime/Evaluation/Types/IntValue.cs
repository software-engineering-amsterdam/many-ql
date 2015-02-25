using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.Runtime.Evaluation.Types
{
    public class IntValue : Value<int>, IInteger
    {
        public IntValue(int value)
            : base(value) { }

        public override IInteger Plus(IValue value)
        {
            return value.PlusInt(this);
        }

        public override IInteger PlusInt(IInteger value)
        {
            return new IntValue(value.Val + Val);
        }

        public override IInteger Minus(IValue value)
        {
            return base.Minus(value);
        }

        public override IInteger MinusInt(IInteger value)
        {
            return base.MinusInt(value);
        }
    }
}
