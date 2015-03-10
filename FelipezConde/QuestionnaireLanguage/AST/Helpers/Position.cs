using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Representation;

namespace AST.Helpers
{
    public static class Position
    {
        public static PositionInText PositionFormParserRuleContext(ParserRuleContext context)
        {
            return new PositionInText(
                    context.Start.Line,
                    context.Stop.Line,
                    context.Start.Column,
                    context.Stop.Column
                );
        }

        public static string PrettyPrint(PositionInText position)
        {
                return "lines [" +
                        position.StartLine +
                        " (character position: " +
                        position.StartColumn + ")," +
                        position.EndLine +
                        " (character position: " +
                        position.EndColumn + ")]"; 
        }

        public static string PrettyPrint(IEnumerable<PositionInText> positions)
        {
            return positions.Aggregate(
                                "positions: ",
                                (res, next) => res  + 
                                               ", " + 
                                               PrettyPrint(next)
                             );
        }

    }
}
