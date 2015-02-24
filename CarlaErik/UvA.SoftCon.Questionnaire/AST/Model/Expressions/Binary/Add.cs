using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class Add : BinaryExpression
    {
        public Value Evaluate(IDictionary<string, Value> environment)
        {
            Integer left = (Integer)Left.Evaluate(environment);
            Integer right = (Integer)Right.Evaluate(environment);

            return new Integer(left.Value + right.Value);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }
    }
}
