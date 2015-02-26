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
    public interface IASTVisitor<T>
    {
        T Visit(Form form);
        T Visit(Identifier identifier);
        T Visit(BooleanLiteral literal);
        T Visit(IntegerLiteral literal);
        T Visit(StringLiteral literal);
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
