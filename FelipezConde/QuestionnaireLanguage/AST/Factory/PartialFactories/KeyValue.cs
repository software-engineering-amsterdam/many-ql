using AST.Nodes.Interfaces;
using AST.Nodes.KeyValuePair;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Factory.PartialFactories
{
    internal static class KeyValue
    {
        internal static IASTNode GetNode(QLMainParser.KeyValuePairContext context)
        {
            return new KeyValuePair();
        }

        internal static IASTNode GetNode(QLMainParser.KeyValuePairsContext context)
        {
            return new KeyValuePairs();
        }
    }
}
