using AST.Types.Visitors;
using Types = AST.Types;
using Values = Evaluation.Values;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToValue : ITypeVisitor<Values.Value>
    {
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

        public Values.Value Visit(Types.UndefinedType undefinedType)
        {
            throw new System.NotImplementedException();
        }
    }
}
