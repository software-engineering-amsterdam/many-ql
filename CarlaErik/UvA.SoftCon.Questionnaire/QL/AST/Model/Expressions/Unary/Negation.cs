using System;
using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary
{
    public class Negation : UnaryExpression
    {
        internal Negation(Operation operation, Expression operand, TextPosition position)
            :base(operation, operand, position)
        {
        }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
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
