using System;

namespace QL.Model.Terminals
{
    public class Text : BinaryTreeElementBase, ITerminal<string>, ITerminalType
    {
        public string Value { get; private set; }

        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }
        public Text(string value)
        {
            Value = value;
        }
    }
}
