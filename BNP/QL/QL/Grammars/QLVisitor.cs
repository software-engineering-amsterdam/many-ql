using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;

namespace QL.Grammars
{
    public class QLVisitor : QLBaseVisitor<QLParser.FormBlockContext>
    {
        private readonly QLParser _parser;
        private readonly IList<UnitBase> _parsedUnits;

        public QLVisitor(QLParser parser, IList<UnitBase> parsedUnits)
        {
            _parser = parser;
            _parsedUnits = parsedUnits;
        }

        public override QLParser.FormBlockContext VisitFormBlock(QLParser.FormBlockContext context)
        {
            Console.WriteLine("Formblock: {0}", context.GetText());
            return base.VisitFormBlock(context);
        }

        public override QLParser.FormBlockContext VisitBlock(QLParser.BlockContext context)
        {
            Console.WriteLine("Block: {0}", context.GetText());
            return base.VisitBlock(context);
        }

        public override QLParser.FormBlockContext VisitUnit(QLParser.UnitContext context)
        {
            Console.WriteLine("Unit: {0}", context.GetText());

            if (_parser.InContext("unit") && context.ChildCount > 0)
            {
                var id = context.GetChild(1).GetText();
                var question = context.GetChild(context.ChildCount - 2).GetText();
                var arguments = context.children.Skip(3).Select(child => child.GetText()).Take(context.ChildCount - 3 - 3).ToArray();

                QuestionUnit questionUnit = new QuestionUnit(id, question, arguments);

                _parsedUnits.Add(questionUnit);
            }

            return base.VisitUnit(context);
        }

        public override QLParser.FormBlockContext VisitTypedef(QLParser.TypedefContext context)
        {
            Console.WriteLine("Typedef: {0}", context.GetText());
            return base.VisitTypedef(context);
        }

        public override QLParser.FormBlockContext VisitTypeDefExt(QLParser.TypeDefExtContext context)
        {
            Console.WriteLine("TypedefExt: {0}", context.GetText());
            return base.VisitTypeDefExt(context);
        }
        
        public override QLParser.FormBlockContext VisitExpression(QLParser.ExpressionContext context)
        {
            Console.WriteLine("Expression: {0}", context.GetText());
            return base.VisitExpression(context);
        }

        public override QLParser.FormBlockContext VisitIfStatement(QLParser.IfStatementContext context)
        {
            Console.WriteLine("IfStatement: {0}", context.GetText());
            return base.VisitIfStatement(context);
        }

        public override QLParser.FormBlockContext VisitOperator(QLParser.OperatorContext context)
        {
            Console.WriteLine("Operator: {0}", context.GetText());
            return base.VisitOperator(context);
        }

        public override QLParser.FormBlockContext VisitChildren(Antlr4.Runtime.Tree.IRuleNode node)
        {
            //Console.WriteLine(node.GetText());
            return base.VisitChildren(node);
        }

        public override QLParser.FormBlockContext VisitErrorNode(Antlr4.Runtime.Tree.IErrorNode node)
        {
            //Console.WriteLine(node.GetText());
            return base.VisitErrorNode(node);
        }

        public override QLParser.FormBlockContext VisitTerminal(Antlr4.Runtime.Tree.ITerminalNode node)
        {
            //Console.WriteLine(node.GetText());
            return base.VisitTerminal(node);
        }

        public override QLParser.FormBlockContext Visit(Antlr4.Runtime.Tree.IParseTree tree)
        {
            Console.WriteLine(tree.ToString());
            return base.Visit(tree);
        }
    }
}
