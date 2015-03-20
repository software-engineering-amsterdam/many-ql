using AST.Nodes;
using AST.Nodes.Expressions.Binaries;
using AST.Nodes.Expressions.Unaries;
using Evaluation.Values;
using AST.Nodes.Expressions;
using Literals = AST.Nodes.Literals;
using AST.VisitorInterfaces;

namespace Evaluation
{
    public class Evaluator : IExpressionVisitor<Value>
    {
        private readonly SymbolTable symbolTable;
        public Evaluator(SymbolTable symbolTable)
        {
            this.symbolTable = symbolTable;
        }

        #region Operations
        public Value Evaluate(Expression expression)
        {
            return expression.Accept(this);
        }
        #endregion
        
        #region Comparison
        public Value Visit(And node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolAnd((dynamic)right);
        }
        public Value Visit(Or node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolOr((dynamic)right);

        }
        public  Value Visit(Equal node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolEqual((dynamic)right);
        }
        public  Value Visit(NotEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolNotEqual((dynamic)right);
        }
        public  Value Visit(GreaterThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Greater((dynamic)right);
        }
        public  Value Visit(GreaterThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.GreaterEqual((dynamic)right);
        }
        public  Value Visit(LessThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Less((dynamic)right);
        }
        public  Value Visit(LessThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.LessEqual((dynamic)right);
        }
        #endregion

        #region Unary Expressions
        public  Value Visit(Negate node)
        {

            Value value = node.Accept(this);
            return value.Negate();
        }
        public  Value Visit(Priority node)
        {
            return node.GetChildExpression().Accept(this);
        }
        #endregion

        #region Arithmetic

        public  Value Visit(Add node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Add((dynamic)right);
        }

        public  Value Visit(Subtract node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Substract((dynamic)right);
        }

        public  Value Visit(Multiply node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Multiply((dynamic)right);
        }

        public  Value Visit(Divide node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Divide((dynamic)right);
        }


        #endregion

        #region Values
        public  Value Visit(Literals.Bool node)
        {
            return new Bool(node.GetValue());
        }

        public  Value Visit(Literals.Int node)
        {
            return new Int(node.GetValue());
        }

        public  Value Visit(Literals.String node)
        {
            return new String(node.GetValue());
        }
        #endregion

        public Value Visit(Id node)
        {
            return symbolTable.GetValue(node);
        }

        public Value visit(Id node)
        {
            throw new System.NotImplementedException();
        }
    }
}
