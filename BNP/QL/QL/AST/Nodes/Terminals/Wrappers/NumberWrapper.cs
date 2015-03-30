using System;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using QL.Annotations;
using QL.Exceptions.Errors;

namespace QL.AST.Nodes.Terminals.Wrappers
{
    public class NumberWrapper : ITerminalWrapper
    {
        private int? _value;
        public event PropertyChangedEventHandler PropertyChanged;

        public int? Value
        {
            get { return _value; }
            set
            {
                if (value == _value) return;
                _value = value;
                OnPropertyChanged();
            }
        }

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

        public void SetValue(object value)
        {
            int result;
            if (int.TryParse(value.ToString(), out result))
            {
                Value = result;
            }
            else
            {
                Value = null;
            }
        }

        [NotifyPropertyChangedInvocator]
        protected virtual void OnPropertyChanged([CallerMemberName] string propertyName = null)
        {
            if (PropertyChanged == null) return;
            PropertyChanged(this, new PropertyChangedEventArgs(propertyName));
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
