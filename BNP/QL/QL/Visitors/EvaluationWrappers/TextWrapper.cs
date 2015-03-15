using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Model.Terminals;

namespace QL.Visitors
{
    public class TextWrapper : TerminalWrapper
    {
        public string Value;
        IResolvableTerminalType _node;

        public TextWrapper(string a)
        {
            Value = a;
        }

        public TextWrapper(Text a)
        {
            Value = a.Value;
            _node = (IResolvableTerminalType)a;
        }
        public TextWrapper(IResolvableTerminalType a)
        {
            throw new Exception("Resolution of this IResolvableTerminalType not implemented: " + a.ToString());
        }


        public static YesnoWrapper operator ==(TextWrapper a, TextWrapper b)
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
        public static YesnoWrapper operator !=(TextWrapper a, TextWrapper b)
        {
            if (a.Value!=null || b.Value!=null)
            {
                return new YesnoWrapper(a.Value != b.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }
        public static TextWrapper operator +(TextWrapper a, TextWrapper b)
        {
            if (a.Value != null || b.Value != null)
            {
                return new TextWrapper(a.Value + b.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }

        }

        public override int GetHashCode()
        {
            string w = "textwrapper";

            return new { w, Value }.GetHashCode();
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

    }
}
