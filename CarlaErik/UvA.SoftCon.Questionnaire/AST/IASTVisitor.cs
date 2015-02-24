using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST
{
    public interface IASTVisitor
    {
        void Visit(Form form);
        void Visit(BinaryExpression binaryExpression);
        void Visit(Identifier identifier);
        void Visit(BooleanLiteral literal);
        void Visit(IntegerLiteral literal);
        void Visit(DoubleLiteral literal);
        void Visit(StringLiteral literal);
        void Visit(Question question);
        void Visit(Declaration declaration);
        void Visit(Assignment assignment);
        void Visit(IfStatement ifStatement);
    }
}
