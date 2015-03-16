using AST.Representation;

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

        public override T Accept<T>(ASTVisitors.IVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override Types.Type RetrieveType()
        {
            return new Types.StringType();
        }
    }
}
