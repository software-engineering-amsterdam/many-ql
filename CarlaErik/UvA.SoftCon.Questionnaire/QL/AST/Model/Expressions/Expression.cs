using System.Collections.Generic;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions
{
    public abstract class Expression : QLNode
    {
        protected Expression(TextPosition position)
            : base(position) { }

        public abstract DataType GetType(IDictionary<string, DataType> symbolTable);
    }
}
