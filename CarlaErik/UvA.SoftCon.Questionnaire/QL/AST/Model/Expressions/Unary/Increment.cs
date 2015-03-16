using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary
{
    public class Increment : UnaryExpression
    {
        internal Increment(Operation operation, Expression operand, TextPosition position)
            :base(operation, operand, position)
        {
        }

        public override T Accept<T>(IQLVisitor<T> visitor)
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
