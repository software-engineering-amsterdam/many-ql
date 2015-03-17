using Grammar;


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
