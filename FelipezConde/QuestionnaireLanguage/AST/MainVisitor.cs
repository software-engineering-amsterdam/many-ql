using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Grammar;
using AST.Nodes;
using AST.Nodes.FormSection;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using AST.Nodes.FormObject;
using AST.Nodes.GenericTypeName;
using AST.Factory;
using AST.Nodes.Interfaces;

namespace AST
{
    public class MainVisitor : QLMainBaseVisitor<IASTNode>
    {
        private IEnumerable<IASTNode> FilterAndVisitChildren(ParserRuleContext context)
        {
            foreach (IParseTree child in context.children)
            {
                IASTNode visitedElement = Visit(child);

                if (visitedElement != null)
                    yield return visitedElement;
            }
        }

        #region FormElements
        public override IASTNode VisitForm(QLMainParser.FormContext context)
        {
            IASTNode ast = new Form();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitFormSection(QLMainParser.FormSectionContext context)
        {
            IASTNode ast = new FormSection();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitQuestion(QLMainParser.QuestionContext context)
        {
            IASTNode ast = ASTFactory.GetNode(context);

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitConditional(QLMainParser.ConditionalContext context)
        {
            IASTNode ast = new Conditional();

            foreach (IASTNode child in FilterAndVisitChildren(context))
                ast.AddChild(child);

            return ast;
        }
        #endregion

        #region Expressions

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

        #endregion

        #region Comparison

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
        #endregion

        #region Types
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

        #endregion

        #region KeyValue

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

        #endregion
    }
}
