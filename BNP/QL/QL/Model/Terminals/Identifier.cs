using System;

namespace QL.Model.Terminals
{
    public class Identifier : BinaryTreeElementBase, ITerminal<string>
    {
        public string Value { get; private set; }
        public string PointerName;

        public override string ToString()
        {
            if (Value == null)
            {
                throw new Exception();
            }
            
            return Value;
        }

        public Identifier(string value)
        {
            Value = value;
        }

        public Identifier()
        {
            // TODO: Complete member initialization
        }
    }
}
