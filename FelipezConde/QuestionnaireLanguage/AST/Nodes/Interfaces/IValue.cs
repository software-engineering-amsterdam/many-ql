using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Interfaces
{
    public interface Type : IExpression
    {
        string MakeString();

        bool IsOfType(Type type);
    }
}
