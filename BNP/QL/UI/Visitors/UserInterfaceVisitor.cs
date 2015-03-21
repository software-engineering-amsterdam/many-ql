using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.AST.ValueWrappers;
using QL.Exceptions;
using QL.UI.Controls;
using QL.UI.ControlWrappers;

namespace QL.UI.Visitors
{
    public class UserInterfaceVisitor : IVisitor
    {
        private readonly WidgetFactory _widgetFactory = new WidgetFactory();

        private IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable;
        private readonly IList<WidgetBase> _elementsToDisplay;
        private readonly IDictionary<ITypeResolvable, ITerminalWrapper> _referenceLookupTable;
        private readonly IDictionary<Identifier, ITypeResolvable> _identifierTable;
        public IList<QLBaseException> Exceptions { get; private set; }


        public UserInterfaceVisitor(
            ObservableCollection<QLBaseException> ASTHandlerExceptions,
            IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable,
            IDictionary<Identifier, ITypeResolvable> IdentifierTable,
            IList<WidgetBase> ElementsToDisplay
            )
        {
            // TODO: Complete member initialization
            this._referenceLookupTable = ReferenceLookupTable;
            this._identifierTable = IdentifierTable;
            this._elementsToDisplay = ElementsToDisplay;
        }
        
        public void Visit(Form node)
        {
            node.Block.Accept(this);
        }

        public void Visit(Block node)
        {
            foreach (IVisitable child in node.Children)
            {
                child.Accept(this);
            }
        }
        
        public void Visit(ControlUnit node)
        {
            System.Diagnostics.Contracts.Contract.Assert(((_referenceLookupTable[node.Expression] as YesnoWrapper) != null).ToBool());
            if (((YesnoWrapper)ReferenceLookupTable[node.Expression]).ToBool()) //TODO if result is null Wrapped, do not do true nor false block
            {
                node.ConditionTrueBlock.Accept(this);
            }
            else if (node.ConditionFalseBlock != null)
            {

                node.ConditionFalseBlock.Accept(this);
            }
        }
        
        public void Visit(StatementUnit node)
        {
            var unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo set identifier/do lookup
        }

        public void Visit(QuestionUnit node)
        {
            var unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo idem ditto
        }

        #region Unused Visit method overloads that are irrelevant for the GUI
        /// <summary>
        /// This method has a signature with the highest class in the hierarchy and will act as a fallback
        /// </summary>
        public void Visit(ElementBase elementBase)
        {
            throw new NotImplementedException();
        }

        public void Visit(Expression node)
        {
        }

        public void Visit(EqualsOperator node)
        {
        }

        public void Visit(NotEqualsOperator node)
        {
        }

        public void Visit(GreaterThanOperator node)
        {
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
        }

        public void Visit(LessThanOperator node)
        {
        }

        public void Visit(LessThanEqualToOperator node)
        {
        }

        public void Visit(MultiplicationOperator node)
        {
        }

        public void Visit(DivisionOperator node)
        {
        }

        public void Visit(PlusOperator node)
        {
        }

        public void Visit(MinusOperator node)
        {
        }

        public void Visit(AndOperator node)
        {
        }

        public void Visit(OrOperator node)
        {
        }

        public void Visit(Yesno node)
        {
        }

        public void Visit(Number node)
        {
        }

        public void Visit(Text node)
        {
        }

        public void Visit(Identifier node)
        {
        }
        #endregion
    }

}
