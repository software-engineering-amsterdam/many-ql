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
    /// <summary>
    /// Provides a default top-down traversal visitor for the questionnaire AST.
    /// </summary>
    public abstract class QLVisitor<T> : IQLVisitor<T>
    {
        public virtual T Visit(QuestionForm form)
        {
            foreach (var statement in form.Statements)
            {
                statement.Accept<T>(this);
            }
            return default(T);
        }

        public virtual T Visit(Identifier identifier)
        {
            return default(T);
        }

        public virtual T Visit(BooleanLiteral literal)
        {
            return default(T);
        }

        public virtual T Visit(IntegerLiteral literal)
        {
            return default(T);
        }

        public virtual T Visit(StringLiteral literal)
        {
            return default(T);
        }

        public virtual T Visit(DateLiteral literal)
        {
            return default(T);
        }

        public virtual T Visit(BooleanQuestion question)
        {
            return VisitQuestion(question);
        }

        public virtual T Visit(DateQuestion question)
        {
            return VisitQuestion(question);
        }

        public virtual T Visit(IntegerQuestion question)
        {
            return VisitQuestion(question);
        }

        public virtual T Visit(StringQuestion question)
        {
            return VisitQuestion(question);
        }

        public virtual T Visit(IfStatement ifStatement)
        {
            ifStatement.If.Accept(this);
            foreach (var statement in ifStatement.Then)
            {
                statement.Accept(this);
            }
            foreach (var statement in ifStatement.Else)
            {
                statement.Accept(this);
            }
            return default(T);
        }

        public virtual T Visit(Add add)
        {
            return VisitBinaryExpression(add);
        }

        public virtual T Visit(And and)
        {
            return VisitBinaryExpression(and);
        }

        public virtual T Visit(Divide divide)
        {
            return VisitBinaryExpression(divide);
        }

        public virtual T Visit(EqualTo equalTo)
        {
            return VisitBinaryExpression(equalTo);
        }

        public virtual T Visit(GreaterThan greaterThan)
        {
            return VisitBinaryExpression(greaterThan);
        }

        public virtual T Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            return VisitBinaryExpression(greaterThanOrEqualTo);
        }

        public virtual T Visit(LessThan lessThan)
        {
            return VisitBinaryExpression(lessThan);
        }

        public virtual T Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            return VisitBinaryExpression(lessThanOrEqualTo);
        }

        public virtual T Visit(Multiply multiply)
        {
            return VisitBinaryExpression(multiply);
        }

        public virtual T Visit(NotEqualTo notEqualTo)
        {
            return VisitBinaryExpression(notEqualTo);
        }

        public virtual T Visit(Or or)
        {
            return VisitBinaryExpression(or);
        }

        public virtual T Visit(Substract substract)
        {
            return VisitBinaryExpression(substract);
        }

        public virtual T Visit(Negation negation)
        {
            return VisitUnaryExpression(negation);
        }

        private T VisitQuestion(Question question)
        {
            question.Id.Accept(this);

            if (question.Expression != null)
            {
                question.Expression.Accept(this);
            }

            return default(T);
        }

        private T VisitBinaryExpression(BinaryExpression expression)
        {
            expression.Left.Accept(this);
            expression.Right.Accept(this);
            return default(T);
        }

        private T VisitUnaryExpression(UnaryExpression expression)
        {
            expression.Operand.Accept(this);
            return default(T);
        }
    }
}
