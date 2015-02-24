using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public class RootNode : TreeElementBase
    {


        public RootNode(IList<TreeElementBase> children)
        {
            Children = children;
        }

        public RootNode(IReadOnlyList<ElementBase> children)
        {
            // TODO: Complete member initialization
            throw new Exception("Program should always consist from form block(s).");//TODO create own distinct exception
            }
    }
}
