using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left
        {
            get { return Children.Any() ? Children[0] : null; }
            set
            {
                if (Children.Any()) Children[0] = value;
                else Children.Add(value);
            }
        }

        public ElementBase Right
        {
            get { return Children.Count() < 2 ? null : Children[1]; }
            set
            {
                switch (Children.Count())
                {
                    case 1:
                        Children.Add(value);
                        break;
                    case 0:
                        throw new Exception("initialize Left first");
                        
                    default:
                        Children[1] = value;
                        break;
                }
            }
        }


      

        protected BinaryTreeElementBase()
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