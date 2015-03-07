using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Unary
{
    public abstract class UnaryExpression : QLNode, IExpression
    {
        public Operation Operation
        {
            get;
            private set;
        }

        public IExpression Operand
        {
            get;
            private set;
        }

        public IExpression Right
        {
            get;
            private set;
        }

        public UnaryExpression(Operation operation, IExpression operand, TextPosition position)
            : base(position)
        {
            Operation = operation;
            Operand = operand;
        }

        public abstract DataType GetType(IDictionary<string, DataType> symbolTable);

        public abstract bool OperandTypeIsValid(DataType operandType);
    }
}
