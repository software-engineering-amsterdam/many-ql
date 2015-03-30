using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class QuestionUnit : UnitBase
    {
        private object _value;

        public QuestionUnit(Identifier identifier, IStaticReturnType dataType, string displayText, SourceLocation sourceLocation)
            : base(identifier, dataType, displayText, sourceLocation)
        { }

        public QuestionUnit(Identifier identifier, IStaticReturnType dataType, string displayText)
            : base(identifier, dataType, displayText)
        { }

        public override object Value
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
