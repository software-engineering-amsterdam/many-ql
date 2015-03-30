using System;

namespace QL.AST.Nodes
{
    public interface IStaticReturnType : IResolvable
    {
        Type GetReturnType();
    }
}
