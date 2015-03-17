using AST.Nodes.FormObjects;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ASTVisitors.Interfaces
{
    public interface IFormObjectVisitor<T>
    {
        T Visit(Conditional conditional);
        T Visit(Question question);

    }
}
