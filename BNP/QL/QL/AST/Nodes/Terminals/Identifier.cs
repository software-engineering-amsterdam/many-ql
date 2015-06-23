using System;

namespace QL.AST.Nodes.Terminals
{
    public class Identifier : ElementBase
    {
        private string _value;

        public string Value
        {
            get { return _value; }
            private set { _value = UnwrapQuotes(value); }
        }

        public Identifier()
        { }

        public Identifier(string value)
        {
            Value = value;
        }

        public Identifier(string value, SourceLocation sourceLocation)
            : this(value)
        {
            SourceLocation = sourceLocation;
        }

        public bool Equals(Identifier obj)
        {
            return Value == obj.Value;
        }

        public override bool Equals(object obj)
        {
            if (obj is Identifier) return Equals(obj as Identifier);
            return false;
        }

        public static bool operator ==(Identifier a, Identifier b)
        {
            if (ReferenceEquals(a, null) ^ ReferenceEquals(b, null))
            {
                return false;
            }
            
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null))
            {
                return true;
            }
            
            return a.Value == b.Value;
        }

        public static bool operator !=(Identifier a, Identifier b)
        {
            if (ReferenceEquals(a, null) ^ ReferenceEquals(b, null))
            {
                return true;
            }
            
            if (ReferenceEquals(a, null) && ReferenceEquals(b, null))
            {
                return false;
            }
            
            return a.Value != b.Value;
        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override int GetHashCode()
        {
            string w = "identifier";
            int i = 13;
            return new { i, w, Value }.GetHashCode();
        }

        public override string ToString()
        {
            return string.IsNullOrWhiteSpace(Value) ? "undefined" : Value;
        }
    }
}
