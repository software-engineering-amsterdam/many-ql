using AST.Nodes.Interfaces;
using AST.Helpers;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Types = AST.Types;


namespace AST.ParseTreeVisitors
{
    public class TypeVisitor : QLMainBaseVisitor<Types.Type>
    {
        public override Types.Type VisitBoolType(QLMainParser.BoolTypeContext context)
        {
            return new Types.BoolType();
        }

        public override Types.Type VisitStringType(QLMainParser.StringTypeContext context)
        {
            return new Types.StringType();
        }

        public override Types.Type VisitIntType(QLMainParser.IntTypeContext context)
        {
            return new Types.IntType();
        }
    }
}
