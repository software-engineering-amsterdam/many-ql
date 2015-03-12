using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Grammar;
using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using AST.Representation;
using AST.Helpers;
using Values = AST.Nodes.Values;
namespace AST.ParseTreeVisitors
{
    public class LiteralVisitor : QLMainBaseVisitor<ILiteral>
    {
        public override ILiteral VisitTrueBool(QLMainParser.TrueBoolContext context)
        {
            string show = context.TRUE().GetText();
            return new Values.Bool(true);
        }

        public override ILiteral VisitFalseBool(QLMainParser.FalseBoolContext context)
        {
            return new Values.Bool(false);
        }

        public override ILiteral VisitStringValue(QLMainParser.StringValueContext context)
        {
            string stringValue = context.@string().STRINGLITERAL().GetText();

            return new Values.String(stringValue.Substring(1, stringValue.Length-2)
                                     ); 
        }

        public override ILiteral VisitIntValue(QLMainParser.IntValueContext context)
        {
            string intValue = context.@int().INTLITERAL().GetText();

            return new Values.Int(int.Parse(intValue));
        }
    }
}
