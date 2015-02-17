using System;

namespace QL.Model.Terminals
{
    public class Identifier : TerminalBase<string>
    {
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
