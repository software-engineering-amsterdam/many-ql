using AST.Factory;
using AST.Nodes.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes
{
    internal class NodeFactory : AstFactory
    {

        public static NodeFactory GetNodeFactory()
        {
            return new NodeFactory();
        }
    }
}
