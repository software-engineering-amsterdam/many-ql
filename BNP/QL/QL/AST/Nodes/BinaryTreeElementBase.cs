namespace QL.AST.Nodes
{
    /// <summary>
    /// Provides a base implementation for the left and right nodes that a binary tree element consists of.
    /// Examples are operators that have two nodes or expressions that have nested expression(s) on the left or right leg.
    /// </summary>
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left { get; set; }
        public ElementBase Right { get; set; }
    }
}