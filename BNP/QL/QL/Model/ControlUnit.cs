using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class ControlUnit : ElementBase
    {
        public Expression Expression;
        public Block ConditionTrueBlock;
        public Block ConditionFalseBlock;


        public ControlUnit()
        {
            Children= new List<ElementBase>(3);            
        }

        public void HandleChildren(Expression e, Block trueBlock)
        {
            Expression = e;
            ConditionTrueBlock = trueBlock;
        }
        public void HandleChildren(Expression e, Block trueBlock, Block falseBlock)
        {
            HandleChildren(e, trueBlock);
            ConditionFalseBlock = falseBlock;
        }

      
    }

}
