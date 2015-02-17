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

        public RootNode(List<Form> children)
        {
            // TODO: Complete member initialization
            throw new Exception("Program should always consist from  form block(s).");//TODO create own distinct exception
            }
    }
}
