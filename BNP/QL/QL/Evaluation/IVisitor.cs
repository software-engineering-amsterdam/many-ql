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
         void visit(Form node);

         void visit(Block node);
         void visit(ControlUnit node);
         void visit(StatementUnit node);
         void visit(QuestionUnit node);
         void visit(Expression node);
         void visit(EqualsOperator node);
         void visit(NotEqualsOperator node);
         void visit(PlusOperator node);
          void visit(Number node);

          void visit(Yesno node);
         void visit(Identifier node);

          void visit(Text node);


         void visit(ElementBase elementBase);
    }
}
