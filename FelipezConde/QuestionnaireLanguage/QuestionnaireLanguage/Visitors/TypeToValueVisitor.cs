using QuestionnaireLanguage.Visitors.Interfaces;
using Types = AST.Types;
using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToValueVisitor : ITypeToValueVisitor
    {
        public Values.Literal VisitValue(Types.Type value)
        {
            return Visit((dynamic)value);
        }
        public Values.String Visit(Types.StringType type)
        {
            return new Values.String(string.Empty);
        }

        public Values.Int Visit(Types.IntType intValue)
        {
            return new Values.Int(0);
        }

        public Values.Bool Visit(Types.BoolType boolValue)
        {
            return new Values.Bool(false);
        }
    }
}
