using UvA.SoftCon.Questionnaire.QL.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.QL
{
    public interface IQuestionFormVisitor<T>
    {
        T Visit(QuestionForm form);
        T Visit(Identifier identifier);
        T Visit(BooleanLiteral literal);
        T Visit(IntegerLiteral literal);
        T Visit(StringLiteral literal);
        T Visit(DateLiteral literal);
        T Visit(BooleanQuestion question);
        T Visit(DateQuestion question);
        T Visit(IntegerQuestion question);
        T Visit(StringQuestion question);
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
    }
}
