using AST.Nodes.Interfaces;
using AST.Representation;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.FormObject
{
    public abstract class FormObject : ASTNode, IVisitable
    {
        public FormObject(PositionInText pos)
            :base(pos)
        { }

        public abstract T Accept<T>(ASTVisitors.IVisitor<T> visitor);
    }
}
