using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Model.Terminals;

namespace QL.Visitors
{
    public class YesnoWrapper:TerminalWrapper
    {
        
        public bool? Value;
        IResolvableTerminalType _node;

        
        
     
        public YesnoWrapper(Yesno a)
        {
            Value = a.Value;
            _node = (IResolvableTerminalType) a;


        }
        public YesnoWrapper(bool a)
        {
            Value = a;
        }

        public bool ToBool()
        {
            return Value.Value ? true : false;
        }
    

        public static YesnoWrapper operator ==(YesnoWrapper a, YesnoWrapper b)
        {
            if (ReferenceEquals(a, null) ^ ReferenceEquals(b, null))
            {
                return new YesnoWrapper(false);
            }
            else if (ReferenceEquals(a, null) && ReferenceEquals(b, null))
            {
                return new YesnoWrapper(true);
            }
            else
            {
                return new YesnoWrapper(a.Value == b.Value);
            }
        }
        public static YesnoWrapper operator !=(YesnoWrapper a, YesnoWrapper b)
        {
            if (ReferenceEquals(a, null) ^ ReferenceEquals(b, null))
            {
                return new YesnoWrapper(true);
            }
            else if (ReferenceEquals(a, null) && ReferenceEquals(b, null))
            {
                return new YesnoWrapper(false);
            }
            else
            {
                return new YesnoWrapper(a.Value != b.Value);
            }
        }

        
        public static YesnoWrapper operator &(YesnoWrapper a, YesnoWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value & b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }
        public static YesnoWrapper operator |(YesnoWrapper a, YesnoWrapper b)
        {
            if (a.Value.HasValue || b.Value.HasValue)
            {
                return new YesnoWrapper(a.Value.Value | b.Value.Value);
            }
            else
            {
                throw new NotImplementedException("implement cannot compare null with smth exception");
            }
        }
        public override int GetHashCode()
        {
            string w="yesnowrapper";
            return new { w, Value }.GetHashCode();
        }

        public bool Equals(YesnoWrapper obj)
        {
            return Value == obj.Value;
        }
        public override bool Equals(object obj)
        {
            if (obj is YesnoWrapper) return Equals(obj as YesnoWrapper);
            return false;
        }
    }
}
