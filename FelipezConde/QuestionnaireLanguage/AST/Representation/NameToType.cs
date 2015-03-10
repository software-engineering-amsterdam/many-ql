using AST.Nodes.Expression;
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
    public class IdToType
    {
        public readonly Id id;
        public readonly Types.Type type;

        public IdToType(Id id, Types.Type type)
        {
            this.id = id;
            this.type = type;
        }
    }
}
