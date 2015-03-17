using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Visitors;

namespace QL.Model
{
    public abstract class ElementBase : IVisitable, ITraversable
    {
        public SourceLocation SourceLocation { get; set; }
        public IList<ElementBase> Children { get; set; }

        /// <summary>
        /// Gets an ElementType indicating if this element is a leaf or a node.
        /// </summary>
        
        protected ElementBase()
        {
            Children = new List<ElementBase>();
        }

        internal void HandleChildren(IList<ElementBase> list)
        {
            Children = list;
        }


        public virtual void Accept(IVisitor visitor)
        {
            visitor.Visit((dynamic)this);
        }
       
       
    }
}
