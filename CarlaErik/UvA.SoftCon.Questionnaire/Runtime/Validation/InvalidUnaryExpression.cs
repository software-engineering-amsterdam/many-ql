using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Represents a unary expression which operator is not compatible with its operand.
    /// </summary>
    public class InvalidUnaryExpression
    {
        public DataType OperandType
        {
            get;
            private set;
        }

        public UnaryExpression Expression
        {
            get;
            private set;
        }

        public InvalidUnaryExpression(UnaryExpression expression, DataType operandType)
        {
            Expression = expression;
            OperandType = operandType;
        }
    }
}
