using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions.Errors;
using QL.Model;
using QL.Model.Terminals;
using QL.Exceptions;

namespace QL.Visitors
{
    public class NumberWrapper:TerminalWrapper
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


        public static YesnoWrapper operator ==(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue )
            {
                return new YesnoWrapper(a.Value.Value == b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }
        public static YesnoWrapper operator !=(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value != b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }

        public static NumberWrapper operator +(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new NumberWrapper(a.Value.Value + b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static NumberWrapper operator -(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new NumberWrapper(a.Value.Value - b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static NumberWrapper operator *(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new NumberWrapper(a.Value.Value * b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static NumberWrapper operator /(NumberWrapper a, NumberWrapper b)
        {
            
            if (a.Value.HasValue || b.Value.HasValue)
            {
                if (b.Value.Value == 0)
                {
                    throw new EvaluationError("Zero division error");
                }
                return new NumberWrapper(a.Value.Value / b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static YesnoWrapper operator <(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value < b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static YesnoWrapper operator <=(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value <= b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static YesnoWrapper operator >(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value > b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public static YesnoWrapper operator >=(NumberWrapper a, NumberWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value >= b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }
        public override int GetHashCode()
        {
            string w = "numberwrapper";

            return new { w, Value }.GetHashCode();
        }
        
    }
}
