using Values = AST.Nodes.Literals;

namespace QuestionnaireLanguage.Factories
{
    public static class NodeValueFactory
    {
        public static Values.String GetNodeValue(string primitiveValue)
        {
            return new Values.String(primitiveValue, new AST.Representation.PositionInText());
        }
        public static Values.Int GetNodeValue(int primitiveValue)
        {
            return new Values.Int(primitiveValue, new AST.Representation.PositionInText());
        }
        public static Values.Bool GetNodeValue(bool? primitiveValue)
        {
            return new Values.Bool(primitiveValue.Value, new AST.Representation.PositionInText());
        }
    }
}
