namespace QL.AST.Nodes
{
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left{get;set;}
        public ElementBase Right;
        protected BinaryTreeElementBase() { }
       
    }
}