using System;

namespace QL.Model.Terminals
{
    public class Text : BinaryTreeElementBase, ITerminal<string>, ITerminalType
    {
        public string Value { get; set; }

        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }
    }
}
