using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class Divide : BinaryExpression
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Divide;
            }
        }

        public Divide(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }

        public override IValue Evaluate(IDictionary<string, IValue> environment)
        {
            IValue left = Left.Evaluate(environment);
            IValue right = Right.Evaluate(environment);

            return left.DividedBy(right);
        }
    }
}
