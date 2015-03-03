using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Errors;
using QL.Model;
using QL.Model.Operators;

using QL.Model.Terminals;

namespace QL.Evaluation
{
    class TypeCheckerVisitor: IVisitor
    {
        public readonly IDictionary<Identifier, Type> TypeReferenceDictionary;

        public IList<QLError> Errors { get; private set; }

        public TypeCheckerVisitor()
        {
            Errors = new List<QLError>();
            TypeReferenceDictionary = new Dictionary<Identifier, Type>();
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
            TypeReferenceDictionary[node.Identifier]= DetermineType((dynamic)node.DataType);

            return; // todo check if referenced variable exists
        }

        public void Visit(QuestionUnit node)
        {
            TypeReferenceDictionary[node.Identifier] = DetermineType((dynamic)node.DataType);
            return; // nothing to check
        }

        public void Visit(Expression node)
        {
            return; // checking is done on children todo: sure this is the case?
        }
        #endregion

        #region Operators
        public void Visit(EqualsOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on equality operation", node));
            }
        }

        public void Visit(NotEqualsOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on inequality operation", node));
            }
        }

        public void Visit(GreaterThanOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on greater-than operation", node));
            }
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on greater-than-or-equal-to operation", node));
            }
        }

        public void Visit(LessThanOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on less-than operation", node));
            }
        }

        public void Visit(LessThanEqualToOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Incompatible operands on less-than-or-equal-to operation", node));
            }
        }

        public void Visit(MultiplicationOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on multiplication operator", node));
            }
        }

        public void Visit(DivisionOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on division operator", node));
            }
        }

        public void Visit(PlusOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on addition operator", node));
            }
        }

        public void Visit(MinusOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on subtraction operator", node));
            }
        }

        public void Visit(AndOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on AND operator", node));

            }
        }

        public void Visit(OrOperator node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Errors.Add(new TypeError("Non-number operands on OR operator", node));
            }
        }
        #endregion

        #region Terminals
        public void Visit(Number node)
        {
            if (node.Value.HasValue) return;

            Errors.Add(new TypeError("Number could not be interpreted correctly", node));
        }

        public void Visit(Yesno node)
        {
            if (node.Value.HasValue) return;

            Errors.Add(new TypeError("Yes/no value could not be interpreted correctly", node));
        }

        public void Visit(Text node)
        {
            if (node.Value != null) return;

            Errors.Add(new TypeError("String value could not be parsed and resulted in null", node));
        }

        public void Visit(Identifier node)
        {
            return; // nothing to check
        }
        #endregion

        public void Visit(ElementBase elementBase)
        {
            Errors.Add(new QLError(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }

        # region Type distinction
        
        Type DetermineType(Identifier i)
        {
            return TypeReferenceDictionary[i];
        }

        Type DetermineType(ITypeResolvableByChilren i)
        {
            return DetermineType((dynamic)i.Children[0]);
        }

        Type DetermineType(ITypeResolvableDirectly i)
        {
            return i.GetReturnType();
        }

        
        Type DetermineType(object other)
        {
            throw new TypeError("Cannot resolve type:"+other.GetType().ToString());
        }
        # endregion
    }
}
