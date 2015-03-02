using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class Add : BinaryExpression
    {
        public Add(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            DataType leftType = Left.GetType(symbolTable);
            DataType rightType = Right.GetType(symbolTable);

            if (leftType == DataType.Integer && rightType == DataType.Integer)
            {
                return DataType.Integer;
            }
            else if (leftType == DataType.String && rightType == DataType.String)
            {
                return DataType.String;
            }
            else
            {
                return DataType.Undefined;
            }
        }

        public override bool OperandTypesAreValid(DataType left, DataType right)
        {
            return(left == DataType.Integer && right == DataType.Integer)
                || (left == DataType.String && right == DataType.String);
        }
    }
}
