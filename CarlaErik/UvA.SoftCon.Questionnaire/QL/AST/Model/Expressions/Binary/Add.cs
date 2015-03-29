using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public class Add : BinaryExpression
    {
        internal Add(Operation operation, Expression left, Expression right, TextPosition position)
            : base(operation, left, right, position) {}

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
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
