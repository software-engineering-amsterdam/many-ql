using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Interfaces
{
    public interface IValue : IExpression
    {
        string MakeString();

        bool IsOfType(IValue type);
    }
}
