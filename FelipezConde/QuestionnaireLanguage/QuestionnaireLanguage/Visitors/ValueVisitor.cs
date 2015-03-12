using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;
using Types = AST.Types;
using AST.Nodes.Interfaces;

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
