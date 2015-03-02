using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable integer value.
    /// </summary>
    public class IntegerLiteral : Literal<int>
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.IntegerLiteral;
            }
        }

        public IntegerLiteral(int value, TextPosition position)
            : base(value, position) { }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override T Accept<T>(IASTVisitor<T> visitor)
        {
            return visitor.Visit(this);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Integer;
        }
    }
}
