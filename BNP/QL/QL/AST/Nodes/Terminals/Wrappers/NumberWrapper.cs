using System;
using QL.Exceptions.Errors;

namespace QL.AST.Nodes.Terminals.Wrappers
{
    public class NumberWrapper : ITerminalWrapper
    {
        public int? Value { get; set; }

        public NumberWrapper(int value)
        {
            Value = value;
        }

        public NumberWrapper(Number value)
        {
            if (value != null)
            {
                Value = value.Value;
            }
        }

        public NumberWrapper(IStaticReturnType value)
        {
            throw new Exception("Resolution of this IResolvableTerminalType not implemented: " + value);
        }

        public static YesnoWrapper operator ==(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value == b.Value.Value);
        }

        public static YesnoWrapper operator !=(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value != b.Value.Value);
        }

        public static NumberWrapper operator +(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new NumberWrapper(null) : new NumberWrapper(a.Value.Value + b.Value.Value);
        }

        public static NumberWrapper operator -(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new NumberWrapper(null) : new NumberWrapper(a.Value.Value - b.Value.Value);
        }

        public static NumberWrapper operator *(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new NumberWrapper(null) : new NumberWrapper(a.Value.Value * b.Value.Value);
        }

        public static NumberWrapper operator /(NumberWrapper a, NumberWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new NumberWrapper(null);
            }
            if (b.Value.Value == 0)
            {
                throw new DivisionByZeroError();
            }
            return new NumberWrapper(a.Value.Value / b.Value.Value);
        }
        public static YesnoWrapper operator <(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value < b.Value.Value);
        }

        public static YesnoWrapper operator <=(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value <= b.Value.Value);
        }

        public static YesnoWrapper operator >(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value > b.Value.Value);
        }

        public static YesnoWrapper operator >=(NumberWrapper a, NumberWrapper b)
        {
            return ContainsNullValue(a, b) ? new YesnoWrapper(null) : new YesnoWrapper(a.Value.Value >= b.Value.Value);
        }

        public bool Equals(NumberWrapper obj)
        {
            return Value == obj.Value;
        }

        public override string ToString()
        {
            return Value.HasValue ? Value.Value.ToString() : "Unknown";
        }

        public override bool Equals(object obj)
        {
            if (obj is NumberWrapper) return Equals(obj as NumberWrapper);
            return false;
        }

        public override int GetHashCode()
        {
            string w = "numberwrapper";
            return 13 * (new { w, Value }.GetHashCode());
        }

        protected static bool ContainsNullValue(NumberWrapper a, NumberWrapper b)
        {
            return ReferenceEquals(a, null) || ReferenceEquals(b, null) || ReferenceEquals(null, a.Value) || ReferenceEquals(null, b.Value);
        }
    }
}
