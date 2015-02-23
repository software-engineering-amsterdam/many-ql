using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public interface IExpression : INode
    {
        DataType? GetType(IDictionary<string, DataType> symbolTable);

        Value Evaluate(IDictionary<string, Value> environment);
    }
}
