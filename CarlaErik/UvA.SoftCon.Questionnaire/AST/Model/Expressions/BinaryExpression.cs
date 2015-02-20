using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public class BinaryExpression : Node, IExpression
    {
        public Operation Operation
        {
            get;
            private set;
        }

        public IExpression Left
        {
            get;
            private set;
        }

        public IExpression Right
        {
            get;
            private set;
        }

        public BinaryExpression(Operation operation, IExpression left, IExpression right)
        {
            Operation = operation;
            Left = left;
            Right = right;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override string ToString()
        {
            string @operator = "?";

            switch (Operation)
            {
                case Operation.Add:
                    @operator = "+";
                    break;
                case Operation.And:
                    @operator = "&&";
                    break;
                case Operation.Divide:
                    @operator = "/";
                    break;
                case Operation.Equals:
                    @operator = "==";
                    break;
                case Operation.GreaterThan:
                    @operator = ">";
                    break;
                case Operation.GreaterThanOrEqualTo:
                    @operator = ">=";
                    break;
                case Operation.LessThan:
                    @operator = "<";
                    break;
                case Operation.LessThanOrEqualTo:
                    @operator = "<=";
                    break;
                case Operation.Multiply:
                    @operator = "*";
                    break;
                case Operation.NotEquals:
                    @operator = "!=";
                    break;
                case Operation.Or:
                    @operator = "||";
                    break;
                case Operation.Substract:
                    @operator = "-";
                    break;
            }

            return String.Format("{0} {1} {2}", Left.ToString(), @operator, Right.ToString());
        }
    }
}
