using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;

namespace QL.Model
{
    [DebuggerDisplay("{Line}:{Column} {Source}")]
    public struct SourceLocation
    {
        public int Line { get; private set; }
        public int? Column { get; private set; }
        public string Source { get; private set; }

        public SourceLocation(int line, int? column = null, string source = null) : this()
        {
            Line = line;
            Column = column;
            Source = source;
        }

        public override string ToString()
        {
            return Column.HasValue ? string.Format("Line {0} column {1}", Line, Column.Value) : string.Format("Line {0}", Line);
        }

        public static SourceLocation CreateFor(ParserRuleContext context)
        {
            return new SourceLocation(context.Start.Line, context.Start.Column + 1, context.Start.Text);
        }
    }
}
