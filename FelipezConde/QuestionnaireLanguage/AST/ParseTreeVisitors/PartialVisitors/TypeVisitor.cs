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
    public class TypeVisitor : BaseVisitor
    {
        public override IASTNode VisitNumInt(QLMainParser.NumIntContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitNumDecimal(QLMainParser.NumDecimalContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitNumMoney(QLMainParser.NumMoneyContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitBoolValue(QLMainParser.BoolValueContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitStringValue(QLMainParser.StringValueContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitDateValue(QLMainParser.DateValueContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitList(QLMainParser.ListContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
    }
}
