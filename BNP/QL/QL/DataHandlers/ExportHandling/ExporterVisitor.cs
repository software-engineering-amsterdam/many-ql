using System.Collections.Generic;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.Exceptions.Errors;

namespace QL.DataHandlers.ExportHandling
{
    public class ExporterVisitor : IVisitor
    {
        private readonly IDictionary<string, object> _unitsToAnswers;

        public ExporterVisitor(IDictionary<string, object> unitsToAnswers)
        {
            _unitsToAnswers = unitsToAnswers;
        }

        public void Visit(StatementUnit node)
        {
            _unitsToAnswers.Add(node.Text, node.Value);
        }

        public void Visit(QuestionUnit node)
        {
            _unitsToAnswers.Add(node.Text, node.Value);
        }

        public void Visit(Form node)
        {
            node.Block.Accept(this);
        }

        public void Visit(Block node)
        {
            foreach (ElementBase child in node.Children)
            {
                child.Accept(this);
            }
        }

        public void Visit(ElementBase elementBase)
        {
            throw new QLError("Exporter attemted to export an ElementBase which is not allowed", elementBase.SourceLocation);
        }

        #region Unused Visit overloads
        public void Visit(ControlUnit node)
        {
        }

        public void Visit(Expression node)
        {}

        public void Visit(Yesno node)
        {}

        public void Visit(Number node)
        {}

        public void Visit(Text node)
        {}

        public void Visit(Identifier node)
        {}

        public void Visit(EqualsOperator node)
        {}

        public void Visit(NotEqualsOperator node)
        {}

        public void Visit(GreaterThanOperator node)
        {}

        public void Visit(GreaterThanEqualToOperator node)
        {}

        public void Visit(LessThanOperator node)
        {}

        public void Visit(LessThanEqualToOperator node)
        {}

        public void Visit(MultiplicationOperator node)
        {}

        public void Visit(DivisionOperator node)
        {}

        public void Visit(PlusOperator node)
        {}

        public void Visit(MinusOperator node)
        {}

        public void Visit(AndOperator node)
        {}

        public void Visit(OrOperator node)
        {}
        #endregion
    }
}