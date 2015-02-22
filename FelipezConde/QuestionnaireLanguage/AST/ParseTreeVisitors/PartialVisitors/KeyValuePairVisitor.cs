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
    public class KeyValuePairVisitor : BaseVisitor
    {
        public override IASTNode VisitKeyValuePairs(QLMainParser.KeyValuePairsContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitKeyValuePair(QLMainParser.KeyValuePairContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
    }
}
