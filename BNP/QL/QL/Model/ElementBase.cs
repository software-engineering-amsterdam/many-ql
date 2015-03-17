using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Visitors;

namespace QL.Model
{
    public abstract class ElementBase : IVisitable, ITraversable, IBottomUpVisitable
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


        public virtual void AcceptSingle(IVisitor visitor)
        {
            visitor.Visit((dynamic)this);

        }
        public virtual void Accept(IVisitor visitor)
        {
            visitor.Visit((dynamic)this); //better to use dynamic than clone it everywhere underneath

            foreach (ElementBase child in Children)
            {
                child.Accept(visitor);
            }
        }
        public virtual void AcceptBottomUp(IVisitor visitor)
        {

            foreach (ElementBase child in Children)
            {
                child.AcceptBottomUp(visitor);
            }
            visitor.Visit((dynamic)this); //dynamic!! BECAUSE It's cloning to implement this for everything as the same

        }
    }
}
