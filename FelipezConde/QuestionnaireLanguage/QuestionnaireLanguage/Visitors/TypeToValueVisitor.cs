using QuestionnaireLanguage.Visitors.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;
using Types = AST.Types;

namespace QuestionnaireLanguage.Visitors
{
    public class TypeToValueVisitor : ITypeToValueVisitor
    {
        public Values.Value VisitValue(Types.Type value)
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
