using AST.Representation;

namespace AST.Nodes.Literals
{
    public class Bool : Literal
    {
        private readonly bool value;

        //public Bool(bool parsedValue)
        //{
        //    this.value = parsedValue;
        //}

        public Bool(bool parsedValue, PositionInText positionInText)
            : base(positionInText)
        {
            this.value = parsedValue;
        }

        public bool GetValue()
        {
            return value;
        }

        public override string ToString()
        {
            return "bool";
        }

        public override object GetValueType()
        {
            return this;
        }

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override Types.Type RetrieveType()
        {
            return new Types.BoolType();
        }

        #region And
        public override Literal And(Literal value)
        {
            return value.BoolAnd(this);
        }

        public  override Literal BoolAnd(Bool boolValue)
        {
            return new Bool(GetValue() && boolValue.value, GetPosition());
        }
        #endregion

        #region Or
        public override Literal Or(Literal value)
        {
            return value.BoolOr(this);
        }

        public override Literal BoolOr(Bool boolValue)
        {
            return new Bool(value || boolValue.value, GetPosition());
        }
        #endregion

        #region Equal
        public override Literal Equal(Literal value)
        {
            return value.BoolEqual(this);
        }

        public override Literal BoolEqual(Bool boolValue)
        {
            return new Bool(value == boolValue.value, GetPosition());
        }
        #endregion

        #region NotEqual
        public override Literal NotEqual(Literal value)
        {
            return value.BoolEqual(this);
        }

        public override Literal BoolNotEqual(Bool boolValue)
        {
            return new Bool(value != boolValue.value, GetPosition());
        }
        #endregion

        #region Negate
        public override Bool Negate()
        {
            return new Bool(!GetValue(), GetPosition());
        }

        #endregion
    }
}
