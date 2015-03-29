using Antlr4.Runtime;
using System;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.Common.AST.Building
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
