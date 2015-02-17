﻿using System;

namespace QL.Model.Terminals
{
    class Number : ElementBase, ITerminal<int?>
    {
        public int? Value { get; private set; }

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
