using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public class RootNode : ElementBase
    {
        public RootNode(List<ElementBase> children){
            Children = children;
        }
    }
}
