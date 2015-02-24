using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST
{
    public interface IASTVisitor
    {
        void Visit(Form form);
        void Visit(Identifier identifier);
        void Visit(BooleanLiteral literal);
        void Visit(IntegerLiteral literal);
        void Visit(StringLiteral literal);
        void Visit(Question question);
        void Visit(Declaration declaration);
        void Visit(Assignment assignment);
        void Visit(IfStatement ifStatement);

        void Visit(Add add);
        void Visit(And and);
        void Visit(Divide divide);
        void Visit(EqualTo equalTo);
        void Visit(GreaterThan greaterThan);
        void Visit(GreaterThanOrEqualTo greaterThanOrEqualTo);
        void Visit(LessThan lessThan);
        void Visit(LessThanOrEqualTo lessThanOrEqualTo);
        void Visit(Multiply multiply);
        void Visit(NotEqualTo notEqualTo);
        void Visit(Or or);
        void Visit(Substract substract);
        void Visit(Negation negation);
        void Visit(Increment increment);
    }
}
