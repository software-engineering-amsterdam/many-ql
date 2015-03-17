using System;

namespace QL.Model.Terminals
{
    public class Text : BinaryTreeElementBase, ITerminal<string>, IResolvableTerminalType
    {
        public string Value { get; set; }

        public Text()
        { }

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
