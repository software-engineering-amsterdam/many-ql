
namespace Evaluation.Values
{
    public class Bool : Value
    {
        private bool value;
        public Bool(bool value)
        {
            this.value = value;
        }
        public bool GetValue()
        {
            return value;
        }

        public override string ToString()
        {
            return "bool";
        }

        #region And
        public override Value And(Value value)
        {
            return value.BoolAnd(this);
        }

        public override Value BoolAnd(Bool boolValue)
        {
            return new Bool(GetValue() && boolValue.value);
        }
        #endregion

        #region Or
        public override Value Or(Value value)
        {
            return value.BoolOr(this);
        }

        public override Value BoolOr(Bool boolValue)
        {
            return new Bool(value || boolValue.value);
        }
        #endregion

        #region Equal
        public override Value Equal(Value value)
        {
            return value.BoolEqual(this);
        }

        public override Value BoolEqual(Bool boolValue)
        {
            return new Bool(value == boolValue.value);
        }
        #endregion

        #region NotEqual
        public override Value NotEqual(Value value)
        {
            return value.BoolEqual(this);
        }

        public override Value BoolNotEqual(Bool boolValue)
        {
            return new Bool(value != boolValue.value);
        }
        #endregion

        #region Negate
        public override Bool Negate()
        {
            return new Bool(!GetValue());
        }

        #endregion

        public override T Accept<T>(IValueVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
