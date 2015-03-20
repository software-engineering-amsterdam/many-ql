using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using QL.Exceptions;
using QL.Model;
using QL.Model.Terminals.Wrappers;
using QL.UI.Controls;
using QL.UI.ControlWrappers;
using QL.Visitors;

namespace QL.UI.Visitors
{
    public class UserInterfaceVisitor : IVisitor
    {
        private readonly WidgetFactory _widgetFactory = new WidgetFactory();

        private IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable;
        private readonly IList<WidgetBase> _elementsToDisplay;
        //public ObservableCollection<QLException> ASTHandlerExceptions { get; private set; }
        private readonly IDictionary<ITypeResolvable, ITerminalWrapper> _referenceLookupTable;
        private readonly IDictionary<Model.Terminals.Identifier, ITypeResolvable> _identifierTable;
        public IList<QLException> Exceptions { get; private set; }


        public UserInterfaceVisitor(
            ObservableCollection<QLException> ASTHandlerExceptions,
            IDictionary<ITypeResolvable, ITerminalWrapper> ReferenceLookupTable,
            IDictionary<Model.Terminals.Identifier, ITypeResolvable> IdentifierTable,
            IList<WidgetBase> ElementsToDisplay
            )
        {
            // TODO: Complete member initialization
            this._referenceLookupTable = ReferenceLookupTable;
            this._identifierTable = IdentifierTable;
            this._elementsToDisplay = ElementsToDisplay;
        }
        
        public void Visit(Model.Form node)
        {
            node.Block.AcceptSingle(this);
        }

        public void Visit(Model.Block node)
        {
            foreach (IVisitable child in node.Children)
            {
                child.AcceptSingle(this);
            }
        }
        
        public void Visit(Model.ControlUnit node)
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
        
        public void Visit(Model.StatementUnit node)
        {
            var unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo set identifier/do lookup

            //_elementsToDisplay.Add(new StatementWrapper(node, _referenceLookupTable[_identifierTable[node.Identifier]]));
        }

        public void Visit(Model.QuestionUnit node)
        {
            var unitWrapper = _widgetFactory.GetWidget(node);
            _elementsToDisplay.Add(unitWrapper); // todo idem ditto

            //_elementsToDisplay.Add(new WidgetWrapperBase(node, _referenceLookupTable[_identifierTable[node.Identifier]]));
        }

        #region Not used elements
        public void Visit(Model.Expression node)
        {
        }

        public void Visit(Model.Operators.EqualsOperator node)
        {
        }

        public void Visit(Model.Operators.NotEqualsOperator node)
        {
        }

        public void Visit(Model.Operators.GreaterThanOperator node)
        {
        }

        public void Visit(Model.Operators.GreaterThanEqualToOperator node)
        {
        }

        public void Visit(Model.Operators.LessThanOperator node)
        {
        }

        public void Visit(Model.Operators.LessThanEqualToOperator node)
        {
        }

        public void Visit(Model.Operators.MultiplicationOperator node)
        {
        }

        public void Visit(Model.Operators.DivisionOperator node)
        {
        }

        public void Visit(Model.Operators.PlusOperator node)
        {
        }

        public void Visit(Model.Operators.MinusOperator node)
        {
        }

        public void Visit(Model.Operators.AndOperator node)
        {
        }

        public void Visit(Model.Operators.OrOperator node)
        {
        }

        public void Visit(Model.Terminals.Yesno node)
        {
        }

        public void Visit(Model.Terminals.Number node)
        {
        }

        public void Visit(Model.Terminals.Text node)
        {
        }

        public void Visit(Model.Terminals.Identifier node)
        {
        }

        public void Visit(Model.ElementBase elementBase)
        {
            throw new NotImplementedException();
        }
        #endregion
    }

}
