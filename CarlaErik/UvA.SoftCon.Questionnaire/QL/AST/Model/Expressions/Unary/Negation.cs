using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary
{
    public class Negation : UnaryExpression
    {
        public Negation(Operation operation, IExpression operand, TextPosition position)
            :base(operation, operand, position)
        {
        }

        public override void Accept(IQLVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }

        public override bool OperandTypeIsValid(DataType operandType)
        {
            return (operandType == DataType.Boolean);
        }

        public override string ToString()
        {
            return String.Format("{0}{1}", StringEnum.GetStringValue(Operation), Operand.ToString());
        }
    }
}
