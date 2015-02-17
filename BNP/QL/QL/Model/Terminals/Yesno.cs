using System;

namespace QL.Model.Terminals
{
    class Yesno : TerminalBase<bool?>
    {
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
