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
        void Visit(Questionnaire context);
        void Visit(BinaryExpression context);
        void Visit(Identifier context);
        void Visit<T>(Literal<T> context);
        void Visit(Question context);
        void Visit(Declaration context);
        void Visit(IfStatement context);
    }
}
