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

        public ElementBase GetTypeInferableChild()
        {
            return Child;
        }
        
    }
}
