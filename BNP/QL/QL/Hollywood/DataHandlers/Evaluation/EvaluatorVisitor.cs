using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.Contracts;
using System.Linq;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.AST.ValueWrappers;
using QL.Exceptions;
using QL.Exceptions.Errors;

namespace QL.Hollywood.DataHandlers.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        public IList<QLBaseException> Exceptions { get; private set; }

        References ValueReference;
        private EvaluationTerminalWrapperFactory _evaluationTerminalWrapperFactory;
       

        
        public EvaluatorVisitor(ObservableCollection<QLBaseException> exceptions, References valueReference)
        {
            Exceptions = exceptions;
            _evaluationTerminalWrapperFactory = new EvaluationTerminalWrapperFactory();
            ValueReference = valueReference;            

        }

        

        #region Regular elements
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
            YesnoWrapper conditionstate= ValueReference.GetValue(node.Expression) as YesnoWrapper;
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

            ValueReference.SetReference(node.Identifier, node.Expression);

        }

        public void Visit(QuestionUnit node)
        {
            ValueReference.SetReference(node.Identifier,node.DataType);

            if (!ValueReference.ContainsKey(node.DataType))
            { 
                ValueReference.SetValue(node.DataType, _evaluationTerminalWrapperFactory.CreateWrapper(node.DataType));
            }//todo shouldnt here be else with some warning?
        }


        
        

        public void Visit(Expression node)
        {

            //if expression is literal
            if(node.Child== null)
            {
                throw new Exception("Expression should have one and only one child");
            }

            node.Child.Accept(this);

            ValueReference.SetValue(node,  ValueReference.GetValue(node.Child));
        }

        #endregion
        void _VisitBinary(BinaryTreeElementBase node)
        {
            node.Left.Accept(this);
            node.Right.Accept(this);
        }

        #region Operators
        public void Visit(EqualsOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);

            ValueReference.SetValue(node,  ((dynamic)leftWrapper) == ((dynamic)rightWrapper));
            
        }

        public void Visit(NotEqualsOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) != ((dynamic)rightWrapper));
        }

        public void Visit(GreaterThanOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
                ValueReference.SetValue(node,  ((dynamic)leftWrapper) > ((dynamic)rightWrapper));
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
                ValueReference.SetValue(node,  ((dynamic)leftWrapper) >= ((dynamic)rightWrapper));
        }

        public void Visit(LessThanOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
                ValueReference.SetValue(node,  ((dynamic)leftWrapper) < ((dynamic)rightWrapper));
        }

        public void Visit(LessThanEqualToOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) <= ((dynamic)rightWrapper));
        }

        public void Visit(MultiplicationOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) * ((dynamic)rightWrapper));
            
        }

        public void Visit(DivisionOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) / ((dynamic)rightWrapper));
        }

        public void Visit(PlusOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) + ((dynamic)rightWrapper));
            
        }

        public void Visit(MinusOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) - ((dynamic)rightWrapper));
        }

        public void Visit(AndOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) & ((dynamic)rightWrapper));
         }

        public void Visit(OrOperator node)
        {
            _VisitBinary(node);

            ITerminalWrapper leftWrapper = ValueReference.GetValue(node.Left);
            ITerminalWrapper rightWrapper = ValueReference.GetValue(node.Right);
            ValueReference.SetValue(node,  ((dynamic)leftWrapper) | ((dynamic)rightWrapper));
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            ValueReference.SetValue(node,  new NumberWrapper(node));
            
        }

        public void Visit(Yesno node)
        {
            ValueReference.SetValue(node,  new YesnoWrapper(node));


        }

        public void Visit(Text node)
        {
            ValueReference.SetValue(node,  new TextWrapper(node));

        }

        public void Visit(Identifier node)
        {            
        }

        public void Visit(ElementBase node)
        {
            throw new QLError("Not implemented: " + node.GetType().ToString());
        }
        #endregion


    }
}
