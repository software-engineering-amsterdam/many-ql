using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class QuestionUnit : UnitBase
    {
        public QuestionUnit()
        { }

        public QuestionUnit(Identifier identifier, Text displayText)
        {
            Identifier = identifier;
            DisplayText = displayText.Value;
        }

        public QuestionUnit(Identifier identifier, Text displayText, IStaticReturnType dataType) : this(identifier, displayText)
        {
            DataType = dataType;
        }
    }
}
