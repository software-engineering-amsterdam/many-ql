using AST.Nodes.Literals;
using Grammar;
using Values = AST.Nodes.Literals;
namespace AST.ParseTreeVisitors
{
    public class LiteralVisitor : QLMainBaseVisitor<Literal>
    {
        public override Literal VisitTrueBool(QLMainParser.TrueBoolContext context)
        {
            string show = context.TRUE().GetText();
            return new Values.Bool(true);
        }

        public override Literal VisitFalseBool(QLMainParser.FalseBoolContext context)
        {
            return new Values.Bool(false);
        }

        public override Literal VisitStringValue(QLMainParser.StringValueContext context)
        {
            string stringValue = context.@string().STRINGLITERAL().GetText();

            return new Values.String(stringValue.Substring(1, stringValue.Length-2)
                                     ); 
        }

        public override Literal VisitIntValue(QLMainParser.IntValueContext context)
        {
            string intValue = context.@int().INTLITERAL().GetText();

            return new Values.Int(int.Parse(intValue));
        }
    }
}
