using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public class ControlBlock : TreeElementBase
    {
        public Block TrueBlock;
        public IList<ControlBlock> Elseifs;
        public Block FalseBlock;
        public ControlBlockType Type { get; set; }

        public Expression Expression;

        public ControlBlock()
        {
            
        }

        public void HandleChildren(Expression expression , Block trueBlock, IList<ControlBlock> elseifs=null, Block falseBlock=null)
        {
            IList<ElementBase> childrenTemporary = new List<ElementBase>();
            childrenTemporary.Add(expression);
            Expression = expression;
            childrenTemporary.Add(trueBlock);

            TrueBlock = trueBlock;
            if (elseifs!=null && elseifs.Count()>0)
            {
                ((List<ElementBase>)childrenTemporary).AddRange(elseifs);

                Elseifs = elseifs;
            }
            if (falseBlock!=null)
            {
                childrenTemporary.Add(falseBlock);

                FalseBlock = falseBlock;

            }

            ((List<ElementBase>) Children).AddRange(childrenTemporary);

        }
    }

}
