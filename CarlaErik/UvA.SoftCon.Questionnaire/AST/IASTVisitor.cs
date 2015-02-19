using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST
{
    public interface IASTVisitor
    {
        void Visit(Questionnaire node);
        void Visit(BinaryExpression node);
        void Visit(Identifier node);
        void Visit<T>(Literal<T> node);
        void Visit(Question node);
        void Visit(Declaration node);
        void Visit(Assignment node);
        void Visit(IfStatement node);
    }
}
