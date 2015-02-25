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

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override DataType? GetType(IDictionary<string, DataType> symbolTable)
        {
            return DataType.String;
        }

        public override IValue Evaluate(IDictionary<string, IValue> environment)
        {
            return new StringValue(Value);
        }

        public override string ToString()
        {
            return '"' + Value + '"';
        }
    }
}
