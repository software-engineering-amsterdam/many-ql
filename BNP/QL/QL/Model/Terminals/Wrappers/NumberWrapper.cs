using System;
using QL.Exceptions.Errors;

namespace QL.Model.Terminals.Wrappers
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

        public override string ToString()
        {
            return Value.HasValue ? Value.Value.ToString() : "Unknown";
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
