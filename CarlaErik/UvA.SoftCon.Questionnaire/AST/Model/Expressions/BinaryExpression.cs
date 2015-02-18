using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public class BinaryExpression : Node, IExpression
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

        public BinaryExpression(Operation operation, IExpression left, IExpression right)
        {
            Operation = operation;
            Left = left;
            Right = right;
        }
    }
}
