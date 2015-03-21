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
    }
}
