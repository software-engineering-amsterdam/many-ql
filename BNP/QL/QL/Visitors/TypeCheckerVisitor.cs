using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Exceptions.Warnings;
using QL.Model;
using QL.Model.Operators;

using QL.Model.Terminals;

namespace QL.Visitors
{
    public class TypeCheckerVisitor: IVisitor
    {
        public readonly IDictionary<Identifier, Type> TypeReference;
        public IList<QLException> Exceptions { get; private set; }
        
        public TypeCheckerVisitor(IDictionary<Identifier, Type> typeReference, IList<QLException> exceptions)
        {
            TypeReference = typeReference;
            Exceptions = exceptions;
        }

        private void DeclareNewVariable(Identifier key, Type value)
        {
            if (TypeReference.ContainsKey(key))
            {
                Exceptions.Add(new RedeclaredVariableWarning("redeclared variable detected: " + key, key.SourceLocation));
            }
            TypeReference[key] = value;
        }

        #region Regular elements
        public void Visit(Form node)
        {
            node.Block.AcceptSingle(this);
        }

        public void Visit(Block node)
        {
            foreach (ElementBase child in node.Children)
            {
                child.AcceptSingle(this);
            }
        }

        public void Visit(ControlUnit node)
        {
            node.Expression.AcceptSingle(this);

            if (node.ConditionTrueBlock!=null)
            {
                node.ConditionTrueBlock.AcceptSingle(this);
            }
            if (node.ConditionTrueBlock!=null)
            {
                node.ConditionFalseBlock.AcceptSingle(this);
            }

        }

        public void Visit(StatementUnit node)
        {
            node.Expression.AcceptSingle(this);

            DeclareNewVariable(node.Identifier, DetermineType((dynamic)node.DataType));

            if (TypeReference[node.Identifier]!=DetermineType((dynamic)node.Expression)){
                Exceptions.Add(new TypeCheckerError(String.Format(
                "Expression inside the statement declared as {0}, but resolves into type {1} instead", 
                TypeReference[node.Identifier], 
                DetermineType((dynamic)node.Expression))));
            }

        }

        public void Visit(QuestionUnit node)
        {
            DeclareNewVariable(node.Identifier, DetermineType((dynamic)node.DataType));

        }

        public void Visit(Expression node)
        {
            node.Child.AcceptSingle(this);
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);

            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError(String.Format("Incompatible operands on equality operation:{0} and {1}", DetermineType((dynamic)node.Left), DetermineType((dynamic)node.Right)), node));
            }
        }

        public void Visit(NotEqualsOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on inequality operation", node));
            }
        }

        public void Visit(GreaterThanOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on greater-than operation", node));
            }
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on greater-than-or-equal-to operation", node));
            }
        }

        public void Visit(LessThanOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on less-than operation", node));
            }
        }

        public void Visit(LessThanEqualToOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on less-than-or-equal-to operation", node));
            }
        }

        public void Visit(MultiplicationOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on multiplication operation", node));
            }
            if (DetermineType((dynamic)node.Left) !=(new Number()).GetType())
            {
                Exceptions.Add(new TypeCheckerError("Non-number operands on the left side of the  multiplication operator", node));
            }
            if (DetermineType((dynamic)node.Right) !=(new Number()).GetType())
            {
                Exceptions.Add(new TypeCheckerError("Non-number operands on the right side of the multiplication operator", node));
            }

        }

        public void Visit(DivisionOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Non-number operands on division operator", node));
            }
        }

        public void Visit(PlusOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            ICollection<Type> ALLOWED_TYPES = new List<Type>{ new Number().GetType(), new Text().GetType() };//this could be abstracted
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on operator +", node));
            }
            if (!ALLOWED_TYPES.Contains(DetermineType((dynamic)node.Left)))
            {
                Exceptions.Add(new TypeCheckerError("Usage of this operator is not implemented on these elements", node));
            }           
            
        }

        public void Visit(MinusOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            ICollection<Type> ALLOWED_TYPES = new List<Type> { new Number().GetType() };//this could be abstracted
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Incompatible operands on operator -", node));
            }
            if (!ALLOWED_TYPES.Contains(DetermineType((dynamic)node.Left)))
            {
                Exceptions.Add(new TypeCheckerError("Usage of this operator is not implemented on these elements", node));
            }  
        }

        public void Visit(AndOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Non-number operands on AND operator", node));

            }
        }

        public void Visit(OrOperator node)
        {
            node.Left.AcceptSingle(this);
            node.Right.AcceptSingle(this);
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError("Non-number operands on OR operator", node));
            }
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeCheckerError("Number could not be interpreted correctly", node));
        }

        public void Visit(Yesno node)
        {
            if (node.Value.HasValue) return;

            Exceptions.Add(new TypeCheckerError("Yes/no value could not be interpreted correctly", node));
        }

        public void Visit(Text node)
        {
            if (node.Value != null) return;

            Exceptions.Add(new TypeCheckerError("String value could not be parsed and resulted in null", node));
        }

        public void Visit(Identifier node)
        {
            return; // nothing to check
        }
        #endregion

        public void Visit(ElementBase elementBase)
        {
            Exceptions.Add(new QLError(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }

        # region Type distinction
        
        Type DetermineType(Identifier i)
        { 
            if (TypeReference.ContainsKey(i)){
                return TypeReference[i];}
            else{
                //This error is thrown up because it prevents from further type checking
                throw new QLError("Undeclared variable: "+i.Value);
            }
        }

        Type DetermineType(ITypeResolvableByChildren i)
        {
            return DetermineType((dynamic)i.Children[0]);
        }

        Type DetermineType(ITypeResolvableDirectly i)
        {
            return i.GetReturnType();
        }

        
        Type DetermineType(object other)
        {
            throw new TypeCheckerError("Cannot resolve type:"+other.GetType().ToString());
        }
        # endregion
    }
}
