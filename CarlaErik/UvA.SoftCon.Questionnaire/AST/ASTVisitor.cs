using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model;
using UvA.SoftCon.Questionnaire.AST.Model.Expressions;
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

        public virtual void Visit(BinaryExpression binaryExpression)
        {
            binaryExpression.Left.Accept(this);
            binaryExpression.Right.Accept(this);
        }

        public virtual void Visit(Identifier identifier)
        {
        }

        public virtual void Visit(BooleanLiteral literal)
        {
        }

        public virtual void Visit(DoubleLiteral literal)
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
    }
}
