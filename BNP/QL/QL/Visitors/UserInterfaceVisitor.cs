using QL.Visitors;
using QL.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Visitors
{
    class UserInterfaceVisitor :IVisitor
    {
        IList<ElementBase> ElementsToDisplay;

        public IList<Exceptions.QLException> Exceptions
        {
            get { throw new NotImplementedException(); }
        }


        public void Visit(Model.Form node)
        {
            //display 
            throw new NotImplementedException();
        }


        public void Visit(Model.ControlUnit node)
        {
            //evaluate and modify control flow
            throw new NotImplementedException();

        }

        public void Visit(Model.StatementUnit node)
        {
            //display
            throw new NotImplementedException();
        }

        public void Visit(Model.QuestionUnit node)
        {
            //display
            throw new NotImplementedException();
        }
        #region Not used elements
        public void Visit(Model.Block node)
        {
        }

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
