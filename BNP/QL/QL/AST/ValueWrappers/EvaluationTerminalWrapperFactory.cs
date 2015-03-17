using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Diagnostics.Contracts;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals.Wrappers;
using QL.Model;

namespace QL.Visitors.EvaluationWrappers
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
        public static ITerminalWrapper CreateWrapper(IResolvableTerminalType a)
        {
            Contract.Assert((a as Text) != null || (a as Yesno) != null || (a as Number)!=null);
            return (ITerminalWrapper)CreateWrapper((dynamic)a);

        }
    }
}
