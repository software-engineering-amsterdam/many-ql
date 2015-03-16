using QuestionnaireLanguage.Visitors.Interfaces;
using Types = AST.Types;
using Values = Evaluator.Values;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToValue : ITypeVisitor<Values.Value>
    {
        public Values.Value VisitValue(Types.Type value)
        {
            return Visit((dynamic)value);
        }
        public Values.Value Visit(Types.StringType type)
        {
            return new Values.String(string.Empty);
        }

        public Values.Value Visit(Types.IntType intValue)
        {
            return new Values.Int(0);
        }

        public Values.Value Visit(Types.BoolType boolValue)
        {
            return new Values.Bool(false);
        }
    }
}
