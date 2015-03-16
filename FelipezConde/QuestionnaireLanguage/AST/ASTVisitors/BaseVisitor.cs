using System;

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

        public virtual T Visit(Nodes.Expressions.Binary.And node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Or node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Equal node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.NotEqual node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.GreaterThan greaterThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.GreaterThanOrEqual greaterThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.LessThan lessThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.LessThanOrEqual lessThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Add add)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Subtract subtract)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Multiply multiply)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Divide divide)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Unary.Negate node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Unary.Priority priority)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Id node)
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

        public virtual T Visit(Nodes.Labels.Label node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expressions.Binary.Binary node) 
        {
            throw new NotImplementedException();
        }

    }
}
