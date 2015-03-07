using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL
{
    public interface IQLVisitor
    {
        void Visit(QuestionForm form);
        void Visit(Identifier identifier);
        void Visit(BooleanLiteral literal);
        void Visit(IntegerLiteral literal);
        void Visit(StringLiteral literal);
        void Visit(DateLiteral literal);
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

    public interface IQLVisitor<T>
    {
        T Visit(QuestionForm form);
        T Visit(Identifier identifier);
        T Visit(BooleanLiteral literal);
        T Visit(IntegerLiteral literal);
        T Visit(StringLiteral literal);
        T Visit(DateLiteral literal);
        T Visit(Question question);
        T Visit(Declaration declaration);
        T Visit(Assignment assignment);
        T Visit(IfStatement ifStatement);

        T Visit(Add add);
        T Visit(And and);
        T Visit(Divide divide);
        T Visit(EqualTo equalTo);
        T Visit(GreaterThan greaterThan);
        T Visit(GreaterThanOrEqualTo greaterThanOrEqualTo);
        T Visit(LessThan lessThan);
        T Visit(LessThanOrEqualTo lessThanOrEqualTo);
        T Visit(Multiply multiply);
        T Visit(NotEqualTo notEqualTo);
        T Visit(Or or);
        T Visit(Substract substract);
        T Visit(Negation negation);
        T Visit(Increment increment);
    }
}
