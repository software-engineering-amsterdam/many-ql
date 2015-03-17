using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Visitors;

namespace QL.Model
{
    public abstract class ElementBase : IVisitable
    {
        public SourceLocation SourceLocation { get; set; }

        /// <summary>
        /// Gets an ElementType indicating if this element is a leaf or a node.
        /// </summary>
        
        protected ElementBase()
        {
        }


        public virtual void Accept(IVisitor visitor)
        {
            visitor.Visit((dynamic)this);
        }
       
       
    }
}
