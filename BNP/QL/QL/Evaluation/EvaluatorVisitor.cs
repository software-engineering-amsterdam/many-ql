using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Evaluation
{
    public class EvaluatorVisitor : IVisitor
    {
        public IList<QLException> Exceptions { get; private set; }
        Dictionary<string, IVisitable> _references;

        public EvaluatorVisitor()
        {
            Exceptions = new List<QLException>();
            _references = new Dictionary<string, IVisitable>();
        }

        public void Visit(Form node)
        {

        }
        public void Visit(Block node)
        {

        }
        public void Visit(ControlUnit node)
        {

        }

        public void Visit(StatementUnit node)
        {


        }
        public void Visit(QuestionUnit node) { }
        public void Visit(Expression node) { }
        public void Visit(EqualsOperator node) { }
        public void Visit(NotEqualsOperator node) { }
        public void Visit(PlusOperator node) { }

        public void Visit(Number node) { }

        public void Visit(Yesno node) { }

        public void Visit(Identifier node) { }

        public void Visit(Text node) { }

        public void Visit(ElementBase node)
        {
            throw new QLException("Not implemented: " + node.GetType().ToString());
        }
    }
}
