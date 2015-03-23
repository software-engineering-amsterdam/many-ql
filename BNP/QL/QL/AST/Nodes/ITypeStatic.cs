using System;

namespace QL.AST.Nodes
{
    public interface IStaticReturnType : ITypeResolvable
    {
        Type GetReturnType();
    }
}
