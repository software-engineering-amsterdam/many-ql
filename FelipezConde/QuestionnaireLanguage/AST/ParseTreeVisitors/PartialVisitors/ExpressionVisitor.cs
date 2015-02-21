using AST.Factory;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ParseTreeVisitors.PartialVisitors
{
    public class ExpressionVisitor : BaseVisitor
    {
        public override IASTNode VisitPrimitiveTypeName(QLMainParser.PrimitiveTypeNameContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            //foreach (IASTNode child in VisitChildren(context))
            //    ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitGenericTypeName(QLMainParser.GenericTypeNameContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitPriorityExpression(QLMainParser.PriorityExpressionContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitExpressionId(QLMainParser.ExpressionIdContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitNegate(QLMainParser.NegateContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitAnd(QLMainParser.AndContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitOr(QLMainParser.OrContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitEquality(QLMainParser.EqualityContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
    }
}
