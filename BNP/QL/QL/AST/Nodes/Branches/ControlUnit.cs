namespace QL.AST.Nodes.Branches
{
    /// <summary>
    /// Represents a control block such as an if-else statement with optional children in each branch
    /// </summary>
    public class ControlUnit : ElementBase
    {
        public Expression Expression { get; set; }
        public Block ConditionTrueBlock { get; set; }
        public Block ConditionFalseBlock { get; set; }

        public ControlUnit()
        { }

        public ControlUnit(Expression expression, Block trueBlock)
        {
            Expression = expression;
            ConditionTrueBlock = trueBlock;
        }
        public ControlUnit(Expression expression, Block trueBlock, Block falseBlock)
            : this(expression, trueBlock)
        {
            ConditionFalseBlock = falseBlock;
        }

        public ControlUnit(Expression expression, Block trueBlock, Block falseBlock, SourceLocation sourceLocation)
            : this(expression, trueBlock, falseBlock)
        {
            SourceLocation = sourceLocation;
        }

        public ControlUnit(Expression expression, Block trueBlock, SourceLocation sourceLocation)
            : this(expression, trueBlock)
        {
            SourceLocation = sourceLocation;
        }
    }

}
