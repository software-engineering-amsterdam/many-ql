using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.Runtime.Evaluation.Types
{
    public class StringValue : Value<string>
    {
        public override DataType DataType
        {
            get
            {
                return DataType.String;
            }
        }

        public StringValue(string value)
            : base(value) { }

        public override Value IsEqualTo(Value value)
        {
            return value.IsEqualToString(this);
        }

        internal override Value IsEqualToString(StringValue value)
        {
            return new BooleanValue(value.Val == Val);
        }

        public override Value IsNotEqualTo(Value value)
        {
            return value.IsNotEqualToString(this);
        }

        internal override Value IsNotEqualToString(StringValue value)
        {
            return new BooleanValue(value.Val != Val);
        }

        public override Value Plus(Value value)
        {
            return value.PlusString(this);
        }

        internal override Value PlusString(StringValue value)
        {
            return new StringValue(value.Val + Val);
        }
    }
}
