using System;

namespace QL.Model.Terminals
{
    class Text : BinaryTreeElementBase, ITerminal<string>
    {
        public string Value { get; private set; }

        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }
    }
}
