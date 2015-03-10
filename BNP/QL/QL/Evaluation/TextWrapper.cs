using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Model.Terminals;

namespace QL.Evaluation
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


    }
}
