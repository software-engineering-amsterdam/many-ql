using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public abstract class UnitBase : ElementBase
    {

        public IStaticReturnType DataType { get; set; }
        public Identifier Identifier { get; set; }
        public string DisplayText { get; set; }

        protected UnitBase()
        {
        }

        protected UnitBase(Terminals.Identifier identifier, IStaticReturnType dataType, string displayText)
        {
            Identifier = identifier;
            DataType = dataType;
            DisplayText = UnwrapQuotes(displayText);
        }

        protected UnitBase(Terminals.Identifier identifier, IStaticReturnType dataType, string displayText, SourceLocation sourceLocation)
            : this(identifier, dataType, displayText)
        {
            SourceLocation = sourceLocation;
        }
    }
}
