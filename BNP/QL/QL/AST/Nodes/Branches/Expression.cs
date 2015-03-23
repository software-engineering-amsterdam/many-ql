namespace QL.AST.Nodes.Branches
{
    public class Expression : ElementBase, ITypeInferred
    {
        public ElementBase Child{get; private set;}
        
        
        public Expression() { }
        public Expression(ElementBase child) 
        {
            Child = child;
        }

        public Expression(ElementBase child, AST.SourceLocation sourceLocation):this(child)
        {
            SourceLocation = sourceLocation;
        }

        public ElementBase GetTypeInferableChild()
        {
            return Child;
        }
        
    }
}
