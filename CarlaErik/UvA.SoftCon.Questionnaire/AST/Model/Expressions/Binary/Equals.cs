using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Binary
{
    public class Equals : BinaryExpression
    {
        public override Value Evaluate(IDictionary<string, Value> environment)
        {
            Value left = Left.Evaluate(environment);
            Value right = Right.Evaluate(environment);

            return left.EqualsTo(right);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }
    }
}
