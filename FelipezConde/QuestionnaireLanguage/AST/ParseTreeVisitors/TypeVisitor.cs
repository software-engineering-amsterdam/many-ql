using AST.Nodes.Interfaces;
using AST.Helpers;
using AST.Nodes.Values;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using AST.Nodes.TypeName;
using AST.Resources;
using Values = AST.Nodes.Values;


namespace AST.ParseTreeVisitors
{
    public class TypeVisitor : QLMainBaseVisitor<Value>
    {
        public override Value VisitBoolType(QLMainParser.BoolTypeContext context)
        {
            return new Values.Bool(false, Position.PositionFormParserRuleContext(context));
        }

        public override Value VisitStringType(QLMainParser.StringTypeContext context)
        {
            return new Values.String(string.Empty, Position.PositionFormParserRuleContext(context));
        }

        public override Value VisitIntType(QLMainParser.IntTypeContext context)
        {
            return new Values.Int(int.MinValue, Position.PositionFormParserRuleContext(context));
        }
    }
}
