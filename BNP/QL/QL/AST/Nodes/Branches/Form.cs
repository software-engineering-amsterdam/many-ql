using System;
using QL.AST.Nodes.Terminals;

namespace QL.AST.Nodes.Branches
{
    public class Form : ElementBase
    {
        public Identifier Identifier { get; set; }
        public Block Block { get; set; }

        public Form()
        { }

        public Form(Identifier identifier, Block block)
        {
            Identifier = identifier;
            Block = block;
        }

        public Form(Identifier identifier, ElementBase block)
        {
            throw new Exception(identifier + ": " + block + " is not a block");
        }

        public Form(Identifier identifier, Block block, SourceLocation sourceLocation)
            : this(identifier, block)
        {
            SourceLocation = sourceLocation;
        }
    }
}
