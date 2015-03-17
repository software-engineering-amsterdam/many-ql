using System;
using QL.Visitors;

namespace QL.Model.Terminals.Wrappers
{
    public class YesnoWrapper : ITerminalWrapper
    {

        public bool? Value;
        IResolvableTerminalType _node;




        public YesnoWrapper(Yesno a)
        {
            if (a != null)
            {

                Value = a.Value;
            }
            _node = (IResolvableTerminalType)a;


        }
        public YesnoWrapper(bool a)
        {

            Value = a;
        }

        public bool ToBool()//TODO change to (bool)
        {
            return Value.Value ? true : false;
        }

        public override string ToString()
        {
            return Value.HasValue ? (Value.Value ? "Yes" : "No") : "Unknown";
        }

        
        public static YesnoWrapper operator ==(YesnoWrapper a, YesnoWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            }
            else
            {

                return new YesnoWrapper(a.Value==b.Value);
            }
        }
        public static YesnoWrapper operator !=(YesnoWrapper a, YesnoWrapper b)
        {
            if (ContainsNullValue(a, b)){ 
                return new YesnoWrapper(null); 
            };
            
            return new YesnoWrapper(a.Value.Value != b.Value.Value);
        }


        public static YesnoWrapper operator &(YesnoWrapper a, YesnoWrapper b)
        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };

            return new YesnoWrapper(a.Value.Value & b.Value.Value);
          
        }
        public static YesnoWrapper operator | (YesnoWrapper a, YesnoWrapper b)        {
            if (ContainsNullValue(a, b))
            {
                return new YesnoWrapper(null);
            };
            
            return new YesnoWrapper(a.Value.Value | b.Value.Value);
        }
        public override int GetHashCode()
        {
            string w = "yesnowrapper";
            return 13 * (new { w, Value }.GetHashCode()); //have you heard about those magic numbers?
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
        protected static bool ContainsNullValue(YesnoWrapper a, YesnoWrapper b)
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
