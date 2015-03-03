using Antlr4.Runtime;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Visitors
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
