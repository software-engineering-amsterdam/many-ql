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
    public class ComparisonVisitor : BaseVisitor
    {
        public override IASTNode VisitPriorityComparison(QLMainParser.PriorityComparisonContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitArithmeticComparison(QLMainParser.ArithmeticComparisonContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitPriorityArithmetic(QLMainParser.PriorityArithmeticContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitDivMul(QLMainParser.DivMulContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitSubAdd(QLMainParser.SubAddContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitArithmeticId(QLMainParser.ArithmeticIdContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
    }
}
