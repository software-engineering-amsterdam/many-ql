using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.Runtime.Validation
{
    /// <summary>
    /// Represents a binary expression which operator is not compatible with its operands.
    /// </summary>
    public class InvalidBinaryExpression
    {
        public DataType LeftType
        {
            get;
            private set;
        }

        public DataType RightType
        {
            get;
            private set;
        }

        public BinaryExpression Expression
        {
            get;
            private set;
        }

        public InvalidBinaryExpression(BinaryExpression expression, DataType leftType, DataType rightType)
        {
            Expression = expression;
            LeftType = leftType;
            RightType = rightType;
        }
    }
}
