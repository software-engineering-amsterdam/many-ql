using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.Visitors
{
    public static class ValueVisitor
    {
        public static string Visit(Values.String value)
        {
            return value.GetValue();
        }

        public static int Visit(Values.Int value)
        {
            return value.GetValue();
        }

        public static bool Visit(Values.Bool value)
        {
            return value.GetValue();
        }
    }
}
