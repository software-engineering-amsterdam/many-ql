using System;

namespace QL.Model.Terminals
{
    public class Text : BinaryTreeElementBase, IResolvableTerminalType
    {
        public string Value { get; set; }

        public Text()
        { }

        public Text(string value)
        {
            SetValue(value);
        }

        public void SetValue(object value)
        {
            Value = value.ToString();
        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }

        
       
    }
}
