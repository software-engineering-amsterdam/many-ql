namespace QL.AST.Nodes.Branches
{
    public class ControlUnit : ElementBase
    {
        public Expression Expression;
        public Block ConditionTrueBlock;
        public Block ConditionFalseBlock;


        public ControlUnit()
        {
        }

        public ControlUnit(Expression e, Block trueBlock)
        {
            Expression = e;
            ConditionTrueBlock = trueBlock;
        }
        public ControlUnit(Expression e, Block trueBlock, Block falseBlock):this(e,trueBlock)
        {
            ConditionFalseBlock = falseBlock;
        }

      
    }

}
