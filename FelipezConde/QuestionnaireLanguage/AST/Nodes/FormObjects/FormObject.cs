using AST.ASTVisitors.Interfaces;
using AST.Nodes.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.FormObjects
{
    public abstract class FormObject : ASTNode
    {
        public FormObject(PositionInText pos)
            :base(pos)
        { }

        public abstract T Accept<T>(IFormObjectVisitor<T> visitor);

    }
}
