using System;

namespace QL.Model.Terminals
{
    class Yesno : ElementBase, ITerminal<bool?>
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
