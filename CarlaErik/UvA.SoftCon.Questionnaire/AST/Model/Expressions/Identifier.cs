using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace UvA.SoftCon.Questionnaire.AST.Model.Expressions
{
    /// <summary>
    /// A name that uniquely defines or refers to a variable or question.
    /// </summary>
    public class Identifier : Node, IExpression
    {
        public override NodeType Type
        {
            get
            {
                return NodeType.Identifier;
            }
        }

        public string Name
        {
            get;
            private set;
        }

        public Identifier(string name, TextPosition position)
            : base(position)
        {
            Name = name;
        }

        public override void Accept(IASTVisitor visitor)
        {
            visitor.Visit(this);
        }

        public override string ToString()
        {
            return Name;
        }
    }
}
