using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public class NotEqualTo : BinaryExpression
    {
        internal NotEqualTo(Operation operation, Expression left, Expression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }

        public override bool OperandTypesAreValid(DataType leftType, DataType rightType)
        {
            return (leftType == rightType);
        }
    }
}
