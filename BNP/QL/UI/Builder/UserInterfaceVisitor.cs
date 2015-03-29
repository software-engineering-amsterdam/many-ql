using System;
using System.Collections.Generic;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;
using QL.UI.Controls;
using QL.UI.ControlWrappers;

namespace QL.UI.Builder
{
    public class UserInterfaceVisitor : ISimpleVisitor
    {
        private readonly WidgetFactory _widgetFactory;
        private readonly IList<WidgetBase> _elementsToDisplay;
        public ReferenceTables ReferenceTables { get; private set; }
        public IList<QLBaseException> Exceptions { get; private set; }
        
        public UserInterfaceVisitor(ReferenceTables referenceTables, IList<QLBaseException> exceptions, IList<WidgetBase> elementsToDisplay)
        {
            _widgetFactory = new WidgetFactory();
            _elementsToDisplay = elementsToDisplay;
            ReferenceTables = referenceTables;
            Exceptions = exceptions;
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
            // todo implement visibility logic here
            //System.Diagnostics.Contracts.Contract.Assert(((_referenceLookupTable[node.Expression] as YesnoWrapper) != null).ToBool());
            
            if (node.ConditionTrueBlock != null) //TODO if result is null Wrapped, do not do true nor false block
            {
                node.ConditionTrueBlock.Accept(this);
            }

            if (node.ConditionFalseBlock != null)
            {
                node.ConditionFalseBlock.Accept(this);
            }
        }
        
        public void Visit(StatementUnit node)
        {
            WidgetBase unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo set identifier/do lookup
        }

        public void Visit(QuestionUnit node)
        {
            WidgetBase unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo idem ditto
        }
        #endregion

        #region Unused Visit method overloads that are irrelevant for the GUI
        public void Visit(Expression node)
        {
        }

        /// <summary>
        /// This method has a signature with the highest class in the hierarchy and will act as a fallback
        /// </summary>
        public void Visit(ElementBase elementBase)
        {
            throw new NotImplementedException("GUI Visitor did not expect an ElementBase fallback");
        }
        #endregion
    }

}
