using AST.Nodes.Interfaces;
using AST.Nodes.Types;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Factory.PartialFactories
{
    internal static class Types
    {
        #region Types
        internal static IASTNode GetNode(QLMainParser.NumIntContext context)
        {
            return new Int();
        }

        internal static IASTNode GetNode(QLMainParser.NumMoneyContext context)
        {
            return new Money();
        }

        internal static IASTNode GetNode(QLMainParser.NumDecimalContext context)
        {
            return new Nodes.Types.Decimal();
        }

        internal static IASTNode GetNode(QLMainParser.BoolValueContext context)
        {
            return new Nodes.Types.Bool();
        }

        internal static IASTNode GetNode(QLMainParser.StringValueContext context)
        {
            return new Nodes.Types.String();
        }

        internal static IASTNode GetNode(QLMainParser.DateValueContext context)
        {
            return new Nodes.Types.Date();
        }

        internal static IASTNode GetNode(QLMainParser.ListContext context)
        {
            return new List();
        }
        #endregion

    }
}
