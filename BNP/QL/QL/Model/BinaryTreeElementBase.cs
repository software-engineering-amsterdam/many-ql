using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left
        {
            get { if (Children.Count() == 0)
                    { return null; }
                else { return Children[0]; }
                }
            set {
                if (Children.Count() == 0) { Children.Add(value); }
                else Children[0] = value; 
            }
        }

        public ElementBase Right
        {
            get { if (Children.Count() <2)
                    { return null; }
                else { return Children[1]; }
                }
            set {
                if (Children.Count() == 1) { Children.Add(value); }
                else if (Children.Count() == 0) { throw new Exception("initialize Left first"); }
                else {Children[1] = value;} 
            }
        }
           

        public override ElementType ElementType
        {
            get { return Left == null || Right == null ? ElementType.Leaf : ElementType.Node; }
        }

        protected BinaryTreeElementBase() : base()
        {
            Children = new List<ElementBase>(2);

        }
        public void HandleChildren(ElementBase left, ElementBase right) 
        {
            Left = left;
            Right = right;
        }

    }
}