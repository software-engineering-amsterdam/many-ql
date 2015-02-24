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
            get { return Children[0]; }
            set { Children[0] = value; }
        }

        public ElementBase Right
        {
            get { return Children[1]; }
            set { Children[1] = value; }
        }

        public override ElementType ElementType
        {
            get { return Left == null || Right == null ? ElementType.Leaf : ElementType.Node; }
        }

        protected BinaryTreeElementBase() : base()
        {
            
        }
    }
}