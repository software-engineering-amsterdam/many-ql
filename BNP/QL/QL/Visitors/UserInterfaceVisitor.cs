using QL.Visitors;
using QL.Visitors.UIWrappers;

using QL.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;


namespace QL.Visitors
{
    class UserInterfaceVisitor :IVisitor
    {
        IList<IRenderable> ElementsToDisplay;
        private System.Collections.ObjectModel.ObservableCollection<QL.Exceptions.QLException> ASTHandlerExceptions;
        private IDictionary<ITypeResolvable, TerminalWrapper> ReferenceLookupTable;
        private IDictionary<Model.Terminals.Identifier, ITypeResolvable> IdentifierTable;
        public IList<QLException> Exceptions { get; private set; }


        public UserInterfaceVisitor(
            System.Collections.ObjectModel.ObservableCollection<QL.Exceptions.QLException> ASTHandlerExceptions,
            IDictionary<ITypeResolvable, TerminalWrapper> ReferenceLookupTable, 
            IDictionary<Model.Terminals.Identifier, ITypeResolvable> IdentifierTable, 
            IList<IRenderable> ElementsToDisplay
            )
        {
            // TODO: Complete member initialization
            this.ASTHandlerExceptions = ASTHandlerExceptions;
            this.ReferenceLookupTable = ReferenceLookupTable;
            this.IdentifierTable = IdentifierTable;
            this.ElementsToDisplay = ElementsToDisplay;
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
            System.Diagnostics.Contracts.Contract.Assert(((ReferenceLookupTable[node.Expression] as YesnoWrapper) != null).ToBool());
            if (((YesnoWrapper)ReferenceLookupTable[node.Expression]).ToBool())
            {
                node.ConditionTrueBlock.Accept(this);
            }
            else if (node.ConditionFalseBlock!=null)
            {
                
                node.ConditionFalseBlock.Accept(this);
            }
        }


        public void Visit(Model.StatementUnit node)
        {
            ElementsToDisplay.Add(new StatementWrapper(node, ReferenceLookupTable[IdentifierTable[node.Identifier]]));
        }

        public void Visit(Model.QuestionUnit node)
        {
            ElementsToDisplay.Add(new QuestionWrapper(node, ReferenceLookupTable[IdentifierTable[node.Identifier]]));
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
