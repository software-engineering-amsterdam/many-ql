using System;
using Binary = AST.Nodes.Expressions.Binary;
using Unary = AST.Nodes.Expressions.Unary;
using AST.Nodes.Expressions;

namespace AST.ASTVisitors
{
    public abstract class BaseVisitor<T> : IVisitor<T>
    {
        public virtual T Visit(Nodes.Form node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.FormObject.Question node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.FormObject.Conditional conditional)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.And node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Or node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Equal node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.NotEqual node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.GreaterThan greaterThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.GreaterThanOrEqual greaterThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.LessThan lessThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.LessThanOrEqual lessThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Add add)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Subtract subtract)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Multiply multiply)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Binary.Divide divide)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Unary.Negate node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Unary.Priority priority)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Id node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Literals.Bool node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Literals.Int node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Literals.String node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(BaseBinary node) 
        {
            throw new NotImplementedException();
        }

    }
}
