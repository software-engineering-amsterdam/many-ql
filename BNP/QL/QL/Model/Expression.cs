using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class Expression : TreeElementBase
    {
        public Expression() { }

        public void HandleChildren(ElementBase e)
        {
            Children.Clear();
            Children.Add(e);
        }

        public void HandleChildren<T> (Expression e1, T op, Expression e2) where T : BinaryTreeElementBase
        {
            op.HandleChildren(e1, e2);
            Children.Add(op);
        }

        

        public override Type GetReturnType()
        {
            if (Children.Count == 1) {
                return Children[0].GetReturnType();
            }
            else
            {
                return null;
            }
        }
    }
}
