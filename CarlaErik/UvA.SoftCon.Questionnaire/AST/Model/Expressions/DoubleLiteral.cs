using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    /// <summary>
    /// Represents a static, immutable double value.
    /// </summary>
    public class DoubleLiteral : Literal<double>
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.DoubleLiteral;
            }
        }

        public DoubleLiteral(double value, TextPosition position)
            : base(value, position)
        {
        }
    }
}
