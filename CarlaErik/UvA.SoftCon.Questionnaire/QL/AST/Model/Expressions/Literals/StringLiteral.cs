using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.QL.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QL.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable string value.
    /// </summary>
    public class StringLiteral : Literal<string>
    {
        public override bool IsValid
        {
            get
            {
                return true;
            }
        }

        internal StringLiteral(string value, TextPosition position)
            : base(value, position) { }

        public override T Accept<T>(IQuestionFormVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.String;
        }

        public override string GetValue()
        {
            return Value;
        }

        public override string ToString()
        {
            return '"' + Value + '"';
        }
    }
}
