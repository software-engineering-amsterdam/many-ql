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
        public SourceLocation SourceLocation { get; set; }
        public IList<ElementBase> Children { get; set; }

        /// <summary>
        /// Gets an ElementType indicating if this element is a leaf or a node.
        /// </summary>
        public abstract ElementType ElementType { get; }

        protected ElementBase()
        {
            Children = new List<ElementBase>(2);
        }

        internal void HandleChildren(IList<ElementBase> list)
        {
            Children = list;
            
            //here the children should be checked
            //Console.WriteLine("");
            // throw new NotImplementedException();
        }
        public bool CheckType() { return false; }  //TODO when we start to implement typechecking then change to abstract
        public bool Evaluate() { return false; }       //TODO when we start to implement evaluation then change to abstract
    }
}
