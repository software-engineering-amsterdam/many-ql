using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
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
    }
}
