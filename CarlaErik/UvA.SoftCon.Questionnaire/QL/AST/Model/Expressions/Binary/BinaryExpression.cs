using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Utilities;
using UvA.SoftCon.Questionnaire.Utilities.AST;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Binary
{
    public abstract class BinaryExpression : QLNode, IExpression
    {
        public Operation Operation
        {
            get;
            private set;
        }

        public IExpression Left
        {
            get;
            private set;
        }

        public IExpression Right
        {
            get;
            private set;
        }

        public BinaryExpression(Operation operation, IExpression left, IExpression right, TextPosition position)
            : base(position)
        {
            Operation = operation;
            Left = left;
            Right = right;
        }

        public abstract DataType GetType(IDictionary<string, DataType> symbolTable);

        public abstract bool OperandTypesAreValid(DataType leftType, DataType rightType);

        public override string ToString()
        {
            return String.Format("{0} {1} {2}", Left.ToString(), StringEnum.GetStringValue(Operation), Right.ToString());
        }
    }
}
