using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public abstract class TreeElementBase : ElementBase
    {
        public override ElementType ElementType
        {
            get { return Children == null || Children.Count == 0 ? ElementType.Leaf : ElementType.Node; }
        }

        protected TreeElementBase() : base()
        {
        }
    }
}
