using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class QuestionUnit : UnitBase
    {
        public QuestionUnit(Terminals.Identifier identifier, IStaticReturnType dataType, string displayText, SourceLocation sourceLocation)
            : base(identifier, dataType, displayText, sourceLocation)
        { }
        public QuestionUnit(Terminals.Identifier identifier, IStaticReturnType dataType, string displayText)
            : base(identifier, dataType, displayText)
        { }

    }
}
