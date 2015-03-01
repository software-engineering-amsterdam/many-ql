using System;

namespace QL.Model.Terminals
{
    public class Identifier : BinaryTreeElementBase, ITerminal<string>, ITerminalType
    {
        public string Value { get; private set; }

        public Identifier()
        { }

        public Identifier(string value)
        {
            Value = value;
        }

        public void SetValue(object value)
        {
            Value = value.ToString();
        }

        public ITerminalType ResolveValue()
        {
            throw new NotImplementedException();
        }

        public override string ToString()
        {
            if (Value == null)
            {
                throw new Exception();
            }
            
            return Value;
        }
    }
}
