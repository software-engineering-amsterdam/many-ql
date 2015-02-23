using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.GenericTypeName;
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
    internal static class Expressions
    {
        public static IASTNode GetNode(QLMainParser.PrimitiveTypeNameContext context)
        {
            return null;
        }

        public static IASTNode GetNode(QLMainParser.GenericTypeNameContext context)
        {
            return new TypeName();
        }

        public static IASTNode GetNode(QLMainParser.PriorityExpressionContext context)
        {
            return new Nodes.Expression.Priority();
        }

        public static IASTNode GetNode(QLMainParser.IdContext context)
        {
            return new Id();
        }

        public static IASTNode GetNode(QLMainParser.ExpressionIdContext context)
        {
            return new Id();
        }


        public static IASTNode GetNode(QLMainParser.AndContext context)
        {
            return new And();
        }

        //TODO
        public static IASTNode GetNode(QLMainParser.ExpressionTypeContext context)
        {
            return new Bool();
        }

        internal static IASTNode GetNode(QLMainParser.NegateContext context)
        {
            return new Negate();
        }

        internal static IASTNode GetNode(QLMainParser.OrContext context)
        {
            return new Or();
        }

        internal static IASTNode GetNode(QLMainParser.EqualityContext context)
        {
            IASTNode ast;

            switch (context.op.Type)
            {
                case QLMainParser.EQ:
                    ast = new Equal();
                    break;
                case QLMainParser.NEQ:
                    ast = new NotEqual();
                    break;
                default:
                    throw new NotImplementedException();
            }

            return ast;
        }
    }
}
