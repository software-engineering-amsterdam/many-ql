using System;
using QL.Exceptions.Errors;
using QL.Visitors;

namespace QL.Model.Terminals.Wrappers
{
    public class NumberWrapper : ITerminalWrapper//TODO change to  struct
    {
        public int? Value;
        IResolvableTerminalType _node;

         public NumberWrapper(int a)
        {
            Value = a;
        }

        public NumberWrapper(Number a)
        {
            if (a != null) 
            { 
                Value = a.Value;
            }
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
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };

            return new YesnoWrapper(a.Value.Value == b.Value.Value);
            
        }
        public static YesnoWrapper operator !=(NumberWrapper a, NumberWrapper b)
        {

            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value.Value != b.Value.Value);
          
        }

        public static NumberWrapper operator +(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new NumberWrapper(null);
            };
            return new NumberWrapper(a.Value.Value + b.Value.Value);
        }
        public static NumberWrapper operator -(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new NumberWrapper(null);
            };
            return new NumberWrapper(a.Value.Value - b.Value.Value);
           

        }
        public static NumberWrapper operator *(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new NumberWrapper(null);
            };
            return new NumberWrapper(a.Value.Value * b.Value.Value);
            

        }
        public static NumberWrapper operator /(NumberWrapper a, NumberWrapper b)
        {
            
            if (ContainsNullValue(a, b))
            {
                return new NumberWrapper(null);
            };
            if (b.Value.Value == 0)
            {
                throw new DivisionByZeroError();
            }
            return new NumberWrapper(a.Value.Value / b.Value.Value);
           

        }
        public static YesnoWrapper operator <(NumberWrapper a, NumberWrapper b)
        {
           if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value.Value < b.Value.Value);
           

        }
        public static YesnoWrapper operator <=(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value.Value <= b.Value.Value);
            

        }
        public static YesnoWrapper operator >(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value.Value > b.Value.Value);
            

        }
        public static YesnoWrapper operator >=(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value.Value >= b.Value.Value);            

        }
        public bool Equals(NumberWrapper obj)
        {
            return Value == obj.Value;
        }
        public override bool Equals(object obj)
        {
            if (obj is NumberWrapper) return Equals(obj as NumberWrapper);
            return false;
        }
        public override int GetHashCode()
        {
            string w = "numberwrapper";

            return 13*(new { w, Value }.GetHashCode());
        }
        protected static bool ContainsNullValue(NumberWrapper a, NumberWrapper b)
        {
            if (ReferenceEquals(a, null) || ReferenceEquals(b, null) || ReferenceEquals(null, a.Value) || ReferenceEquals(null, b.Value))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
