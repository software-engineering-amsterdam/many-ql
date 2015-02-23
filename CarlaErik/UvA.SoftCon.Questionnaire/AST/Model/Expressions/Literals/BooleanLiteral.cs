using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions.Literals
{
    /// <summary>
    /// Represents a static, immutable boolean value.
    /// </summary>
    public class BooleanLiteral : Literal<bool>
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.BooleanLiteral;
            }
        }

        public BooleanLiteral(bool value, TextPosition position)
            : base(value, position)
        {
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }
    }
}
