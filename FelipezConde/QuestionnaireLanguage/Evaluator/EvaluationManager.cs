using AST.Nodes;
using AST.Nodes.Expressions.Binary;
using AST.Nodes.Expressions.Unary;
using AST.Nodes.Interfaces;
using AST.Nodes.Labels;
using AST.Nodes.Literals;
using AST.ASTVisitors;
using Evaluator.Storage;
using AST.Nodes.Expressions;

namespace Evaluation
{
    public class EvaluationManager : BaseVisitor<Literal>
    {
        public EvaluationManager()
        {
        }

        #region Operations
        public Literal Evaluate(Expression expression)
        {
            return expression.Accept(this);
        }
        #endregion
        
        #region Comparison
        public override Literal Visit(And node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.BoolAnd((dynamic)right);
        }
        public override Literal Visit(Or node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.BoolOr((dynamic)right);

        }
        public override Literal Visit(Equal node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.BoolEqual((dynamic)right);
        }
        public override Literal Visit(NotEqual node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.BoolNotEqual((dynamic)right);
        }
        public override Literal Visit(GreaterThan node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Greater((dynamic)right);
        }
        public override Literal Visit(GreaterThanOrEqual node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.GreaterEqual((dynamic)right);
        }
        public override Literal Visit(LessThan node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Less((dynamic)right);
        }
        public override Literal Visit(LessThanOrEqual node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.LessEqual((dynamic)right);
        }
        #endregion

        #region Unary Expressions
        public override Literal Visit(Negate node)
        {

            Literal value = node.Accept(this);
            return value.Negate();
        }
        public override Literal Visit(Priority node)
        {
            return node.GetChildExpression().Accept(this);
        }
        #endregion

        #region Arithmetic

        public override Literal Visit(Add node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Add((dynamic)right);
        }

        public override Literal Visit(Subtract node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Substract((dynamic)right);
        }

        public override Literal Visit(Multiply node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Multiply((dynamic)right);
        }

        public override Literal Visit(Divide node)
        {
            Literal left = node.Left().Accept(this);
            Literal right = node.Right().Accept(this);

            return left.Divide((dynamic)right);
        }


        #endregion

        #region Values
        public override Literal Visit(Bool node)
        {
            return new Bool(node.GetValue(), node.GetPosition());
        }

        public override Literal Visit(Int node)
        {
            return new Int(node.GetValue(), node.GetPosition());
        }

        public override Literal Visit(String node)
        {
            return new String(node.GetValue(), node.GetPosition());
        }
        #endregion

        public override Literal Visit(Id node)
        {
            return SymbolTable.GetValue(node);
        }

        public override Literal Visit(Label node)
        {
            return new String(node.Value, node.GetPosition());
        }
    }
}
