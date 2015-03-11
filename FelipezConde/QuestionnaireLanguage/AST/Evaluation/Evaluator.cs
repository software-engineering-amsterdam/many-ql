using AST.Nodes.Interfaces;
using AST.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AST.Nodes.Expression.Binary;
using AST.Nodes.Expression.Unary;
using AST.Nodes.Expression;
using AST.Nodes.Values;
using AST.Storage;
namespace AST.Evaluation
{
    public class Evaluator : BaseVisitor<Value>
    {
        ISymbolTable symbolTable;

        public Evaluator()
        {
            this.symbolTable = new SymbolTable();
        }

        public Value Evaluate(IExpression expression)
        {
            return expression.Accept(this);
        }

        public void AddValue(Id key, Value value)
        {
            this.symbolTable.AddValue(key, value);
        }

        public void UpdateValue(Id key, Value value)
        {
                this.symbolTable.SetUpdateValue(key, value);
        }

        public Value GetValue(Id key)
        {
            Value result = null;
            result = this.symbolTable.GetValue(key);
            return result;
        }


        public override Value Visit(Container node)
        {
            return node.Value.Accept(this);
        }

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
        public override Value Visit(Bool node)
        {
            return new Bool(node.GetValue());
        }

        public override Value Visit(Int node)
        {
            return new Int(node.GetValue());
        }

        public override Value Visit(Nodes.Values.String node)
        {
            return new Nodes.Values.String(node.GetValue());
        }
        #endregion

        public override Value Visit(Id node)
        {
            return this.GetValue(node);
        }
        
        public override Value Visit(Nodes.Labels.Label node)
        {
            return new Nodes.Values.String(node.Value);
        }

    }
}
