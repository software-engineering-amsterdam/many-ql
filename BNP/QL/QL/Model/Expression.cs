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

        /* useleess
        public void HandleChildren(Expression e)
        {
            //in this case, the expresion does not make sense, it's like ((e))
            Children = e.Children;
        }
        public void HandleChildren(Identifier value)
        {
            Children.Clear();
            Children.Add(value);
        }

        public void HandleChildren(Yesno value)
        {
            Children.Clear();
            Children.Add(value);
        }
        public void HandleChildren(Text value)
        {
            Children.Clear();
            Children.Add(value);
        }
        public void HandleChildren(Number value)
        {
            Children.Clear();
            Children.Add(value);
        }
         */

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
    }
}
