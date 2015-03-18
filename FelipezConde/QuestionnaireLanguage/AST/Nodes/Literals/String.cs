
namespace AST.Nodes.Literals
{
    public class String : Literal
    {
        private string value;
        public String(string value, PositionInText positionInText)
            : base(positionInText)
        {
            this.value = value;
        }
        public string GetValue()
        {
            return value;
        }
        
        public override string ToString()
        {
            return "string";
        }

        public override Types.Type RetrieveType()
        {
            return new Types.StringType();
        }

        public override T Accept<T>(VisitorInterfaces.IExpressionVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }
    }
}
