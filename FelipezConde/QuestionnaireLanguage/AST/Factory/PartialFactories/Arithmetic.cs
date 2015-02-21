using AST.Nodes;
using AST.Nodes.Arithmetic;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Factory.PartialFactories
{
    internal static class Arithmetic
    {
        internal static IASTNode GetNode(QLMainParser.PriorityArithmeticContext context)
        {
            return new Nodes.Arithmetic.Priority();
        }

        internal static IASTNode GetNode(QLMainParser.DivMulContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.MUL:
                    ast = new Multiply();
                    break;
                case QLMainParser.DIV:
                    ast = new Divide();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }

        internal static IASTNode GetNode(QLMainParser.SubAddContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.SUB:
                    ast = new Subtract();
                    break;
                case QLMainParser.ADD:
                    ast = new Add();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }

        internal static IASTNode GetNode(QLMainParser.ArithmeticIdContext context)
        {
            return new Id();
        }

    }
}
