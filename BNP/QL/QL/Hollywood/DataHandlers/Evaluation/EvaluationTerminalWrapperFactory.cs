using System.Diagnostics.Contracts;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes;
using QL.Exceptions.Errors;

namespace QL.AST.ValueWrappers
{
    class EvaluationTerminalWrapperFactory
    {
        public EvaluationTerminalWrapperFactory() { }
        NumberWrapper _CreateWrapper(Number a)
        {
            return new NumberWrapper(a);
        }
        YesnoWrapper _CreateWrapper(Yesno a)
        {
            return new YesnoWrapper(a);

        }
        TextWrapper _CreateWrapper(Text a)
        {
            return new TextWrapper(a);

        }
        ITerminalWrapper _CreateWrapper(IStaticReturnType a)
        {
            throw new QLError("Cannot recognize type:" + a.GetType());
        }

        public ITerminalWrapper CreateWrapper(IStaticReturnType a)
        {
            return (ITerminalWrapper)_CreateWrapper((dynamic)a);

        }
    }
}
