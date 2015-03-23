namespace QL.AST.Nodes
{
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left;
        public ElementBase Right;
        protected BinaryTreeElementBase() { }
       
    }
}