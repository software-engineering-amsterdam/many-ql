using AST.Nodes;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.Nodes.Interfaces;
using AST.Nodes.Labels;
using Evaluator.Values;
using AST.ASTVisitors;
using Evaluator.Storage;
using AST.Nodes.Expressions;
using Literals = AST.Nodes.Literals;

namespace Evaluation
{
    public class EvaluationManager : BaseVisitor<Value>
    {
        private readonly SymbolTable symbolTable;
        public EvaluationManager(SymbolTable symbolTable)
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
        public override Value Visit(And node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolAnd((dynamic)right);
        }
        public override Value Visit(Or node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolOr((dynamic)right);

        }
        public override Value Visit(Equal node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolEqual((dynamic)right);
        }
        public override Value Visit(NotEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.BoolNotEqual((dynamic)right);
        }
        public override Value Visit(GreaterThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Greater((dynamic)right);
        }
        public override Value Visit(GreaterThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.GreaterEqual((dynamic)right);
        }
        public override Value Visit(LessThan node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Less((dynamic)right);
        }
        public override Value Visit(LessThanOrEqual node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.LessEqual((dynamic)right);
        }
        #endregion

        #region Unary Expressions
        public override Value Visit(Negate node)
        {

            Value value = node.Accept(this);
            return value.Negate();
        }
        public override Value Visit(Priority node)
        {
            return node.GetChildExpression().Accept(this);
        }
        #endregion

        #region Arithmetic

        public override Value Visit(Add node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Add((dynamic)right);
        }

        public override Value Visit(Subtract node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Substract((dynamic)right);
        }

        public override Value Visit(Multiply node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Multiply((dynamic)right);
        }

        public override Value Visit(Divide node)
        {
            Value left = node.Left().Accept(this);
            Value right = node.Right().Accept(this);

            return left.Divide((dynamic)right);
        }


        #endregion

        #region Values
        public override Value Visit(Literals.Bool node)
        {
            return new Bool(node.GetValue());
        }

        public override Value Visit(Literals.Int node)
        {
            return new Int(node.GetValue());
        }

        public override Value Visit(Literals.String node)
        {
            return new String(node.GetValue());
        }
        #endregion

        public override Value Visit(Id node)
        {
            return symbolTable.GetValue(node);
        }

        public override Value Visit(Label node)
        {
            return new String(node.Value);
        }
    }
}
