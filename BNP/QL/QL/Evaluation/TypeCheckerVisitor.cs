using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;

namespace QL.Evaluation
{
    class TypeCheckerVisitor: IVisitor
    {
        public IList<QLException> Exceptions { get; private set; }

        public TypeCheckerVisitor()
        {
            Exceptions = new List<QLException>();
        }

        public void Visit(Form node)
        {
            return; // nothing to check
        }

        public void Visit(Block node)
        {
            return; // nothing to check
        }

        public void Visit(ControlUnit node)
        {
            return; // nothing to check
        }

        public void Visit(StatementUnit node)
        {
            return; // todo check if referenced variable exists
        }

        public void Visit(QuestionUnit node)
        {
            return; // nothing to check
        }

        public void Visit(Expression node)
        {
            return; // checking is done on children
        }

        public void Visit(EqualsOperator node)
        {
            if (node.Left is Text && node.Right is Text) return;
            if (node.Left is Number && node.Right is Number) return;
            if (node.Left is Yesno && node.Right is Yesno) return;

            Exceptions.Add(new TypeException("Incompatible operands on equality operation", node));
        }

        public void Visit(NotEqualsOperator node)
        {
            if (node.Left is Text && node.Right is Text) return;
            if (node.Left is Number && node.Right is Number) return;
            if (node.Left is Yesno && node.Right is Yesno) return;

            Exceptions.Add(new TypeException("Incompatible operands on inequality operation", node));
        }

        public void Visit(PlusOperator node)
        {
            if (node.Left is Number && node.Right is Number) return;

            Exceptions.Add(new TypeException("Non-number operands on addition operator", node));
        }

        public void Visit(Number node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeException("Number could not be interpreted correctly", node));
        }

        public void Visit(Yesno node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeException("Yes/no value could not be interpreted correctly", node));
        }

        public void Visit(Identifier node)
        {
            return; // nothing to check
        }

        public void Visit(Text node)
        {
            if (node.Value != null) return;

            Exceptions.Add(new TypeException("String value could not be parsed and resulted in null", node));
        }

        public void Visit(ElementBase elementBase)
        {
            Exceptions.Add(new QLException(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }
    }
}
