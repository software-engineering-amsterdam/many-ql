using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Nodes.Interfaces
{
    public interface IUnary : IExpression
    {
        Types.Type GetCompatibleType(Types.Type value);
        IExpression GetChildExpression();
        string MakeString();
    }
}
