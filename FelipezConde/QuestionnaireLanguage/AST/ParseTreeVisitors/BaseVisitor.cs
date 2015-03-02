using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using AST.Nodes.Interfaces;
using Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.ParseTreeVisitors
{
    public class BaseVisitor : QLMainBaseVisitor<IASTNode>
    {
        /// <summary>
        /// Visit the children and filter null
        /// </summary>
        /// <param name="context">the context of the node whose children you want to visit</param>
        /// <returns>All non-null children of the parameter</returns>
        public IEnumerable<IASTNode> FilterAndVisitChildren(ParserRuleContext context)
        {
            foreach (IParseTree child in context.children)
            {
                IASTNode visitedElement = Visit(child);

                if (visitedElement != null)
                    yield return visitedElement;
            }
        }
    }
}
