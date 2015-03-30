using QL.AST.Nodes;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.Exceptions.Errors;

namespace QL.DataHandlers.Evaluation
{
    public sealed class EvaluationTerminalWrapperFactory
    {
        public ITerminalWrapper CreateWrapper(IStaticReturnType terminal)
        {
            if (terminal == null) return null;

            return (ITerminalWrapper)CreateWrapperFor((dynamic)terminal);
        }

        private NumberWrapper CreateWrapperFor(Number terminal)
        {
            return new NumberWrapper(terminal);
        }

        private YesnoWrapper CreateWrapperFor(Yesno terminal)
        {
            return new YesnoWrapper(terminal);
        }

        private TextWrapper CreateWrapperFor(Text terminal)
        {
            return new TextWrapper(terminal);
        }

        private ITerminalWrapper CreateWrapperFor(IStaticReturnType terminal)
        {
            throw new QLError("Unrecognised type: " + terminal.GetType());
        }
    }
}
