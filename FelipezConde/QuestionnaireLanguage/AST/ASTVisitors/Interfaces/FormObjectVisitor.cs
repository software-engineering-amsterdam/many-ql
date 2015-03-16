using AST.Nodes.FormObject;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ASTVisitors.Interfaces
{
    public interface FormObjectVisitor<T>
    {
        T Visit(Conditional conditional);
        T Visit(Question conditional);

    }
}
