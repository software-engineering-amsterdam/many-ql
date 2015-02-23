using AST.Nodes.Comparison;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Factory.PartialFactories
{
    internal static class Comparisson
    {
        internal static IASTNode GetNode(QLMainParser.PriorityComparisonContext context)
        {
            return new Nodes.Comparison.Priority();
        }

        internal static IASTNode GetNode(QLMainParser.ArithmeticComparisonContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.GT:
                    ast = new GreaterThan();
                    break;
                case QLMainParser.LT:
                    ast = new LessThan();
                    break;
                case QLMainParser.GET:
                    ast = new GreaterThanOrEqual();
                    break;
                case QLMainParser.LET:
                    ast = new LessThanOrEqual();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }
    }
}
