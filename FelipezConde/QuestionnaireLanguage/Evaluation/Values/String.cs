
namespace Evaluation.Values
{
    public class String : Value
    {
        private string value;
        public String(string value)
        {
            this.value = value;
        }
        public override string ToString()
        {
            return "string";
        }

        public string GetValue()
        {
            return value;
        }

        #region Equal
        public override Value Equal(Value value)
        {
            return value.StringEqual(this);
        }
        public override Value StringEqual(Values.String stringValue)
        {
            return new Bool(GetValue().Equals(stringValue.GetValue()));
        }
        #endregion

        #region NotEqual
        public override Value NotEqual(Value value)
        {
            return value.StringNotEqual(this);
        }
        public override Value StringNotEqual(Values.String stringValue)
        {
            return new Bool(!GetValue().Equals(stringValue.GetValue()));
        }
        #endregion

        public override T Accept<T>(IValueVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
