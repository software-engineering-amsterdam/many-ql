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
        public ElementBase Left { get; protected set; }
        public ElementBase Right { get; protected set; }

        public override ElementType ElementType
        {
            get { return Left == null || Right == null ? ElementType.Leaf : ElementType.Node; }
        }
    }
}