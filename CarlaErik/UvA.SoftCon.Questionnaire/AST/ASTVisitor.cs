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
    public abstract class ASTVisitor : IASTVisitor
    {
        public virtual void Visit(QuestionForm form)
        {
            foreach (var statement in form.Statements)
            {
                statement.Accept(this);
            }
        }

        public virtual void Visit(Identifier identifier)
        {
        }

        public virtual void Visit(BooleanLiteral literal)
        {
        }

        public virtual void Visit(IntegerLiteral literal)
        {
        }

        public virtual void Visit(StringLiteral literal)
        {
        }

        public virtual void Visit(Question question)
        {
            question.Id.Accept(this);

            if (question.Expression != null)
            {
                question.Expression.Accept(this);
            }
        }

        public virtual void Visit(Declaration declaration)
        {
            declaration.Id.Accept(this);

            if (declaration.Initialization != null)
            {
                declaration.Initialization.Accept(this);
            }
        }

        public virtual void Visit(Assignment assignment)
        {
            assignment.Variable.Accept(this);
            assignment.Expression.Accept(this);
        }

        public virtual void Visit(IfStatement ifStatement)
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
        }

        public virtual void Visit(Add add)
        {
            VisitBinaryExpression(add);
        }

        public virtual void Visit(And and)
        {
            VisitBinaryExpression(and);
        }

        public virtual void Visit(Divide divide)
        {
            VisitBinaryExpression(divide);
        }

        public virtual void Visit(EqualTo equalTo)
        {
            VisitBinaryExpression(equalTo);
        }

        public virtual void Visit(GreaterThan greaterThan)
        {
            VisitBinaryExpression(greaterThan);
        }

        public virtual void Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            VisitBinaryExpression(greaterThanOrEqualTo);
        }

        public virtual void Visit(LessThan lessThan)
        {
            VisitBinaryExpression(lessThan);
        }

        public virtual void Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            VisitBinaryExpression(lessThanOrEqualTo);
        }

        public virtual void Visit(Multiply multiply)
        {
            VisitBinaryExpression(multiply);
        }

        public virtual void Visit(NotEqualTo notEqualTo)
        {
            VisitBinaryExpression(notEqualTo);
        }

        public virtual void Visit(Or or)
        {
            VisitBinaryExpression(or);
        }

        public virtual void Visit(Substract substract)
        {
            VisitBinaryExpression(substract);
        }

        public virtual void Visit(Negation negation)
        {
            VisitUnaryExpression(negation);
        }

        public virtual void Visit(Increment increment)
        {
            VisitUnaryExpression(increment);
        }

        private void VisitBinaryExpression(BinaryExpression expression)
        {
            expression.Left.Accept(this);
            expression.Right.Accept(this);
        }

        private void VisitUnaryExpression(UnaryExpression expression)
        {
            expression.Operand.Accept(this);
        }
    }

    public abstract class ASTVisitor<T> : IASTVisitor<T>
    {
        public virtual T Visit(QuestionForm form)
        {
            foreach (var statement in form.Statements)
            {
                statement.Accept(this);
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

        public virtual T Visit(Question question)
        {
            question.Id.Accept(this);

            if (question.Expression != null)
            {
                question.Expression.Accept(this);
            }

            return default(T);
        }

        public virtual T Visit(Declaration declaration)
        {
            declaration.Id.Accept(this);
            if (declaration.Initialization != null)
            {
                declaration.Initialization.Accept(this);
            }
            return default(T);
        }

        public virtual T Visit(Assignment assignment)
        {
            assignment.Variable.Accept(this);
            assignment.Expression.Accept(this);
            return default(T);
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

        public virtual T Visit(Increment increment)
        {
            return VisitUnaryExpression(increment);
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
