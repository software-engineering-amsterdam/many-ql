using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public abstract class ElementBase
    {
        public SourceLocation SourceLocation { get; protected set; }
        public IList<ElementBase> Children { get; private set; }

        public ElementType ElementType
        {
            get { return Children == null || Children.Count == 0 ? ElementType.Leaf : ElementType.Node; }
        }

        protected ElementBase()
        {
            Children = new List<ElementBase>();
        }
    }
}
