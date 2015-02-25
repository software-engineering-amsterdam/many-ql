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
        public virtual void Visit(Form form)
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

        public void Visit(Add add)
        {
            VisitBinaryExpression(add);
        }

        public void Visit(And and)
        {
            VisitBinaryExpression(and);
        }

        public void Visit(Divide divide)
        {
            VisitBinaryExpression(divide);
        }

        public void Visit(EqualTo equalTo)
        {
            VisitBinaryExpression(equalTo);
        }

        public void Visit(GreaterThan greaterThan)
        {
            VisitBinaryExpression(greaterThan);
        }

        public void Visit(GreaterThanOrEqualTo greaterThanOrEqualTo)
        {
            VisitBinaryExpression(greaterThanOrEqualTo);
        }

        public void Visit(LessThan lessThan)
        {
            VisitBinaryExpression(lessThan);
        }

        public void Visit(LessThanOrEqualTo lessThanOrEqualTo)
        {
            VisitBinaryExpression(lessThanOrEqualTo);
        }

        public void Visit(Multiply multiply)
        {
            VisitBinaryExpression(multiply);
        }

        public void Visit(NotEqualTo notEqualTo)
        {
            VisitBinaryExpression(notEqualTo);
        }

        public void Visit(Or or)
        {
            VisitBinaryExpression(or);
        }

        public void Visit(Substract substract)
        {
            VisitBinaryExpression(substract);
        }

        public void Visit(Negation negation)
        {
            VisitUnaryExpression(negation);
        }

        public void Visit(Increment increment)
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
}
