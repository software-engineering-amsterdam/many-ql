using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;

namespace QL.Model
{
    public struct SourceLocation
    {
        public int Line { get; set; }
        public int? Column { get; set; }

        public SourceLocation(int line, int? column = null) : this()
        {
            Line = line;
            Column = column;
        }

        public static SourceLocation Create(ParserRuleContext context)
        {
            return new SourceLocation(context.Start.Line, context.Start.Column);
        }
    }
}
