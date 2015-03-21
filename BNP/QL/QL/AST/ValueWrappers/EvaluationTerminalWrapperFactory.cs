using System.Diagnostics.Contracts;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes;

namespace QL.AST.ValueWrappers
{
    class EvaluationTerminalWrapperFactory
    {

        static NumberWrapper CreateWrapper(Number a)
        {
            return new NumberWrapper(a);
        }
        static YesnoWrapper CreateWrapper(Yesno a)
        {
            return new YesnoWrapper(a);

        }
        static TextWrapper CreateWrapper(Text a)
        {
            return new TextWrapper(a);

        }
        public static ITerminalWrapper CreateWrapper(IStaticReturnType a)
        {
            Contract.Assert((a as Text) != null || (a as Yesno) != null || (a as Number)!=null);
            return (ITerminalWrapper)CreateWrapper((dynamic)a);

        }
    }
}
