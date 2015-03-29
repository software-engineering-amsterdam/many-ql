using System;
using UvA.SoftCon.Questionnaire.Common;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public abstract class BinaryExpression : Expression
    {
        public Operation Operation
        {
            get;
            private set;
        }

        public Expression Left
        {
            get;
            private set;
        }

        public Expression Right
        {
            get;
            private set;
        }

        protected BinaryExpression(Operation operation, Expression left, Expression right, TextPosition position)
            : base(position)
        {
            Operation = operation;
            Left = left;
            Right = right;
        }

        public abstract bool OperandTypesAreValid(DataType leftType, DataType rightType);

        public override string ToString()
        {
            return String.Format("{0} {1} {2}", Left.ToString(), StringEnum.GetStringValue(Operation), Right.ToString());
        }
    }
}
