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
        public virtual void Visit(Form node)
        {
            foreach (var statement in node.Statements)
            {
                statement.Accept(this);
            }
        }

        public virtual void Visit(BinaryExpression node)
        {
            node.Left.Accept(this);
            node.Right.Accept(this);
        }

        public virtual void Visit(Identifier node)
        {
        }

        public virtual void Visit<T>(Literal<T> node)
        {
        }

        public virtual void Visit(Question node)
        {
            node.Id.Accept(this);
        }

        public virtual void Visit(Declaration node)
        {
            node.Id.Accept(this);
            if (node.Initialization != null)
            {
                node.Initialization.Accept(this);
            }
        }

        public virtual void Visit(Assignment node)
        {
            node.Variable.Accept(this);
            node.Expression.Accept(this);
        }

        public virtual void Visit(IfStatement node)
        {
            node.If.Accept(this);
            foreach (var statement in node.Then)
            {
                statement.Accept(this);
            }
            foreach (var statement in node.Else)
            {
                statement.Accept(this);
            }
        }
    }
}
