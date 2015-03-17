using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary
{
    public abstract class UnaryExpression : Expression
    {
        public Operation Operation
        {
            get;
            private set;
        }

        public Expression Operand
        {
            get;
            private set;
        }

        public Expression Right
        {
            get;
            private set;
        }

        internal UnaryExpression(Operation operation, Expression operand, TextPosition position)
            : base(position)
        {
            Operation = operation;
            Operand = operand;
        }

        public abstract bool OperandTypeIsValid(DataType operandType);
    }
}
