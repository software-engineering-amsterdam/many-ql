using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;

namespace QL.AST.Nodes.Branches
{
    public class QuestionUnit : UnitBase
    {
        private ITerminalWrapper _value;

        public QuestionUnit(Identifier identifier, IStaticReturnType dataType, string displayText, SourceLocation sourceLocation)
            : base(identifier, dataType, displayText, sourceLocation)
        { }

        public QuestionUnit(Identifier identifier, IStaticReturnType dataType, string displayText)
            : base(identifier, dataType, displayText)
        { }

        public override ITerminalWrapper Value
        {
            get { return _value; }
            set
            {
                if (value == _value) return;
                _value = value;
                OnPropertyChanged();
            }
        }
    }
}
