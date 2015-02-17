using System;

namespace QL.Model.Terminals
{
    public class Yesno : BinaryTreeElementBase, ITerminal<bool?>, ITerminalType
    {
        public bool? Value { get; private set; }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }

            return Value.Value ? "Yes" : "No";
        }
    }
}
