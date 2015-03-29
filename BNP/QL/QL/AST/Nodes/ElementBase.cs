namespace QL.AST.Nodes
{
    /// <summary>
    /// Base class for all elements that the syntax defines and result in a part of the AST.
    /// </summary>
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
