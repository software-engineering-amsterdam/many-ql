using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Representation
{
    public class NameToType
    {
        public readonly string name;
        public readonly IValue type;

        public NameToType(string name, IValue type)
        {
            this.name = name;
            this.type = type;
        }
    }
}
