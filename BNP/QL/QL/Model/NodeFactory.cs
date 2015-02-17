using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;

namespace QL.Model
{
    public sealed class NodeFactory
    {
        private readonly ParserRuleContext _context;

        public NodeFactory(ParserRuleContext context)
        {
            _context = context;
        }

    }
}
