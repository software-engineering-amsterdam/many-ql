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
        public IReadOnlyList<ElementBase> Children { get; protected set; }

        public override ElementType ElementType
        {
            get { return Children == null || Children.Count == 0 ? ElementType.Leaf : ElementType.Node; }
        }

        public TreeElementBase()
        {
            Children = new List<ElementBase>();
        }
        
        internal void handleChildren(List<TreeElementBase> list)
        {
            Children = list;
            
            //here the children should be checked
            //Console.WriteLine("");
           // throw new NotImplementedException();
        }
        
    }
}
