using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Types = AST.Types;

namespace AST.Representation
{
    public class NameToType
    {
        public readonly string name;
        public readonly Types.Type type;

        public NameToType(string name, Types.Type type)
        {
            this.name = name;
            this.type = type;
        }
    }
}
