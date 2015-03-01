using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QL.Evaluation
{
    public interface IVisitor
    {
        IList<QLException> Exceptions { get; }

        void Visit(Form node);

        void Visit(Block node);
        void Visit(ControlUnit node);
        void Visit(StatementUnit node);
        void Visit(QuestionUnit node);
        void Visit(Expression node);
        void Visit(EqualsOperator node);
        void Visit(NotEqualsOperator node);
        void Visit(PlusOperator node);
        void Visit(Number node);

        void Visit(Yesno node);
        void Visit(Identifier node);

        void Visit(Text node);

        // Fallback visitor
        void Visit(ElementBase elementBase);
    }
}
