using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;

namespace QuestionnaireLanguage.Factory
{
    public static class PrimitiveValueFactory
    {
        public static bool GetPrimitiveValue(Values.Bool value)
        {
            return value.GetValue();
        }

        public static string GetPrimitiveValue(Values.String value)
        {
            return value.GetValue();
        }

        public static int GetPrimitiveValue(Values.Int value)
        {
            return value.GetValue();
        }
    }
}
