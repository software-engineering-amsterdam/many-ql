using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.AST.Nodes.Terminals.Wrappers;
using QL.Exceptions;
using QL.Exceptions.Errors;

namespace QL.DataHandlers.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        private readonly EvaluationTerminalWrapperFactory _evaluationTerminalWrapperFactory;

        public ReferenceTables ReferenceTables { get; private set; }
        public IList<QLBaseException> Exceptions { get; private set; }

        public EvaluatorVisitor(ObservableCollection<QLBaseException> exceptions, ReferenceTables referenceTables)
        {
            _evaluationTerminalWrapperFactory = new EvaluationTerminalWrapperFactory();
            Exceptions = exceptions;
            ReferenceTables = referenceTables;
        }

        #region Regular element visitors
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

        public void Visit(ControlUnit node)
        {
            node.Expression.Accept(this);

            YesnoWrapper conditionstate = (YesnoWrapper)ReferenceTables.GetValue(node.Expression);
            if (node.ConditionTrueBlock != null && conditionstate.Value.HasValue && conditionstate.Value.Value)
            {
                node.ConditionTrueBlock.Accept(this);
            }

            if (node.ConditionFalseBlock != null && conditionstate.Value.HasValue && !conditionstate.Value.Value)
            {
                node.ConditionFalseBlock.Accept(this);
            }
        }

        public void Visit(StatementUnit node)
        {
            node.Expression.Accept(this);
            ReferenceTables.SetReference(node.Identifier, node.Expression);
        }

        public void Visit(QuestionUnit node)
        {
            ReferenceTables.SetReference(node.Identifier, node.DataType);

            if (!ReferenceTables.ContainsReference(node.DataType))
            {
                var wrapper = _evaluationTerminalWrapperFactory.CreateWrapper(node.DataType);
                node.Value = wrapper;
                ReferenceTables.SetValue(node.DataType, wrapper);
            }
        }

        public void Visit(Expression node)
        {
            //if expression is literal
            if (node.Child == null)
            {
                throw new Exception("Expression should have one and only one child");
            }

            node.Child.Accept(this);

            ReferenceTables.SetValue(node, ReferenceTables.GetValue(node.Child));
        }

        private void VisitBinary(BinaryTreeElementBase node)
        {
            node.Left.Accept(this);
            node.Right.Accept(this);
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) == ((dynamic)rightWrapper));
        }

        public void Visit(NotEqualsOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) != ((dynamic)rightWrapper));
        }

        public void Visit(GreaterThanOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) > ((dynamic)rightWrapper));
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) >= ((dynamic)rightWrapper));
        }

        public void Visit(LessThanOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) < ((dynamic)rightWrapper));
        }

        public void Visit(LessThanEqualToOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) <= ((dynamic)rightWrapper));
        }

        public void Visit(MultiplicationOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) * ((dynamic)rightWrapper));
        }

        public void Visit(DivisionOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) / ((dynamic)rightWrapper));
        }

        public void Visit(PlusOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) + ((dynamic)rightWrapper));
        }

        public void Visit(MinusOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) - ((dynamic)rightWrapper));
        }

        public void Visit(AndOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) & ((dynamic)rightWrapper));
        }

        public void Visit(OrOperator node)
        {
            VisitBinary(node);

            ITerminalWrapper leftWrapper = ReferenceTables.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ReferenceTables.GetValue(node.Right);
            ReferenceTables.SetValue(node, ((dynamic)leftWrapper) | ((dynamic)rightWrapper));
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            ReferenceTables.SetValue(node, new NumberWrapper(node));
        }

        public void Visit(Yesno node)
        {
            ReferenceTables.SetValue(node, new YesnoWrapper(node));
        }

        public void Visit(Text node)
        {
            ReferenceTables.SetValue(node, new TextWrapper(node));
        }

        public void Visit(Identifier node)
        {
        }

        public void Visit(ElementBase node)
        {
            throw new QLError("Not implemented type to evaluate: " + node.GetType());
        }
        #endregion
    }
}
