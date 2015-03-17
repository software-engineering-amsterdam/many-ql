using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QL.Visitors
{
    public interface IVisitor
    {
        IList<QLBaseException> Exceptions { get; }

        void Visit(Form node);
        void Visit(Block node);
        void Visit(ControlUnit node);
        void Visit(StatementUnit node);
        void Visit(QuestionUnit node);
        void Visit(Expression node);
        
        void Visit(EqualsOperator node);
        void Visit(NotEqualsOperator node);
        void Visit(GreaterThanOperator node);
        void Visit(GreaterThanEqualToOperator node);
        void Visit(LessThanOperator node);
        void Visit(LessThanEqualToOperator node);
        void Visit(MultiplicationOperator node);
        void Visit(DivisionOperator node);
        void Visit(PlusOperator node);
        void Visit(MinusOperator node);
        void Visit(AndOperator node);
        void Visit(OrOperator node);

        void Visit(Yesno node);
        void Visit(Number node);
        void Visit(Text node);
        void Visit(Identifier node);
        
        // Fallback visitor
        void Visit(ElementBase elementBase);
    }
}
