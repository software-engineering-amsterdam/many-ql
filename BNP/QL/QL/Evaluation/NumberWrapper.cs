using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Model.Terminals;

namespace QL.Evaluation
{
    class NumberWrapper:TerminalWrapper
    {
        public int? Value;
        IResolvableTerminalType _node;

         public NumberWrapper(int a)
        {
            Value = a;
        }

        public NumberWrapper(Number a)
        {
            Value = a.Value;
            _node = (IResolvableTerminalType) a;
        }
        public NumberWrapper(IResolvableTerminalType a)
        {
            throw new Exception("Resolution of this IResolvableTerminalType not implemented: " + a.ToString());
        }


        public static TerminalWrapper operator ==(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value != null || b.Value != null)
            {
                return new YesnoWrapper(a.Value == b.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }
        public static TerminalWrapper operator !=(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value == b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }

        
    }
}
