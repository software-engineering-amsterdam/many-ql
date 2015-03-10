using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST.Visitors
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

        public virtual T Visit(Nodes.Expression.Binary.And node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Or node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Equal node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.NotEqual node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.GreaterThan greaterThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.GreaterThanOrEqual greaterThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.LessThan lessThan)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.LessThanOrEqual lessThanOrEqual)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Add add)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Subtract subtract)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Multiply multiply)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Binary.Divide divide)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Unary.Negate node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Unary.Priority priority)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Container node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Expression.Id node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Values.Bool node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Values.Int node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Values.String node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Values.Unknown node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Labels.Label node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Computation.Id node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Computation.Value node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Computation.Expression node)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.TypeName.TypeName typeName)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Interfaces.IBinary binaryExpression)
        {
            throw new NotImplementedException();
        }

        public virtual T Visit(Nodes.Interfaces.IUnary unaryExpression)
        {
            throw new NotImplementedException();
        }

        public T Visit(Nodes.Values.Undefined undefined)
        {
            throw new NotImplementedException();
        }


        public T Visit(Nodes.Interfaces.IASTNode node)
        {
            throw new NotImplementedException();
        }
    }
}
