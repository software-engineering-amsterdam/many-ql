using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable string value.
    /// </summary>
    public class StringLiteral : Literal<string>
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.StringLiteral;
            }
        }

        public StringLiteral(string value, TextPosition position)
            : base(value, position) { }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.String;
        }

        public override string ToString()
        {
            return '"' + Value + '"';
        }
    }
}
