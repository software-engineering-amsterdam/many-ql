namespace QL.AST.Nodes
{
    public abstract class ElementBase
    {
        public SourceLocation SourceLocation { get; set; }

        protected ElementBase()
        {
        }

        protected ElementBase(SourceLocation sourceLocation)
        {
            SourceLocation = sourceLocation;
        }

        public virtual void Accept(IVisitor visitor)
        {
            visitor.Visit((dynamic)this);
        }

        protected string UnwrapQuotes(string input)
        {
            input = input.Trim();

            if (input.StartsWith("\"") && input.EndsWith("\""))
            {
                input = input.Trim('"');
            }

            return input;
        }
    }
}
