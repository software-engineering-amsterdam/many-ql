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
        private readonly NodeMapper _mapper;
        private readonly QLParser _parser;
        private readonly IList<UnitBase> _parsedUnits;

        public QLVisitor(QLParser parser, IList<UnitBase> parsedUnits)
        {
            _mapper = new NodeMapper();
            _parser = parser;
            _parsedUnits = parsedUnits;
        }

        public override QLParser.FormBlockContext VisitFormBlock(QLParser.FormBlockContext context)
        {
            Console.WriteLine("Formblock: {0}", context.GetText());

            _mapper.Create(context);

            return base.VisitFormBlock(context);
        }

        public override QLParser.FormBlockContext VisitBlock(QLParser.BlockContext context)
        {
            Console.WriteLine("Block: {0}", context.GetText());
            return base.VisitBlock(context);
        }

        public override QLParser.FormBlockContext VisitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            Console.WriteLine("QuestionUnit: {0}", context.GetText());
            return base.VisitQuestionUnit(context);
        }

        public override QLParser.FormBlockContext VisitStatementUnit(QLParser.StatementUnitContext context)
        {
            Console.WriteLine("StatementUnit: {0}", context.GetText());
            return base.VisitStatementUnit(context);
        }

        public override QLParser.FormBlockContext VisitControlBlockUnit(QLParser.ControlBlockUnitContext context)
        {
            Console.WriteLine("ControlBlockUnit: {0}", context.GetText());
            return base.VisitControlBlockUnit(context);
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

        public override QLParser.FormBlockContext VisitControlBlock(QLParser.ControlBlockContext context)
        {
            Console.WriteLine("IfStatement: {0}", context.GetText());
            return base.VisitControlBlock(context);
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
