using System;
using System.Collections.Generic;
using QL.AST;
using QL.AST.Nodes;
using QL.AST.Nodes.Branches;
using QL.AST.Nodes.Branches.Operators;
using QL.AST.Nodes.Terminals;
using QL.Exceptions;
using QL.Exceptions.Errors;
using QL.Exceptions.Warnings;
using System.Linq;

namespace QL.Hollywood.DataHandlers.TypeChecking
{
    public class TypeCheckerVisitor: IVisitor
    {
        public readonly IDictionary<Identifier, Type> TypeReference;
        public IList<QLBaseException> Exceptions { get; private set; }
        
        public TypeCheckerVisitor(IDictionary<Identifier, Type> typeReference, IList<QLBaseException> exceptions)
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
            node.Block.Accept(this);
        }

        public void Visit(Block node)
        {
            foreach (ElementBase child in node.Children)
            {
                child.Accept(this);
            }
        }

        public void Visit(ControlUnit node)
        {
            node.Expression.Accept(this);

            if (node.ConditionTrueBlock!=null)
            {
                node.ConditionTrueBlock.Accept(this);
            }
            if (node.ConditionFalseBlock!=null)
            {
                node.ConditionFalseBlock.Accept(this);
            }

        }

        public void Visit(StatementUnit node)
        {
            node.Expression.Accept(this);

            DeclareNewVariable(node.Identifier, node.DataType.GetReturnType());

            if (node.DataType.GetReturnType() != DetermineType(node.Expression))
            {
                Exceptions.Add(new TypeCheckerError(String.Format(
                "Expression inside the statement declared as {0}, but resolves into type {1} instead",
                node.DataType.GetReturnType(), 
                DetermineType(node.Expression))));
            }

        }

        public void Visit(QuestionUnit node)
        {
            DeclareNewVariable(node.Identifier, node.DataType.GetReturnType());

        }

        public void Visit(Expression node)
        {
            node.Child.Accept(this);
        }
        #endregion
        void _visit_binary(BinaryTreeElementBase node)
        {
            node.Left.Accept(this);
            node.Right.Accept(this);
        }

        void operandsShouldBeTheSame<T>(T node) where T:BinaryTreeElementBase, IOperator
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError(String.Format("Incompatible operands on operation:{0} and {1}", DetermineType((dynamic)node.Left), DetermineType((dynamic)node.Right)), node));
            }
        }

        void typeRestrictionOnOperands<T>(T node, params Type[] restrictedToTypes) where T : BinaryTreeElementBase, IOperator
        {
            if (!restrictedToTypes.Contains((Type)DetermineType((dynamic)node.Left)))
            {
                Exceptions.Add(new TypeCheckerError("Type not permitted on the left side of the operator", node));
            }
            if (!restrictedToTypes.Contains((Type)DetermineType((dynamic)node.Right)))
            {
                Exceptions.Add(new TypeCheckerError("Type not permitted on the right side of the operator", node));

            }

        }
        
        #region Operators
        public void Visit(EqualsOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            
            
        }

        public void Visit(NotEqualsOperator node)
        {
            _visit_binary(node);

            operandsShouldBeTheSame(node);            

        }

        public void Visit(GreaterThanOperator node)
        {
            _visit_binary(node);

            operandsShouldBeTheSame(node);            

        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            

        }

        public void Visit(LessThanOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            

        }

        public void Visit(LessThanEqualToOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            

        }

        public void Visit(MultiplicationOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);
            typeRestrictionOnOperands(node, new Number().GetType());

        }

        public void Visit(DivisionOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            

        }

        public void Visit(PlusOperator node)
        {
            _visit_binary(node);            
            operandsShouldBeTheSame(node);            
            typeRestrictionOnOperands(node, new Number().GetType(), new Text().GetType() );
        }

        public void Visit(MinusOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);
            typeRestrictionOnOperands(node, new Number().GetType() );
  
        }

        public void Visit(AndOperator node)
        {
            _visit_binary(node);
            operandsShouldBeTheSame(node);            

        }

        public void Visit(OrOperator node)
        {
            _visit_binary(node);

            operandsShouldBeTheSame(node);            

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
        }
        #endregion

        public void Visit(ElementBase elementBase)
        {
            Exceptions.Add(new QLError(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }

        # region Type distinction
        
        Type DetermineType(Identifier i)
        { 
            if (TypeReference.ContainsKey(i))
            {
                return TypeReference[i];
            }
            else
            {
                throw new QLError("Undeclared variable: "+i.Value);
            }
        }

        Type DetermineType(ITypeInferred i)
        {
            return DetermineType((dynamic)i.GetTypeInferableChild());
        }

        Type DetermineType(ITypeStatic i)
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
