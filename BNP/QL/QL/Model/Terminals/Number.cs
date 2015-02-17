using System;

namespace QL.Model.Terminals
{
    class Number : TerminalBase<int?>
    {
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
