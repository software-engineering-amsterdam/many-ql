using System;

namespace QL.AST.Nodes
{
    public interface ITypeStatic : ITypeResolvable
    {
        Type GetReturnType();
    }
}
