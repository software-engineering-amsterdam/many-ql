using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Nodes.Interfaces
{
    public interface IBinary : IExpression
    {
        IExpression Left();
        IExpression Right();
        string MakeString();
        Types.Type GetCompatibleType(Types.Type leftType, Types.Type rightType);
    }
}
