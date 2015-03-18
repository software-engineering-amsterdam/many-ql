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
