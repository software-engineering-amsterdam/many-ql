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
    public class TypeCheckerVisitor : IVisitor
    {
        public ReferenceTables ReferenceTables { get; private set; }
        public IList<QLBaseException> Exceptions { get; private set; }
        
        public TypeCheckerVisitor(ReferenceTables referenceTables, IList<QLBaseException> exceptions)
        {
            ReferenceTables = referenceTables;
            Exceptions = exceptions;
        }

        private void DeclareNewVariable(Identifier key, IResolvable value)
        {
            if (ReferenceTables.ContainsIdentifier(key))
            {
                Exceptions.Add(new RedeclaredVariableWarning("Redeclared variable detected: " + key, key.SourceLocation));
            }
            ReferenceTables.SetReference(key, value);
        }

        #region Type assurance methods
        private void CheckOperandsAreOfSameType(BinaryTreeElementBase node)
        {
            if (DetermineType((dynamic)node.Left) != DetermineType((dynamic)node.Right))
            {
                Exceptions.Add(new TypeCheckerError(String.Format("Incompatible operands on operation: {0} and {1}", DetermineType((dynamic)node.Left), DetermineType((dynamic)node.Right)), node));
            }
        }

        private void CheckOperandsRestrictedToTypes(BinaryTreeElementBase node, params Type[] restrictedTypes)
        {
            if (!restrictedTypes.Contains((Type)DetermineType((dynamic)node.Left)))
            {
                Exceptions.Add(new TypeCheckerError("Type not permitted on the left side of the operator", node));
            }

            if (!restrictedTypes.Contains((Type)DetermineType((dynamic)node.Right)))
            {
                Exceptions.Add(new TypeCheckerError("Type not permitted on the right side of the operator", node));
            }
        }
        #endregion

        #region Regular element visitors
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

            if (node.ConditionTrueBlock != null)
            {
                node.ConditionTrueBlock.Accept(this);
            }

            if (node.ConditionFalseBlock != null)
            {
                node.ConditionFalseBlock.Accept(this);
            }
        }

        public void Visit(StatementUnit node)
        {
            node.Expression.Accept(this);

            DeclareNewVariable(node.Identifier, node.DataType);

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
            DeclareNewVariable(node.Identifier, node.DataType);
        }

        public void Visit(Expression node)
        {
            node.Child.Accept(this);
        }

        private void VisitBinary(BinaryTreeElementBase node)
        {
            node.Left.Accept(this);
            node.Right.Accept(this);
        }
        #endregion
        
        #region Operators
        public void Visit(EqualsOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(NotEqualsOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(GreaterThanOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(GreaterThanEqualToOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(LessThanOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(LessThanEqualToOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(MultiplicationOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
            CheckOperandsRestrictedToTypes(node, new Number().GetType());
        }

        public void Visit(DivisionOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(PlusOperator node)
        {
            VisitBinary(node);            
            CheckOperandsAreOfSameType(node);            
            CheckOperandsRestrictedToTypes(node, new Number().GetType(), new Text().GetType());
        }

        public void Visit(MinusOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
            CheckOperandsRestrictedToTypes(node, new Number().GetType());
        }

        public void Visit(AndOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
        }

        public void Visit(OrOperator node)
        {
            VisitBinary(node);
            CheckOperandsAreOfSameType(node);
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

        #region Fallback
        public void Visit(ElementBase elementBase)
        {
            Exceptions.Add(new QLError(string.Format("Type checker was called for {0} but is not implemented", elementBase.GetType().Name)));
        }
        #endregion

        # region Type distinction
        Type DetermineType(Identifier identifier)
        {
            if (ReferenceTables.ContainsIdentifier(identifier))
            {
                return ReferenceTables.GetTypeByIdentifier(identifier);
            }
            throw new QLError("Undeclared variable: " + identifier.Value);
        }

        Type DetermineType(IInferredReturnType type)
        {
            return DetermineType((dynamic)type.GetTypeInferableChild());
        }

        Type DetermineType(IStaticReturnType type)
        {
            return type.GetReturnType();
        }
        
        Type DetermineType(object type)
        {
            throw new TypeCheckerError("Cannot resolve type:" + type.GetType());
        }
        # endregion
    }
}
