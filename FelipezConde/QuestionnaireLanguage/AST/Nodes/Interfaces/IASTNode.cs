using AST.Representation;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Interfaces
{
    public interface IASTNode : IVisitable
    {       
        PositionInText GetPosition();

    }
}
