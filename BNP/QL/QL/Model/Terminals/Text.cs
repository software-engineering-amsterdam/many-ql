using System;

namespace QL.Model.Terminals
{
    class Text : TerminalBase<string>
    {
        public override string ToString()
        {
            if (Value== null) {
                throw new Exception();
            }
            
            return Value;
        }
    }
}
