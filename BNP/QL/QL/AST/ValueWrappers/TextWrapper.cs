using System;
using QL.Visitors;

namespace QL.Model.Terminals.Wrappers
{
    public class TextWrapper : ITerminalWrapper//TODO change to  struct
    {
        public string Value;
        IResolvableTerminalType _node;

        public TextWrapper(string a)
        {
            Value = a;
        }

        public TextWrapper(Text a)
        {
            if (a != null)
            {

                Value = a.Value;
            }
            _node = (IResolvableTerminalType)a;
        }
        public TextWrapper(IResolvableTerminalType a)
        {
            throw new Exception("Resolution of this IResolvableTerminalType not implemented: " + a.ToString());
        }

        public override string ToString()
        {
            return Value;
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
