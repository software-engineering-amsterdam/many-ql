using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public struct SourceLocation
    {
        public uint Line { get; set; }
        public uint? Column { get; set; }

        public SourceLocation(uint line, uint? column = null) : this()
        {
            Line = line;
            Column = column;
        }
    }
}
