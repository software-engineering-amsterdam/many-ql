using System;

namespace QL.AST.Nodes.Terminals.Wrappers
{
    public class TextWrapper : ITerminalWrapper
    {
        public string Value { get; set; }

        public TextWrapper(string value)
        {
            Value = value;
        }

        public TextWrapper(Text value)
        {
            if (value != null)
            {
                Value = value.Value;
            }
        }

        public TextWrapper(IStaticReturnType value)
        {
            throw new Exception("Resolution of this IResolvableTerminalType not implemented: " + value);
        }

        public void SetValue(object value)
        {
            Value = value.ToString();
        }

        public static YesnoWrapper operator ==(TextWrapper a, TextWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value == b.Value);

        }
        public static YesnoWrapper operator !=(TextWrapper a, TextWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            return new YesnoWrapper(a.Value != b.Value);

        }
        public static TextWrapper operator +(TextWrapper a, TextWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new TextWrapper((string)null);
            };
            return new TextWrapper(a.Value + b.Value);

        }

        public override string ToString()
        {
            return Value;
        }

        public override int GetHashCode()
        {
            string w = "textwrapper";
            return 13 * (new { w, Value }.GetHashCode());
        }

        public bool Equals(TextWrapper obj)
        {
            return Value == obj.Value;
        }
        
        public override bool Equals(object obj)
        {
            if (obj is TextWrapper) return Equals(obj as TextWrapper);
            return false;
        }

        protected static bool ContainsNullValue(TextWrapper a, TextWrapper b)
        {
            return ReferenceEquals(a, null) || ReferenceEquals(b, null) || ReferenceEquals(null, a.Value) || ReferenceEquals(null, b.Value);
        }
    }
}
