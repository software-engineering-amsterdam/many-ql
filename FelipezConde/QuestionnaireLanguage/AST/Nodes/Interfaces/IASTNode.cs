using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Interfaces
{
    public interface IASTNode
    {
       // Parent Properties
      //  iASTNode setParent();
      //  iASTNode getParent();
      //  iASTNode removeParent();
        
        //Child Properties
      //  iASTNode getChild(int i);
        void AddChild(IASTNode node);
      //  iASTNode removeChild(int i);

    }
}
