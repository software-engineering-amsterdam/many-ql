using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Values = AST.Nodes.Values;

namespace QuestionnaireLanguage.Factory
{
    public static class NodeValueFactory
    {
        public static Values.String GetNodeValue(string primitiveValue)
        {
            return new Values.String(primitiveValue);
        }
        public static Values.Int GetNodeValue(int primitiveValue)
        {
            return new Values.Int(primitiveValue);
        }
        public static Values.Bool GetNodeValue(bool? primitiveValue)
        {
            return new Values.Bool(primitiveValue.Value);
        }
    }
}
