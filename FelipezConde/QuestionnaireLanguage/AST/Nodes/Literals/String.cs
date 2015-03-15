using AST.Representation;

namespace AST.Nodes.Literals
{
    public class String : Literal
    {
        private readonly string value;
        public String(string value)
        {
            this.value = value;
        }
        public String(string value, PositionInText positionInText)
            : base(positionInText)
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
            return new Types.StringType();
        }

        #region Equal
        public override Literal Equal(Literal value)
        {
            return value.StringEqual(this);
        }
        public override Literal StringEqual(Literals.String stringValue)
        {
            return new Bool(GetValue().Equals(stringValue.GetValue()));
        }
        #endregion

        #region NotEqual
        public override Literal NotEqual(Literal value)
        {
            return value.StringNotEqual(this);
        }
        public override Literal StringNotEqual(Literals.String stringValue)
        {
            return new Bool(!GetValue().Equals(stringValue.GetValue()));
        }
        #endregion
    }
}
