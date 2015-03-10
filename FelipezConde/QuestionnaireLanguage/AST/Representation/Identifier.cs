using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using AST.Nodes.Interfaces;

namespace AST.Representation
{
    public class Identifier
    {
        public IASTNode Node { get; private set; }
        public string Name   { get; private set; }
        
        public Identifier(IASTNode node, string name)
        {
            this.Name = name;
            this.Node = node;

        }
    }
}
