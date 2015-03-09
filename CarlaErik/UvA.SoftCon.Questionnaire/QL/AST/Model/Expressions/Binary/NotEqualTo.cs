using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public class NotEqualTo : BinaryExpression
    {
        internal NotEqualTo(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(operation, left, right, position) {}

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

        public override bool OperandTypesAreValid(DataType leftType, DataType rightType)
        {
            return (leftType == rightType);
        }
    }
}
