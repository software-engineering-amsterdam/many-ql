using AST.Nodes.Expressions;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using AST.VisitorInterfaces;
using Evaluation.Values;
using Literals = AST.Nodes.Literals;
using System;

namespace Evaluation
{
    public class Evaluator : IExpressionVisitor<Value>
    {
        private readonly SymbolTable symbolTable;
        public Evaluator(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;
        }        
        #region Comparison
        public Value Visit(And node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.And(right);
        }
        public Value Visit(Or node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Or(right);

        }
        public Value Visit(Equal node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Equal(right);
        }
        public Value Visit(NotEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.NotEqual(right);
        }
        public Value Visit(GreaterThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Greater(right);
        }
        public Value Visit(GreaterThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.GreaterEqual(right);
        }
        public Value Visit(LessThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Less(right);
        }
        public Value Visit(LessThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.LessEqual(right);
        }
        #endregion

        #region Unary Expressions
        public Value Visit(Negate node)
        {
            Value value = node.GetChildExpression().Accept(this);
            return value.Negate();
        }
        public Value Visit(Priority node)
        {
            return node.GetChildExpression().Accept(this);
        }
        #endregion

        #region Arithmetic
        public Value Visit(Add node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Add(right);
        }
        public Value Visit(Subtract node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Substract(right);
        }
        public Value Visit(Multiply node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Multiply(right);
        }
        public Value Visit(Divide node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Divide(right);
        }

        #endregion

        #region Values
        public Value Visit(Literals.Bool node)
        {
            return new Bool(node.GetValue());
        }

        public Value Visit(Literals.Int node)
        {
            return new Int(node.GetValue());
        }

        public Value Visit(Literals.String node)
        {
            return new Evaluation.Values.String(node.GetValue());
        }
        #endregion

        public Value Visit(Id node)
        {
            return symbolTable.GetValue(node);
        }
    }
}
