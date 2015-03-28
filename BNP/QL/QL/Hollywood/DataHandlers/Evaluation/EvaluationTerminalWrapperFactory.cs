using QL.AST.Nodes.Terminals;
using QL.AST.Nodes;
using QL.Exceptions.Errors;

namespace QL.AST.ValueWrappers
{
    public sealed class EvaluationTerminalWrapperFactory
    {
        public ITerminalWrapper CreateWrapper(IStaticReturnType a)
        {
            return (ITerminalWrapper)CreateWrapperFor((dynamic)a);
        }

        private NumberWrapper CreateWrapperFor(Number a)
        {
            return new NumberWrapper(a);
        }

        private YesnoWrapper CreateWrapperFor(Yesno a)
        {
            return new YesnoWrapper(a);
        }

        private TextWrapper CreateWrapperFor(Text a)
        {
            return new TextWrapper(a);
        }

        private ITerminalWrapper CreateWrapperFor(IStaticReturnType a)
        {
            throw new QLError("Unrecognised type: " + a.GetType());
        }
    }
}
