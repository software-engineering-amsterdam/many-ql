using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Unary
{
    public class Increment : UnaryExpression
    {
        public Increment(Operation operation, IExpression operand, TextPosition position)
            :base(operation, operand, position)
        {
        }

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
            return DataType.Integer;
        }

        public override bool OperandTypeIsValid(DataType operandType)
        {
            return (operandType == DataType.Integer);
        }

        public override string ToString()
        {
            return String.Format("{0}{1}", Operand.ToString(), StringEnum.GetStringValue(Operation));
        }
    }
}
