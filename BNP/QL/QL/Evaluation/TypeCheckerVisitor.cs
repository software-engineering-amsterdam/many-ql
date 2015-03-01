using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Evaluation
{
    class TypeCheckerVisitor: IVisitor
    {
        public void visit(Model.Form node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Block node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.ControlUnit node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.StatementUnit node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.QuestionUnit node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Expression node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Operators.EqualsOperator node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Operators.NotEqualsOperator node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Operators.PlusOperator node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Terminals.Number node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Terminals.Yesno node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Terminals.Identifier node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.Terminals.Text node)
        {
            throw new NotImplementedException();
        }

        public void visit(Model.ElementBase elementBase)
        {
            throw new NotImplementedException();
        }
    }
}
