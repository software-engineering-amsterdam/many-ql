using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes
{
    public abstract class FormElementContainer : ASTNode
    {
        public FormElementContainer(PositionInText position) : base(position) { }
        public abstract IList<IFormObject> GetBody();
    }
}
