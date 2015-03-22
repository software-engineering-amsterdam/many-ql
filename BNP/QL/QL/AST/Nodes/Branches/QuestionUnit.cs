using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class QuestionUnit : UnitBase
    {
        public QuestionUnit()
        { }

        public QuestionUnit(Identifier identifier, string displayText)
        {
            Identifier = identifier;
            DisplayText = displayText;
        }

        public QuestionUnit(Identifier identifier, string displayText, IStaticReturnType dataType) : this(identifier, displayText)
        {
            DataType = dataType;
        }
    }
}
