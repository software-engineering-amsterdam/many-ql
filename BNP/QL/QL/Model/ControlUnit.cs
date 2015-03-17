using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public class ControlUnit : ElementBase
    {
        public Expression Expression
        {
            get
            {
                if (Children.Count > 0)
                { return (Expression)Children[0]; }
                else { return null; }
            }
            set
            {
                if (!Children.Any())
                {
                    Children.Add((ElementBase) value);
                }
                else
                {
                    Children[0] = (ElementBase) value;
                }
                
            }
        }

        public Block ConditionTrueBlock{
            get{
                if (Children.Count() >2)
                {
                    return (Block)(Children[1]);
                }
                else
                {
                    return null;
                }
            }
            set{
                if (Children.Count() == 0)
                {
                    throw new Exception("cannot add ConditionTrueBlock before Expression");
                }
                else if (Children.Count() == 1){
                    Children.Add((ElementBase)value);
                } 
                else
                {
                    Children[1] = (ElementBase)value;
                }
                
            }
        }

        public Block ConditionFalseBlock
        {
            get
            {
                if (Children.Count() == 3)
                {
                    return (Block)Children[2];
                }
                else
                {
                    return null;
                }
            }
            set
            {
                if (Children.Count() == 0)
                {
                    throw new Exception("cannot add ConditionFalseBlock before Expression and ConditionTrueBlock");
                }
                else if (Children.Count() == 1)
                {
                    throw new Exception("cannot add ConditionFalseBlock before ConditionTrueBlock");
                }
                else if (Children.Count() == 2)
                {
                    Children.Add((ElementBase)value);
                }

                else
                {
                    Children[2] = (ElementBase)value;
                }

            }
        }
        /*This was a bad idea
         * public IList<ControlUnit> ElseIfBlocks{
            get{
                List<ControlUnit> retList= new List<ControlUnit>();
                for (int x=3; x<Children.Count();x++){
                    retList.Add((ControlUnit)Children[x]);
                }
                return retList;
            }
            set{
                for (int x=Children.Count()-1; x>=3;x--){
                    Children.RemoveAt(x);
                }
                for (int x=0;x<value.Count();x++){
                    Children.Add((ElementBase)value[x]);
                }
            }
        }
         */


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
