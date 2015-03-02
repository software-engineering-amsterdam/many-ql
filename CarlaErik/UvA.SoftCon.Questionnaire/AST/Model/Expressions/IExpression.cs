using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    public interface IExpression : INode
    {
        DataType? GetType(IDictionary<string, DataType> symbolTable);
    }
}
