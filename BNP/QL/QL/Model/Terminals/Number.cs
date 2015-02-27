using System;

namespace QL.Model.Terminals
{
    public class Number : BinaryTreeElementBase, ITerminal<int?>, ITerminalType
    {
        public int? Value { get; set; }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }
            
            return Value.ToString();
        }
        public Number(){}
    }
}
