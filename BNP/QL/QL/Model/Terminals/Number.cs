using System;

namespace QL.Model.Terminals
{
    public class Number : BinaryTreeElementBase, ITerminal<int?>, ITerminalType
    {
        public int? Value { get; set; }

        public Number()
        {}

        public void SetValue(object value)
        {
            Value = Int32.Parse(value.ToString());
        }

        public override Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }
            
            return Value.ToString();
        }
        
    }
}
