using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Nodes.Interfaces
{
    public interface IUnary : IExpression
    {
        IValue GetCompatibleType(IValue value);
        IExpression GetChildExpression();
        string MakeString();
    }
}
