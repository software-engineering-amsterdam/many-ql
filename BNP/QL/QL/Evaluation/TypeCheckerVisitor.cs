using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Model;
using QL.Model.Operators;

using QL.Model.Terminals;

namespace QL.Evaluation
{
    class TypeCheckerVisitor: IVisitor
    {
        Dictionary<Identifier, ITypeResolvable> TypeReferenceDictionary;

        public IList<QLException> Exceptions { get; private set; }

        public TypeCheckerVisitor()
        {
            Exceptions = new List<QLException>();
        }

        #region Regular elements
        public void Visit(Form node)
        {
            return; // nothing to check
        }

        public void Visit(Block node)
        {
            return; // nothing to check
        }

        public void Visit(ControlUnit node)
        {
            return; // nothing to check
        }

        public void Visit(StatementUnit node)
        {
            return; // todo check if referenced variable exists
        }

        public void Visit(QuestionUnit node)
        {
            return; // nothing to check
        }

        public void Visit(Expression node)
        {
            return; // checking is done on children
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeException("Incompatible operands on equality operation", node));
            }
        }

        public void Visit(NotEqualsOperator node)
        {
            if (node.Left.GetReturnType() == node.Right.GetReturnType()) return;

            Exceptions.Add(new TypeException("Incompatible operands on inequality operation", node));
        }

        public void Visit(GreaterThanOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Incompatible operands on greater-than operation", node));
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Incompatible operands on greater-than-or-equal-to operation", node));
        }

        public void Visit(LessThanOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Incompatible operands on less-than operation", node));
        }

        public void Visit(LessThanEqualToOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Incompatible operands on less-than-or-equal-to operation", node));
        }

        public void Visit(MultiplicationOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on multiplication operator", node));
        }

        public void Visit(DivisionOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on division operator", node));
        }

        public void Visit(PlusOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on addition operator", node));
        }

        public void Visit(MinusOperator node)
        {
            Type desiredType = (new Number()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on subtraction operator", node));
        }

        public void Visit(AndOperator node)
        {
            Type desiredType = (new Yesno()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on AND operator", node));
        }

        public void Visit(OrOperator node)
        {
            Type desiredType = (new Yesno()).GetReturnType();
            if (node.Left.GetReturnType() == desiredType && node.Right.GetReturnType() == desiredType) return;

            Exceptions.Add(new TypeException("Non-number operands on OR operator", node));
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeException("Number could not be interpreted correctly", node));
        }

        public void Visit(Yesno node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeException("Yes/no value could not be interpreted correctly", node));
        }

        public void Visit(Text node)
        {
            if (node.Value != null) return;

            Exceptions.Add(new TypeException("String value could not be parsed and resulted in null", node));
        }

        public void Visit(Identifier node)
        {
            return; // nothing to check
        }
        #endregion

        public void Visit(ElementBase elementBase)
        {
            Exceptions.Add(new QLException(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }

        # region Type distinction
        Type DetermineType(Type type)
        {
            return type;
        }
        Type DetermineType(Identifier i)
        {
            return DetermineType(TypeReferenceDictionary[i]);
        }
        
        Type DetermineType(ITypeResolvable i)
        {
            return DetermineType(i.GetReturnType());
        }

        Type DetermineType(object other)
        {
            throw new TypeException("Cannot resolve type:"+other.GetType().ToString());
        }
# endregion
    }
}
