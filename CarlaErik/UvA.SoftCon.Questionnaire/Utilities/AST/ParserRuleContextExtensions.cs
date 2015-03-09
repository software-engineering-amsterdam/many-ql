using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;

namespace UvA.SoftCon.Questionnaire.Utilities.AST
{
    public static class ParserRuleContextExtensions
    {
        [CLSCompliant(false)]
        public static TextPosition GetTextPosition(this ParserRuleContext context)
        {
            return new TextPosition(context.Start.Line, context.Start.Column);
        }
    }
}
