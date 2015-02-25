using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.AST.Model.Statements;
using UvA.SoftCon.Questionnaire.AST.Types;

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

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.Boolean;
        }

        public override IValue Evaluate(IDictionary<string, IValue> environment)
        {
            return new BoolValue(Value);
        }
    }
}
