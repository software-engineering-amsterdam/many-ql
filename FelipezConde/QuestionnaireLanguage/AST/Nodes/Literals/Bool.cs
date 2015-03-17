
namespace AST.Nodes.Literals
{
    public class Bool : Literal
    {
        private readonly bool value;

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

        public override Types.Type RetrieveType()
        {
            return new Types.BoolType();
        }

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
